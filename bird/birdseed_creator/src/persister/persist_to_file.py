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
import os
from pyecore.resources import ResourceSet, URI
from pyecore.resources.json import JsonResource
from utils.utils import Utils


from regdna import ELAttribute, ELClass, ELEnum, ELPublicOperation, ELReference,SelectColumnAttributeAs


class PersistToFile:
    '''
    Documentation for PersistToFile
    '''

    def save_model_as_regdna_file(self, context):
        '''
        Save resources as regdna files
        '''
        if context.load_eil_from_website:
            PersistToFile.persist_entity_model(
                self, context, context.input_tables_package,
                "regdna", context.sdd_domains_package)
        else:        
            PersistToFile.persist_entity_model(
                self, context, context.input_tables_package,
                "regdna", context.il_domains_package)

        PersistToFile.persist_entity_model(
            self, context, context.output_tables_package,
            "regdna", context.sdd_domains_package)
        PersistToFile.persist_enum_model(
            self, context, context.il_domains_package, "regdna")
        PersistToFile.persist_enum_model(
            self, context, context.sdd_domains_package, "regdna")
        PersistToFile.persist_types_model(
            self, context, context.types_package, "regdna")
        

    def persist_entity_model(self, context, the_package, extension, imported_package):
        '''
        Documentation for persist_entity_model
        '''

        f = open(context.output_directory + os.sep + extension +
                 os.sep + the_package.name + '.' + extension,
                 "a",  encoding='utf-8')
        f.write("\t\t package " + the_package.name + "\r")
        f.write("\t\t import " + imported_package.name + ".*\r")
        if the_package == context.output_tables_package:
            for import_string in context.import_logic_strings:
                f.write("\t\t import " + import_string + ".*\r")
        if extension == "regdna":
            f.write("\t\t import types.*\r")
        for classifier in the_package.eClassifiers:
            if isinstance(classifier, ELClass):
                f.write("\t\t\t")
                if classifier.eAbstract:
                    f.write("abstract ")
                f.write("class " + classifier.name)
                if (hasattr(classifier, "eSuperTypes") and len(classifier.eSuperTypes) > 0):
                    f.write(" extends " + classifier.eSuperTypes[0].name)
                f.write(" {\r")
                for member in classifier.eStructuralFeatures:

                    if isinstance(member, ELReference):
                        if member.containment:
                            f.write("\t\t\t\tcontains ")
                        else:
                            f.write("\t\t\t\trefers ")

                        f.write(member.eType.name + " ")
                        if ((member.lowerBound == 0) and (member.upperBound == 1)):
                            f.write(" ")
                        else:
                            upperBoundNumber = member.upperBound
                            upperBoundString = str(member.upperBound)
                            
                            
                            f.write("[" + str(member.lowerBound) +
                                    ".." + upperBoundString + "] ")

                        f.write(member.name)
                        f.write(" \r")
                    elif isinstance(member, ELAttribute):
                        f.write("\t\t\t\t")
                        if member.iD:
                            f.write("id ")

                        if member.eType.name == "String":
                            f.write("String  ")
                        elif member.eType.name == "Double":
                            f.write("double  ")
                        elif member.eType.name == "Integer":
                            f.write("int  ")
                        elif member.eType.name == "Date":
                            f.write("Date  ")
                        else:
                            f.write(member.eType.name + " ")

                        if ((member.lowerBound == 0) and (member.upperBound == 1)):
                            f.write(" ")
                        else:
                            upperBoundNumber = member.upperBound
                            upperBoundString = str(member.upperBound)
                           
                            f.write("[" + str(member.lowerBound) +
                                    ".." + upperBoundString + "] ")

                        f.write(member.name)
                        f.write(" \r")

                for member in classifier.eOperations:
                    if isinstance(member, ELPublicOperation):
                        f.write("\t\t\t\top ")

                        f.write(member.eType.name + " ")
                        if ((member.lowerBound == 0) and (member.upperBound == 1)):
                            f.write(" ")
                        else:
                            upperBoundNumber = member.upperBound
                            upperBoundString = str(member.upperBound)                            
                            
                            f.write("[" + str(member.lowerBound) +
                                    ".." + upperBoundString + "] ")
                            
                        f.write(member.name)
                        f.write("() {}")
                            
                        f.write(" \r")

                f.write("\t\t\t}\r")

        f.close()

    def persist_types_model(self, context, the_package, extension):
        '''
        Documentation for persist_types_model
        '''
        f = open(context.output_directory + os.sep + extension +
                 os.sep + the_package.name +
                 '.' + extension, "a",  encoding='utf-8')
        f.write("\t\t package " + the_package.name + "\r")
        f.write("\t\t\ttype double wraps double\r")
        f.write("\t\t\ttype String wraps String\r")
        f.write("\t\t\ttype int wraps int\r")
        if extension == "regdna":
            f.write("\t\t\ttype Date wraps Date\r")
        else:
            f.write("\t\t\ttype Date wraps java.util.Date\r")
        f.write("\t\t\ttype boolean wraps boolean\r")
        f.close()

    def persist_enum_model(self, context, the_package, extension):
        '''
        Documentation for persist_enum_model
        '''
        f = open(context.output_directory + os.sep + extension +
                 os.sep + the_package.name +
                 '.' + extension, "a",  encoding='utf-8')
        f.write("\t\t package " + the_package.name + "\r")
        for classifier in the_package.eClassifiers:

            if isinstance(classifier, ELEnum):
                f.write("\t\t\tenum " + classifier.name)

                f.write(" { ")
                counter = 0
                splitcount = 1
                for the_literal in classifier.eLiterals:
                    counter = counter+1

                    if counter < 1500:
                        f.write(" " + the_literal.name + " as \"" +
                                the_literal.literal + "\" = " + str(the_literal.value))
                    else:
                        counter = 0
                        splitcount = splitcount+1
                        f.write(" }\r")
                        f.write("\t\t\tenum " + classifier.name +
                                "_" + str(splitcount))
                        f.write(" { ")

                f.write(" }\r")

        f.close()

    
    
    def save_model_as_xmi_file(self, context):
        '''
         save model as an xmi file representing an object tree.
        '''
        rset = ResourceSet()

        # This will create an XMI resource
        resource = rset.create_resource(
            URI(context.output_directory + os.sep + 'xmi' + os.sep + 'birdseed.xmi'))
        resource.append(context.module_list)
        resource.save()
    
    def persist_generation_transformations_to_csv(self, context):
        '''
        Documentation for persist_generation_transformations
        '''
        rules_for_reports = context.generation_rules_module.rulesForReport
        report_to_table_parts_file = open(context.output_directory + os.sep + 'generations_transformations_csv' +
                         os.sep + 
                         'report_to_table_parts.csv', "a",  encoding='utf-8')
        report_to_table_parts_file.write("Report,Table Part,Notes\n")

        for rules_for_report in rules_for_reports:
            if not(rules_for_report.outputLayerCube is None): #column.attribute.eContainer().name + "." + column.attribute.name
                
                template = rules_for_report.outputLayerCube.name
                amended_template_name =  template[0:len(template) - 11]
                f = open(context.output_directory + os.sep + 'generations_transformations_csv' +
                         os.sep + 
                         amended_template_name + '.csv', "a",  encoding='utf-8')
                f.write("Template,Table Part,Main Table,Filter,Lineage type,Source Table,Source Column,Missing,Relevant, Derived,Domain,Member,Value,ROL Cube Item,Notes\n")

                for layer in rules_for_report.rulesForTable:
                    table = layer.inputLayerTable.name
                    for table_part in layer.rulesForTablePart:
                        main_catagory = table_part.main_catagory
                        main_catagory_name = context.main_catogory_to_name_map[main_catagory]
                        
                        table_and_part = table_part.table_and_part_tuple
                        report_to_table_parts_file.write(amended_template_name + "," + table_part.name + ",\n")
                        filter = context.table_parts_to_to_filter_map[table_and_part]
                        for column in table_part.columns:
                            if isinstance(column, SelectColumnAttributeAs) and not(column.attribute is None):
                                entity  = column.attribute.eContainer().name
                                attribute = column.attribute.name
                                lineage_type = "attribute"
                                missing = "Not Missing"
                            else:  
                                entity  = ""
                                attribute = ""
                                missing = "Missing"
                                lineage_type = "tbd"
                                
                            variable_id = column.asAttribute.name

                            
                            f.write(amended_template_name +"," + table_part.name +","  +table+"," + filter + ","  +lineage_type+"," +entity+"," +attribute+"," +missing+",,,,,," +variable_id + ",\n")

                f.close()
        report_to_table_parts_file.close

    def persist_generation_transformations(self, context):
        '''
        Documentation for persist_generation_transformations
        '''
        rules_for_reports = context.generation_rules_module.rulesForReport
        for rules_for_report in rules_for_reports:
            if not(rules_for_report.outputLayerCube is None):
                f = open(context.output_directory + os.sep + 'regdna' +
                         os.sep + rules_for_report.outputLayerCube.name +
                         '.regdna', "a",  encoding='utf-8')
                f.write("generationRuleModule " + rules_for_report.outputLayerCube.name + "_generationModule\r{\r")
                f.write("\tgenerationRules " + "{\r")
                f.write("\t\treport output_tables." + rules_for_report.outputLayerCube.name + "{\r")
                for layer in rules_for_report.rulesForTable:
                    if layer.inputLayerTable is None:
                        f.write("\t\t\tILTable None {\r")
                    else:
                        f.write("\t\t\tILTable input_tables." + layer.inputLayerTable.name + "{\r")
                    for table_part in layer.rulesForTablePart:
                        if table_part.name is None:
                            f.write("\t\t\t\ttablePart None { \r")
                        else:
                            f.write("\t\t\t\ttablePart " + Utils.make_valid_id(table_part.name) + " { \r")
                        for column in table_part.columns:
                            if isinstance(column, SelectColumnAttributeAs) and not(column.attribute is None):
                                f.write("\t\t\t\t\tselectAttribute input_tables." + column.attribute.eContainer().name + "." + column.attribute.name)
                            else:  
                                f.write("\t\t\t\t\tselectValue \"TODO\"")
                            f.write(" as output_tables." +
                                    rules_for_report.outputLayerCube.name + "." + column.asAttribute.name + "\r")
                        f.write("\t\t\t\t}\r")
                        
                    f.write("\t\t\t}\r")
                f.write("\t\t}\r")
                f.write("\t}\r")
                f.write("}\r")
               
                f.close()
    
    def persist_reports(self, context):
        '''
        Documentation for persist_generation_transformations
        '''
        reports = context.reports_module.reports
        for report in reports:
            if not(report.outputLayer is None):
                f = open(context.output_directory + os.sep + 'regdna' +
                         os.sep + report.outputLayer.name +
                         '.regdna', "a",  encoding='utf-8')
                f.write("ReportModule " + report.outputLayer.name + "_reportModule\r{\r")
                f.write("\treports " + "{\r")
                f.write("\t\tReport " + "{\r")
                f.write("\t\t\toutputLayer output_tables." + report.outputLayer.name + "\r")
                f.write("\t\t\trows{\r")
                for row in report.rows:                    
                    f.write("\t\t\t\tReportRow " + row.name + "\r")
                f.write("\t\t\t}\r")
                f.write("\t\t\tcolumns{\r")
                for col in report.columns:                    
                    f.write("\t\t\tReportColumn " + col.name + "\r")
                f.write("\t\t\t}\r")
                f.write("\t\t\treportCells{\r")  
                for cell in report.reportCells:                    
                    f.write("\t\t\t\tReportCell{\r")
                    
                    data_point_id = "None"
                    if not (cell.datapointID is None):
                        data_point_id= cell.datapointID
                        
                    row_name = "None"
                    if not (cell.row is None):
                        row_name= cell.row.name
                        
                    col_name = "None"
                    if not (cell.column is None):
                        col_name= cell.column.name

                    metric_name = "None"
                    if not (cell.metric is None):
                        metric_name = "output_tables." + cell.metric.eContainer().name + "." + cell.metric.name
                        
                    
                    
                    f.write("\t\t\t\t\tdatapointID \"" + data_point_id + "\" row " + row_name + " column " + col_name  + " metric " + metric_name+ " filters {\r")
                    for filter in cell.filters:
                        operation_name = "none"
                        if not(filter.operation is None):
                            operation_name = "output_tables." +filter.operation.eContainer().name + "." + filter.operation.name
                        f.write("\t\t\t\t\t\tFilter {operation " + operation_name + "  item ( ")
                        for item in filter.member:
                            f.write("sdd_domains." + item.eContainer().name + "." + item.name + " " ) 
                        f.write(")\r")   
                        f.write("\t\t\t\t\t\t}\r") 
                    f.write("\t\t\t\t\t}\r")  
                    f.write("\t\t\t}\r")
                f.write("\t\t}\r")
                f.write("\t}\r")
                f.write("}\r")
                f.close()

    def create_example_reports(self, context):
        '''
        Documentation for create_example_reports
        '''
        reports = context.reports_module.reports
        for report in reports:
            
            if not(report.outputLayer is None):
                f = open(context.output_directory + os.sep + 'csv' +
                         os.sep + report.outputLayer.name +
                         '.csv', "a",  encoding='utf-8')
                f.write("report,datapoint,row,column,sheet,value")
                 
                for cell in report.reportCells:
                    report_name = "None"
                    if not (report.outputLayer is None):
                        report_name= report.outputLayer.name
                    
                    data_point_id = "None"
                    if not (cell.datapointID is None):
                        data_point_id= cell.datapointID
                        
                    row_name = "None"
                    if not (cell.row is None):
                        row_name= cell.row.name
                        
                    col_name = "None"
                    if not (cell.column is None):
                        col_name= cell.column.name

                    f.write(report_name + "," + data_point_id + "," + row_name + "," + col_name + ",,100\r")                                       
                f.close()
                
    def remove_comment_chars(self, the_string):
        '''
        Documentation for remove_comment_chars
        '''
        return the_string.replace("/**", "").replace("/*", "").replace("*/", "")
