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
from utils.utils import Utils
from regdna import Report,ReportRow,ReportColumn,ReportCell,Filter,ELEnum
import os
import csv

class CombinationsToReportFilters:
    '''
    Documentation for CombinationsToReportFilters
    '''

    def translate_combinations_to_report_filters(self, context,sdd_context):
        file_location = context.file_directory + os.sep + "in_scope_reports.csv"
        in_scope_reports = []
        header_skipped = False
        # Loop through the list of in scope reports
        with open(file_location,  encoding='utf-8') as csvfile:
            filereader = csv.reader(csvfile, delimiter=',', quotechar='"')
            for row in filereader:
                # skip the first line which is the header.
                if (not header_skipped):
                    header_skipped = True
                else:
                    report_template = row[0]
                    print("report_template")
                    print(report_template)
                    in_scope_reports.append(report_template)
        
        warning_list = []
        for table in sdd_context.report_tables.reportTables:
            table_code  =  table.code
            altered_table_name = Utils.make_valid_id(table_code) +"_OutputItem"
            report_rol = CombinationsToReportFilters.get_report_rol_for_table_code(self, altered_table_name, context)
            if not (report_rol is None):
                report = Report()
                report.outputLayer = report_rol
                context.reports_module.reports.append(report)
                context.reports_dictionary[altered_table_name] = report
                
        
        for cell_position in sdd_context.cell_positions.cellPositions:
            x_axis = "None"
            y_axis = "None"
            cell = cell_position.cell_id
            if not(cell is None):
                template = cell.table_id
                if not(template is None):
                    
                    template_code = template.code
                    print("template_code")
                    print(template_code[0:template_code.index("_REF")].replace('.','_'))
                    
                    report_cell = ReportCell()
                    try:
                        altered_template_name = Utils.make_valid_id(template_code) +"_OutputItem"
                        related_report = context.reports_dictionary[altered_template_name]
                        for axis_ordinate in cell_position.axis_ordinate_id:
                            axis=axis_ordinate.axis_id
                            orientation = axis.orientation
                            if orientation == 'Y':
                                row = ReportRow(name = "row_" +axis_ordinate.code)
                                report_cell.row = row
                                row_exists_in_rows = False
                                for the_row in related_report.rows:
                                    if the_row.name == "row_" +axis_ordinate.code:
                                        row_exists_in_rows =  True
                                if not (row_exists_in_rows):
                                    related_report.rows.append(row)
                            if orientation == 'X':
                                col = ReportColumn(name = "col_" + axis_ordinate.code)   
                                report_cell.column = col                         
                                col_exists_in_columns = False
                                for the_col in related_report.columns:
                                    if the_col.name == "col_" + axis_ordinate.code:
                                        col_exists_in_columns =  True
                                if not (col_exists_in_columns):
                                    related_report.columns.append(col)

                        
                        
                        comb = cell_position.cell_id.combination_id
                        # if there is no combination, this is because the combination is not
                        # current, according to its valid_to date.
                        if not(comb is None):
                            related_report.reportCells.append(report_cell)
                            report_cell.datapointID = comb.combination_id
                            items = comb.combination_items
                            for item in items:
                                variable_id = item.variable_id.variable_id
                                if variable_id == "MTRCS":
                                    # todo make sure we can get the metric name from
                                    # the associate varaible set
                                    variable_set = item.variable_set_id
                                    if not(variable_set is None):
                                        for item in variable_set.variable_set_items:
                                            metric = CombinationsToReportFilters.find_operation_with_id(self,context,related_report,item.variable_id.variable_id)
                                            report_cell.metric = metric
                                            if metric is None:
                                                warning_list.append( ("error", "no output layer item for metric", template_code, comb.combination_id, item.variable_id.variable_id, None , None, None ))
                                            else:
                                                pass
                                    else:
                                        warning_list.append( ("error","combination has no metrics for metrics variable set",template_code, comb.combination_id,  item.variable_id.variable_id, None, None, None))
                                        
                                elif variable_id == "SUBA_CD" or variable_id == "VALUE_DECIMAL" or variable_id == "DT_RFRNC" or variable_id == "ENTTY_RIAD_CD_RPRTNG_AGNT" :
                                    # these entity and refernce dates are not useful filters , we dont diplay them,
                                    pass
                                else:
                                    
                                    try:
                                        filter = Filter()
                                    
                                        operation = CombinationsToReportFilters.find_operation_with_id(self,context,related_report,item.variable_id.variable_id)
                                        
                                        member = item.member_id
                                        if(member is not None):
                                            member_id = member.member_id
                                            member_code = member.code
                                            
                                            domain_id = item.variable_id.domain_id.domain_id
                                            literals = CombinationsToReportFilters.find_literals_with_id(self,context,sdd_context,member_code,member_id,domain_id,warning_list, template_code, comb.combination_id, item.variable_id.variable_id )
                                            filter.operation = operation
                                            for literal in literals:
                                                filter.member.append(literal)
                                                
                                            if not(operation is None):
                                                report_cell.filters.append(filter)    
                                                
                                    except:
                                        warning_list.append( ("error","failed making a filter ",template_code, comb.combination_id,   item.variable_id.variable_id, None, None, None))
                                        
                                        pass
            
                    except:
                        pass
        
        
        
        
        f = open(context.output_directory + os.sep + "warnings.csv",
                 "a",  encoding='utf-8')  
        f.write("warning_type,message,cube,combination,variable,member, hierarchy, domain\r")    
        
        problem_member_list = []  
        for item in warning_list:
            cube_name = item[2]
            if not(cube_name is  None):
                adapted_cube_name = cube_name[0:cube_name.index("_REF")].replace('.','_')
                print(adapted_cube_name)
                
                if adapted_cube_name in in_scope_reports:   
                    f.write(str(item[0]) + "," + str(item[1]) + "," + str(item[2]) + "," + str(item[3]) + "," + str(item[4]) + "," + str(item[5]) + "," + str(item[6]) + "," + str(item[7]) +  "\r")
                    problem_member = item[5]
                    if not(problem_member is None) :
                        if not(problem_member in problem_member_list) :
                            problem_member_list.append(problem_member)
                    
        f.close()        
        f2 = open(context.output_directory + os.sep + "warnings_summary.csv",
                 "a",  encoding='utf-8')  
          
        for item in problem_member_list:
            f2.write(item + "\r")
            
        f2.close()
            
              
             
    
            
            
            
    def find_operation_with_id(self,context,related_report,op_id):

        for op in related_report.outputLayer.eOperations:
            if op.name == op_id:
                return op
            
        
    def get_report_rol_for_table_code(self, table_code, context):
        for rol_class in context.output_tables_package.eClassifiers:

            if table_code == rol_class.name:
                return rol_class
        return None   
    
    def find_literals_with_id(self,context,sdd_context,member_code,member_id,domain_id,warning_list, template_code, combination_id, variable_id):
        return_literal = None
        return_literal = CombinationsToReportFilters.find_literal_with_id(self,context,sdd_context,member_code,domain_id)
        return CombinationsToReportFilters.get_literal_list_considering_hierarchies(self,context,sdd_context,return_literal,member_id,domain_id,warning_list, template_code,combination_id, variable_id)

       
    def find_literal_with_id(self,context,sdd_context,member_code,domain_id):
            try:
                return context.enum_literals_map[domain_id + "_domain" +":" +  Utils.make_valid_id_for_literal(member_code)]
            except:
                return None

    def get_literal_list_considering_hierarchies(self,context,sdd_context,literal,member_id,domain_id, warning_list, template_code,combination_id, variable_id):
        return_list = []
        if literal is None:
            is_node = CombinationsToReportFilters.is_member_a_node(self,context,sdd_context,member_id,domain_id)
            if not (is_node):
                warning_list.append( ("error", "member does not exist in input layer and is not a node", template_code,combination_id, variable_id, member_id, None,domain_id))
            pass
        else:
            return_list = [literal]
        for hierarchy in sdd_context.member_hierarchies.memberHierarchies:
            if hierarchy.domain_id.domain_id == domain_id:
                hierarchy_id = hierarchy.member_hierarchy_id                
                literal_list = CombinationsToReportFilters.get_literal_list_considering_hierarchy(self,context,sdd_context,member_id,hierarchy_id, warning_list, template_code,combination_id, variable_id)
                if not(literal_list is None):
                    return_list.extend(literal_list)
        if len(return_list) == 0:
            warning_list.append( ("error","could not find any input layer members or sub members for member", template_code,combination_id, variable_id, member_id, None,domain_id))
        return return_list     

    def is_member_a_node(self,context,sdd_context,member_id,domain_id):
        for node in sdd_context.member_hierarchies.memberHierarchiesNodes:
            if not (node.parent_member_id is None) and not (node.parent_member_id == ''):
                if node.parent_member_id.member_id == member_id and node.parent_member_id.domain_id.domain_id == domain_id:
                    return True
        return False
            
    def get_literal_list_considering_hierarchy(self,context,sdd_context,member_id,hierarchy, warning_list, template_code,combination_id, variable_id):
        return_list = []
        for node in sdd_context.member_hierarchies.memberHierarchiesNodes:
            if node.member_hierarchy_id.member_hierarchy_id == hierarchy:
                if CombinationsToReportFilters.node_is_child_of_member(self,context,sdd_context,node,member_id,hierarchy, warning_list, template_code,combination_id, variable_id):
                    literal = CombinationsToReportFilters.find_literal_with_id(self,context,sdd_context,node.member_id.code,node.member_id.domain_id.domain_id)
                    if literal is None:
                        pass
                        #warning_list.append( ("notice","child member x of hierarchy y does not exist in input layer",template_code,combination_id, variable_id, node.member_id.code, node.member_hierarchy_id.member_hierarchy_id,node.member_id.domain_id.domain_id))
                    else:
                        return_list.append(literal) 
        return return_list
            
    def node_is_child_of_member(self,context,sdd_context,node,member_id,hierarchy, warning_list, template_code,combination_id, variable_id):
        parent_member_id = node.parent_member_id
        if parent_member_id is None:
            return False
        elif parent_member_id.member_id == member_id:
            return True
        else:
            parent_node = CombinationsToReportFilters.find_member_node(self,sdd_context,parent_member_id,hierarchy, warning_list, template_code,combination_id, variable_id)
            return CombinationsToReportFilters.node_is_child_of_member(self,context,sdd_context,parent_node,member_id,hierarchy, warning_list, template_code,combination_id, variable_id)
        
    def find_member_node(self,sdd_context,member_id,hierarchy, warning_list, template_code,combination_id, variable_id):
        try:
            return sdd_context.member_hierarchy_node_dictionary[hierarchy + ":" + member_id.member_id]
        except:
            pass
            #warning_list.append(("notice","couldnt find member_hierarchy_node ", template_code,combination_id, variable_id, member_id.code, hierarchy,None))