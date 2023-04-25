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
from pyecore.ecore import *


class Context(object):
    
    xString = EString
    #xString.name = "EString"
    
    xDouble = EDouble
    #xDouble.name = "EDouble"
    
    xInt = EInt
    #xInt.name = "EInt"
    
    xDate = EDate
    #xDate.name = "EDate"
    # This is the root package where we add each type, class and enum
    typesPackage = EPackage(name='types', nsURI='http://www.eclipse.org/bird/types', nsPrefix='types')
    inputLayerEnumsPackage = EPackage(name='input_layer_enums', nsURI='http://www.eclipse.org/bird/input_layer_enums', nsPrefix='input_layer_enums')
    outputLayerEnumsPackage = EPackage(name='output_layer_enums', nsURI='http://www.eclipse.org/bird/output_layer_enums', nsPrefix='output_layer_enums')
    inputLayerEntitiesPackage = EPackage(name='input_layer_entities', nsURI='http://www.eclipse.org/bird/input_layer_entities', nsPrefix='input_layer_entities')
    outputLayerEntitiesPackage = EPackage(name='output_layer_entities', nsURI='http://www.eclipse.org/bird/output_layer_entities', nsPrefix='output_layer_entities')
    
    logicPackages = []
    # classesMap keeps a reference between ldm ID's for classes and
    # the class instance
    classesMap = {}
    # classesMap keeps a reference between ldm ID's for classes and
    # the list of these calsses that we call tables
    tableMap = {}
    # A map between the LDM names for primitive types types, and
    # our standard primitive types such as XString  
    datatypeMap = {}
    # For the reference output layers we record a map between variables 
    # and domains
    variableToDomainMap = {}
    variableToLongNamesMap = {}
    variableNameToCodeMap = {}
    # For the reference output layers we record a map between domains 
    # and domain names
    domainToDomainNameMap = {}
    # For the reference output layers we record a map between members ids  
    # andtheir containing domains
    memberIDToDomainMap = {}
    # For the reference output layers we record a map between members ids  
    # and their names
    memberIDToMemberNameMap = {}
    # For the reference output layers we record a map between members ids  
    # and their codes
    memberIDToMemberCodeMap = {}
    
    FKtoMandatoryMap = {}
    FKToColumnMap = {}
    # we record a list of missing domains
    missingDomains = []
    # enumMap keeps a reference between ldm ID's for domains and
    # the enum instance
    enumMap = {}
    # the directory where we get our input files
    fileDirectory = ""
    # the directory where we save our outputs.
    outputDirectory = ""
    

    useSubDomains = False
    
    subDomainToMemberListMap = {}
    subDomainIDToDomainID = {}
    
    addExecutableStubs = False
    addLogicPackages = False
    
    useVariableLongName=True
    importLogicStrings = []
    
    variableSetToVariableMap = {}
    
    cubeClassNameIndex = 0
    cubeObjectIDIndex = 1
    cubeCubeTypeIndex = 3
    cubeValidToIndex = 11
    cubeFrameworkIndex = 5
    
    variableVariableNameIndex = 6
    variableLongNameIndex = 4
    variableDomainIndex = 2
    variableCodeIndex = 0
    
    domainDomainIDIndex = 0
    domainDomainNameIndex = 8
    
    memberMemberIDIndex = 4
    memberMemberCodeIndex = 0
    memberMemberNameIndex = 5
    memberDomainIDIndex = 2
    
    subdomainDomainIDIndex = 2
    subDomainSubDomainIDIndex = 8
    
    subdomain_enumerationMemberIDIndex = 0
    subdomain_enumerationSubdomainIDIndex = 2
    subdomain_enumerationValidToIndex = 4
    
    cube_structure_itemVariableIndex = 2
    cube_structure_itemClassIDIndex = 1
    cube_structure_itemSubdomainIndex = 10
    cube_structure_itemSpecificMember = 7
    cube_structure_itemAttributeName = 11
    cube_structure_itemVariableSet = 12

    def __init__(self):

        a=0

        