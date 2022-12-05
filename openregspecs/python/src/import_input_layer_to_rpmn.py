# coding=UTF-8#
# Copyright (c) 2020 Bird Software Solutions Ltd
# This program and the accompanying materials
# are made available under the terms of the Eclipse Public License 2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/legal/epl-2.0/
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
#    Neil Mackenzie - initial API and implementation
#
from pickle import TRUE
'''
Created on 22 Jan 2022

@author: Neil
'''
from open_reg_specs import *
from pyecore.ecore import *
import csv
from Utils import Utils
from context import Context

class InputLayerImport(object):
    

    def doImport(self,context):
        '''
        import the items from the BIRD LDM csv files
        '''
        InputLayerImport.addILClassesToPackage(self,context)
        InputLayerImport.addILEnumsToPackage(self,context)
        InputLayerImport.addILLiteralsToEnums(self,context) 
        InputLayerImport.createILTypesMap(self,context) 
        InputLayerImport.addILAttributesToClasses(self,context) 
        InputLayerImport.createFKToColumnMap(self,context) 
        InputLayerImport.addILRelationshipsBetweenClasses(self,context)
        
   
                        
    def addILClassesToPackage(self,context):
        '''
        for each entity in the IL, create a class and add it to the package
        '''
        
        fileLocation = context.fileDirectory + "\\DM_Tables.csv"
        
        
        headerSkipped = False
        # Load all the entities from the csv file, make an XClass per entity,
        # and add the XClass to the package
        with open(fileLocation) as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                # skip the first line which is the header.
                if (not headerSkipped):
                    headerSkipped = True
                else:

                    className = row[0];
                    objectID = row[1];
                    
                    # assume that SQLDve gives valid IDS fro table names according 
                    # to the validity rules of RPMN
                    alteredClassName = Utils.makeValidID(self,className);
                   
                    if(alteredClassName.endswith("_derived")):
                        xclass = XClass(name=alteredClassName)
                        xclassTable = XClass(name=alteredClassName+"_DerivedTable")
                        xclassTable.containedEntityType = xclass
                        containmentReference  = XReference()
                        containmentReference.name=xclass.name+"s"
                        containmentReference.type=xclass
                        containmentReference.upperBound = -1
                        containmentReference.lowerBound=0
                        containmentReference.containment= True
                        xclassTable.members.append(containmentReference)
                        xclassTableOperation = XOperation()
                        xclassTableOperation.name=xclass.name+"s"
                        xclassTableOperation.type=xclass
                        xclassTableOperation.upperBound = -1
                        xclassTableOperation.lowerBound=0
                        xclassTable.members.append(xclassTableOperation)
                        context.rpmnPackage.classifiers.extend([xclass])
                        context.rpmnPackage.classifiers.extend([xclassTable])
                    elif(className.startswith("OUTPUT_LAYER_")):
                        xclass = XClass(name=alteredClassName)
                        
                        context.rpmnPackage.classifiers.extend([xclass])
                      
                    else:
                        xclass = XClass(name=alteredClassName)
                        # of engineering type is single table, as i should be for all members of a type
                        # heirarchy, and num_suptype is blanck, then this means that this class is a root
                        # of a type heirarchy....we will set such classes to be abstract.
                        xclassTable = XClass(name=alteredClassName+"_BaseTable")
                        containmentReference  = XReference()
                        containmentReference.name=xclass.name+"s"
                        containmentReference.type=xclass
                        containmentReference.upperBound = -1
                        containmentReference.lowerBound=0
                        containmentReference.containment= True
                        xclassTable.members.append(containmentReference)
                        context.rpmnPackage.classifiers.extend([xclass])
                        context.rpmnPackage.classifiers.extend([xclassTable])
        
                    # maintain a map a objectIDs to XClasses
                    context.classesMap[objectID]=xclass
                    context.tableMap[xclass]=xclassTable
         
                        
                       
    def addILEnumsToPackage(self,context):
        '''
        for each domain in the IL add an enum to the package
        '''
        fileLocation = context.fileDirectory + "\\DM_Domains.csv"
        headerSkipped = False
        counter = 0
        # Create an XEnum for each domain, and add it to the XPackage
        with open(fileLocation) as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                if (not headerSkipped):
                        headerSkipped = True
                else:
                    counter=counter+1
                    enumID = row[0]
                    enumName = row[1]
                    adaptedEnumName = Utils.makeValidID(self,enumName)+"_domain"
                    if(not Utils.inEnumBlackList(self,adaptedEnumName)):
                        theEnum = XEnum()
                        theEnum.name = adaptedEnumName
                        #maintain a map of enum IDS to XEnum objects
                        context.enumMap[enumID] = theEnum
                        context.rpmnPackage.classifiers.extend([theEnum])
                        
    def addILLiteralsToEnums(self,context):
        '''
        for each memebr of a domain the IL, add a literal to the corresponding enum
        '''
        fileLocation = context.fileDirectory + "\\DM_Domain_AVT.csv"
        headerSkipped = False
        counter = 0
        # Add the members of a domain as literals of the related Enum
        with open(fileLocation) as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                if (not headerSkipped):
                        headerSkipped = True
                else:
                    try:
                        counter=counter+1
                        enumID = row[0]
                        enumUsedName = Utils.makeValidID(self,row[3])
                        #enumName = row[5]
                        adaptedEnumName = Utils.makeValidID(self,enumUsedName)
                        value = row[4]
                        adaptedValue = Utils.makeValidID(self,value)
                        try:
                            theEnum = context.enumMap[enumID]
                            newAdaptedValue = Utils.uniqueValue(self,theEnum,adaptedValue)
                            newAdaptedName = Utils.uniqueName(self,theEnum,adaptedEnumName)
                            enumLiteral = XEnumLiteral()
                            enumLiteral.name = newAdaptedName
                            enumLiteral.literal = newAdaptedValue
                            enumLiteral.value = counter
                            theEnum.literals.extend([enumLiteral])
                                
                        except KeyError:
                            print( "missing domain: " + enumID )
                             
                    except IndexError:
                        print( "row in DM_Domain_AVT.csv skipped  due to improper formatting at row number")
                        print(counter)

    def createILTypesMap(self,context):                
        # for each logicalDatatype for orcle 12c, make a Datatype if we have an
        # equivalent
        
        fileLocation = context.fileDirectory + "\\DM_Logical_To_Native.csv"
        headerSkipped = False
        with open(fileLocation) as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                if (not headerSkipped):
                        headerSkipped = True
                else:
                    rdbms_Type = row[3]
                    rdbms_Version = row[4]
                    dataTypeID = row[0]
                    if ((rdbms_Type.strip() == "Oracle Database") and (rdbms_Version.strip() =="12cR2")):
                        native_type = row[2]

                        if (native_type.strip() == "VARCHAR") :

                            context.datatypeMap[dataTypeID] = context.xString
                      
                        if (native_type.strip() == "VARCHAR2") :

                            context.datatypeMap[dataTypeID] = context.xString
                      
                        if (native_type.strip() == "INTEGER") :

                            context.datatypeMap[dataTypeID] = context.xInt
                      
                        if (native_type.strip() == "DATE") :

                            context.datatypeMap[dataTypeID] = context.xDate
                        
                        if (native_type.strip() == "NUMBER") :

                            context.datatypeMap[dataTypeID] = context.xDouble
                        
                        if (native_type.strip() == "UNKNOWN") :

                            context.datatypeMap[dataTypeID] = context.xString
        
                                     
    def addILAttributesToClasses(self,context):
        '''
        For each attribute on an entity of the IL, add an attribute
        to the relevant class in the package
        '''
            
        fileLocation = context.fileDirectory + "\\DM_Columns.csv"
        headerSkipped = False
        # For each attribute add an XAttribute to the correct XClass representing the Entity
        # the attribute should have the correct type, which may be a specific
        # enumeration

        with open(fileLocation) as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                if (not headerSkipped):
                        headerSkipped = True
                else:
                    attributeName = row[0]
                    attributeID = row[1]
                    amendedAttributeName = Utils.makeValidID(self,attributeName);
                    mandatory = row[6]
                    attributeKind = row[7]
                   
                    classID = row[4]
                    relationID = row[35]
                    primary_key_or_not = row[34]
                    theClass = context.classesMap[classID]
                    
                    classIsDerived = False
                    if (theClass.name.endswith("_derived")):
                        classIsDerived = True
                        
                    theAttributeName =  amendedAttributeName
                    
                    # we only add attributes here if they are not representing a relationship
                    if relationID == "":
                        
                        if (attributeKind == "Domain"):
                            enumID = row[13]
                            theEnum = context.enumMap[enumID]
                            
                            attribute = XAttribute()
                            if(primary_key_or_not == "P"):
                                attribute.iD = True
                                
                            attribute.lowerBound=0
                            attribute.upperBound=1
                            if(theEnum.name == "String"):
                                attribute.name = theAttributeName
                                attribute.type = context.xString
                            elif(theEnum.name.startswith("String_")):
                                attribute.name = theAttributeName
                                attribute.type = context.xString
                            elif(theEnum.name == "Number"):
                                attribute.name = theAttributeName
                                attribute.type = context.xDouble
                            elif(theEnum.name.startswith("Real_")):
                                attribute.name = theAttributeName
                                attribute.type = context.xDouble
                            elif(theEnum.name.startswith("Monetary")):
                                attribute.name = theAttributeName
                                attribute.type = context.xInt
                            elif(theEnum.name.startswith("Non_negative_monetary_amounts_with_2_decimals")): 
                                attribute.name = theAttributeName
                                attribute.type = context.xInt
                            elif(theEnum.name.startswith("Non_negative_integers")): 
                                attribute.name = theAttributeName
                                attribute.type = context.xInt
                            elif(theEnum.name.startswith("All_possible_dates")):
                                attribute.name = theAttributeName
                                attribute.type = context.xDate
                                
                            # This is a common domain used for String identifiers in BIRD in SQLDeveloper
                            
                            else:
                                attribute.name = theAttributeName
                                attribute.type = theEnum  
                            
                            if classIsDerived:
                                operation = XOperation()
                                operation.lowerBound=0
                                operation.upperBound=1
                                if(theEnum.name == "String"):
                                    operation.name = theAttributeName
                                    operation.type = context.xString
                                elif(theEnum.name.startswith("String_")):
                                    operation.name = theAttributeName
                                    operation.type = context.xString
                                elif(theEnum.name == "Number"):
                                    operation.name = theAttributeName
                                    operation.type = context.xDouble
                                
                                elif(theEnum.name.startswith("Real_")):
                                    operation.name = theAttributeName
                                    operation.type = context.xDouble
                                elif(theEnum.name.startswith("Monetary")): 
                                    operation.name = theAttributeName
                                    operation.type = context.xInt
                                elif(theEnum.name.startswith("Non_negative_monetary_amounts_with_2_decimals")): 
                                    operation.name = theAttributeName
                                    operation.type = context.xInt
                                elif(theEnum.name.startswith("Non_negative_integers")): 
                                    operation.name = theAttributeName
                                    operation.type = context.xInt
                                elif(theEnum.name.startswith("All_possible_dates")):   
                                    operation.name = theAttributeName
                                    operation.type = context.xDate  
                                else:
                                    operation.name = theAttributeName
                                    operation.type = theEnum  
                                          
    
                        if (attributeKind == "Logical Type"):
                            print("Logical Type")
                            dataTypeID = row[14]
                            try:
                                datatype = context.datatypeMap[dataTypeID]
                                attribute = XAttribute()
                                attribute.lowerBound=0
                                attribute.upperBound=1
                                attribute.name =amendedAttributeName
                                attribute.type = Utils.getEcoreDataTypeForDataType(self)
                                
                                if classIsDerived:
                                    operation = XOperation()
                                    operation.lowerBound=0
                                    operation.upperBound=1
                                    operation.name =amendedAttributeName
                                    operation.type = Utils.getEcoreDataTypeForDataType(self)
                                
                            except KeyError:
                                print("missing datatype: ")
                                print(dataTypeID)                       
    
                        
    
                        try:
    
                            theClass = context.classesMap[classID]
                            theClass.members.extend([attribute])
                            if classIsDerived:
                                theClass.members.extend([operation])
    
                        except:
                            print( "missing class2: " )
                            print(classID)
                    else:
                        if mandatory == "Y":
                            context.FKtoMandatoryMap[attributeID] = "M"  
                        
    def createFKToColumnMap(self,context):
        fileLocation = context.fileDirectory + "\\DM_Constr_Index_Columns.csv"
        headerSkipped = False
        with open(fileLocation) as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                if (not headerSkipped):
                        headerSkipped = True
                else:
                    fk_name = row[6]
                    columnID = row[2]
                    context.FKToColumnMap[fk_name] = columnID
                
    def addILRelationshipsBetweenClasses(self,context):
        '''
        For each relationship in the IL, add a reference between the relevant classes
        '''    
        fileLocation = context.fileDirectory + "\\DM_ForeignKeys.csv"
        headerSkipped = False
        with open(fileLocation) as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                if (not headerSkipped):
                        headerSkipped = True
                else:
                    fk_id = row[0]
                    sourceID = row[10]
                    targetID = row[12]
                    
                    targetClassName = row[7]
                    
                    fkColumnnID = context.FKToColumnMap[fk_id]
                    
                    if fkColumnnID in context.FKtoMandatoryMap:
                        target_Optional = "N"
                    else:
                        target_Optional = "Y"
                        
                    sourceTo_Target_Cardinality = "1"
                    
                    referenceName = "the" + Utils.makeValidID(self,targetClassName);

                    try:
                        theClass = context.classesMap[sourceID]
                    except KeyError:
                        print("missing class1: " + sourceID)
                    
                    try:   
                        targetClass = context.classesMap[targetID] 
                    except KeyError:
                        print("missing target class: " + targetID) 
                                          
                    numOfRelations = Utils.numberofRelationShipsToThisClass(self,theClass,targetClass)
                    if(numOfRelations>0):
                        print("numOfRelations")
                        print(numOfRelations)
                        referenceName = referenceName + str(numOfRelations)
                    relationalAttribute = None
                    if (target_Optional.strip() == "Y"):
                        if (sourceTo_Target_Cardinality.strip() == "*"):
                            referenceName = referenceName + "s"
                            eReference  = XReference()
                            eReference.name=referenceName
                            eReference.type=targetClass
                            #upper bound of -1 means there is no upper bounds, so represents an open list of reference
                            eReference.upperBound = -1
                            eReference.lowerBound=0
                            eReference.containment= False
                            if (theClass.name.endswith("_derived")):
                                theSourceTable = context.tableMap[theClass]
                                theTargetTable = context.tableMap[targetClass]
                                if not(Utils.hasMemberCalled(self, theSourceTable, "sourceTable1")):
                                   
                                    sourceTablesReference  = XReference()
                                    sourceTablesReference.name="sourceTable1"
                                    sourceTablesReference.type=theTargetTable
                                    sourceTablesReference.upperBound = -1
                                    sourceTablesReference.lowerBound=0
                                    sourceTablesReference.containment= False
                                    theSourceTable.members.append(sourceTablesReference)
                                else:
                                   
                                    sourceTablesReference  = XReference()
                                    sourceTablesReference.name="sourceTable2"
                                    sourceTablesReference.type=theTargetTable
                                    sourceTablesReference.upperBound = -1
                                    sourceTablesReference.lowerBound=0
                                    sourceTablesReference.containment= False
                                    theSourceTable.members.append(sourceTablesReference)
                        else:
                            eReference  = XReference()
                            eReference.name=referenceName
                            eReference.type=targetClass
                            eReference.upperBound = 1
                            eReference.lowerBound=0
                            eReference.containment= False
                            if (theClass.name.endswith("_derived")):
                                theSourceTable = context.tableMap[theClass]
                                theTargetTable = context.tableMap[targetClass]
                                if not(Utils.hasMemberCalled(self, theSourceTable, "sourceTable1")):
                                    
                                    sourceTablesReference  = XReference()
                                    sourceTablesReference.name="sourceTable1"
                                    sourceTablesReference.type=theTargetTable
                                    sourceTablesReference.upperBound = -1
                                    sourceTablesReference.lowerBound=0
                                    sourceTablesReference.containment= False
                                    theSourceTable.members.append(sourceTablesReference)
                                else:
                                    
                                    sourceTablesReference  = XReference()
                                    sourceTablesReference.name="sourceTable2"
                                    sourceTablesReference.type=theTargetTable
                                    sourceTablesReference.upperBound = -1
                                    sourceTablesReference.lowerBound=0
                                    sourceTablesReference.containment= False
                                    theSourceTable.members.append(sourceTablesReference)                 
                    else:
                        if (sourceTo_Target_Cardinality.strip() == "*"):
                            referenceName = referenceName + "s"                       
                            eReference  = XReference()
                            eReference.name=referenceName
                            eReference.type=targetClass
                            eReference.upperBound = -1
                            eReference.lowerBound=1
                            eReference.containment= False
                            if (theClass.name.endswith("_derived")):

                                theSourceTable = context.tableMap[theClass]
                                theTargetTable = context.tableMap[targetClass]
                                if not(Utils.hasMemberCalled(self, theSourceTable, "sourceTable1")):
                                    
                                    sourceTablesReference  = XReference()
                                    sourceTablesReference.name="sourceTable1"
                                    sourceTablesReference.type=theTargetTable
                                    sourceTablesReference.upperBound = -1
                                    sourceTablesReference.lowerBound=0
                                    sourceTablesReference.containment= False
                                    theSourceTable.members.append(sourceTablesReference)
                                else:
                                    sourceTablesReference = XReference("sourceTable2", theTargetTable, upper=-1, lower=0, containment=False)
                                    theSourceTable.members.append(sourceTablesReference)                       
                        else:      
                            eReference  = XReference()
                            eReference.name=referenceName
                            eReference.type=targetClass
                            eReference.upperBound = 1
                            eReference.lowerBound=1
                            eReference.containment= False
                            if (theClass.name.endswith("_derived")):
                                theSourceTable = context.tableMap[theClass]
                                theTargetTable = context.tableMap[targetClass]
                                if not(Utils.hasMemberCalled( theSourceTable, "sourceTable1")):
                                    
                                    sourceTablesReference  = XReference()
                                    sourceTablesReference.name="sourceTable1"
                                    sourceTablesReference.type=theTargetTable
                                    sourceTablesReference.upperBound = -1
                                    sourceTablesReference.lowerBound=0
                                    sourceTablesReference.containment= False
                                    theSourceTable.members.append(sourceTablesReference)
                                else:
                                    
                                    sourceTablesReference  = XReference()
                                    sourceTablesReference.name="sourceTable2"
                                    sourceTablesReference.type=theTargetTable
                                    sourceTablesReference.upperBound = -1
                                    sourceTablesReference.lowerBound=0
                                    sourceTablesReference.containment= False
                                    theSourceTable.members.append(sourceTablesReference)
                    if (not (theClass is None) ) :                 
                        theClass.members.append(eReference)
                        
    
            
