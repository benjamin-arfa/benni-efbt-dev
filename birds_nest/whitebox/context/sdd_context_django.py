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



class SDDContext(object):
    '''
    Documentation for Context
    '''
    # variables to configure the behaviour

    use_codes = True
    
    # the directory where we get our input files
    file_directory = ""
    # the directory where we save our outputs.
    output_directory = ""

    

    members_that_are_nodes = []
    member_plus_hierarchy_to_child_literals = {}
    domain_to_hierarchy_dictionary = {}
    combinations_dictionary = {}
    member_dictionary = {}
    domain_dictionary = {}
    subdomain_dictionary = {}
    member_hierarchy_dictionary = {}
    member_hierarchy_node_dictionary = {}
    variable_dictionary= {}
    axis_ordinate_dictionary= {}
    table_cell_dictionary= {}
    table_to_table_cell_dictionary= {}
    member_mapping_dictionary = {}
    member_mapping_items_dictionary = {}
    cell_positions_dictionary = {}
    variable_set_enumeration_dictionary = {}
    report_tables_dictionary = {}
    axis_dictionary = {}
    variable_set_dictionary = {}
    mapping_definition_dictionary = {}
    mapping_to_cube_dictionary = {}
    variable_mapping_dictionary = {}
    variable_mapping_item_dictionary = {}
    variable_set_mappings = []
    agency_dictionary = {}
    framework_dictionary = {}
    subdomain_to_items_map = {}
    cube_structure_items = []
    # For the reference output layers we record a map between variables
    # and domains
    variable_to_domain_map = {}
    variable_to_long_names_map = {}
    variable_to_primary_concept_map = {}

    combination_to_typ_instrmnt_map = {}
    table_to_combination_dictionary = {}

    # For the reference output layers we record a map between domains
    # and domain names
    domain_to_domain_name_map = {}
    
     # For the reference output layers we record a map between members ids
    # andtheir containing domains
    member_id_to_domain_map = {}
    # For the reference output layers we record a map between members ids
    # and their names
    member_id_to_member_name_map = {}
    # For the reference output layers we record a map between members ids
    # and their codes
    member_id_to_member_code_map = {}
    
    variable_set_to_variable_map = {}

    axis_ordinate_to_ordinate_items_map = {}

    save_sdd_to_db = True

    def __init__(self):

        pass