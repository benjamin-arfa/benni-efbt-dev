# coding=UTF-8
# Copyright (c) 2024 Bird Software Solutions Ltd
# This program and the accompanying materials
# are made available under the terms of the Eclipse Public License 2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/legal/epl-2.0/
#
# SPDX-License-Identifier: EPL-2.0
#
# Contributors:
#    Neil Mackenzie - initial API and implementation
from django.http import HttpResponse, JsonResponse
from django.shortcuts import render, redirect, get_object_or_404
from django.contrib import messages
from django.forms import modelformset_factory
from django.core.paginator import Paginator
from django.db import transaction
from django.conf import settings
from .sdd_models import (
    VARIABLE_MAPPING, VARIABLE_MAPPING_ITEM, MEMBER_MAPPING, MEMBER_MAPPING_ITEM,
    CUBE_LINK, CUBE_STRUCTURE_ITEM_LINK, MAPPING_TO_CUBE, MAPPING_DEFINITION
)
from .entry_points.import_input_model import RunImportInputModelFromSQLDev
from .entry_points.import_report_templates_from_website import RunImportReportTemplatesFromWebsite
from .entry_points.import_semantic_integrations_from_website import RunImportSemanticIntegrationsFromWebsite
from .entry_points.import_hierarchy_analysis_from_website import RunImportHierarchiesFromWebsite
from .entry_points.create_filters import RunCreateFilters
from .entry_points.create_joins_metadata import RunCreateJoinsMetadata
from .entry_points.delete_joins_metadata import RunDeleteJoinsMetadata
from .entry_points.create_executable_joins import RunCreateExecutableJoins
from .entry_points.run_create_executable_filters import RunCreateExecutableFilters
from .entry_points.execute_datapoint import RunExecuteDataPoint
import os

# Helper function for paginated modelformset views
def paginated_modelformset_view(request, model, template_name, formset_fields='__all__', order_by='id', items_per_page=20):
    page_number = request.GET.get('page', 1)
    all_items = model.objects.all().order_by(order_by)
    paginator = Paginator(all_items, items_per_page)
    page_obj = paginator.get_page(page_number)
    
    ModelFormSet = modelformset_factory(model, fields=formset_fields, extra=0)
    
    if request.method == 'POST':
        formset = ModelFormSet(request.POST, queryset=page_obj.object_list)
        if formset.is_valid():
            with transaction.atomic():
                formset.save()
            messages.success(request, f'{model.__name__} updated successfully.')
            return redirect(request.path)
        else:
            messages.error(request, f'There was an error updating the {model.__name__}.')
    else:
        formset = ModelFormSet(queryset=page_obj.object_list)
    
    context = {
        'formset': formset,
        'page_obj': page_obj,
    }
    return render(request, template_name, context)

def show_report(request, report_id):
    return render(request, 'pybirdai/' + report_id)

# Views for running various processes
def run_create_joins_meta_data(request):
    app_config = RunCreateJoinsMetadata('pybirdai', 'birds_nest')
    app_config.run_create_joins_meta_data()
    return HttpResponse("Created Transformation Metadata")

def run_create_python_joins(request):
    app_config = RunCreateExecutableJoins('pybirdai', 'birds_nest')
    app_config.create_python_joins()
    return HttpResponse("Created Python Transformations")

def run_delete_joins_meta_data(request):
    app_config = RunDeleteJoinsMetadata('pybirdai', 'birds_nest')
    app_config.run_delete_joins_meta_data()
    return HttpResponse("Deleted Transformation Metadata")

def run_import_semantic_integrations_from_website(request):
    app_config = RunImportSemanticIntegrationsFromWebsite('pybirdai', 'birds_nest')
    app_config.import_mappings_from_website()
    return HttpResponse("Import Semantic Integrations completed successfully.")

def run_import_input_model_from_sqldev(request):
    app_config = RunImportInputModelFromSQLDev('pybirdai', 'birds_nest')
    app_config.ready()
    return HttpResponse("Import Input Model from SQLDev process completed successfully.")

def run_import_hierarchies(request):
    app_config = RunImportHierarchiesFromWebsite('pybirdai', 'birds_nest')
    app_config.import_hierarchies()
    return HttpResponse("Import hierarchies successfully.")

def import_report_templates(request):
    app_config = RunImportReportTemplatesFromWebsite('pybirdai', 'birds_nest')
    app_config.run_import()
    return HttpResponse("Import Report templates from website completed successfully.")

def run_create_filters(request):
    app_config = RunCreateFilters('pybirdai', 'birds_nest')
    app_config.run_create_filters()
    return HttpResponse("Created filters successfully.")

def run_create_executable_filters(request):
    app_config = RunCreateExecutableFilters('pybirdai', 'birds_nest')
    app_config.run_create_executable_filters()
    return HttpResponse("Create executable filters process completed successfully.")

# Basic views
def index(request):
    return HttpResponse("Hello, world. You're at the pybirdai index.")

def home_view(request):
    return render(request, 'pybirdai/home.html')

# CRUD views for various models
def edit_variable_mappings(request):
    return paginated_modelformset_view(request, VARIABLE_MAPPING, 'pybirdai/edit_variable_mappings.html', order_by='variable_mapping_id')

def edit_variable_mapping_items(request):
    return paginated_modelformset_view(request, VARIABLE_MAPPING_ITEM, 'pybirdai/edit_variable_mapping_items.html')

def edit_member_mappings(request):
    return paginated_modelformset_view(request, MEMBER_MAPPING, 'pybirdai/edit_member_mappings.html', order_by='member_mapping_id')

def edit_member_mapping_items(request):
    return paginated_modelformset_view(request, MEMBER_MAPPING_ITEM, 'pybirdai/edit_member_mapping_items.html')

def edit_cube_links(request):
    return paginated_modelformset_view(request, CUBE_LINK, 'pybirdai/edit_cube_links.html', order_by='cube_link_id')

def edit_cube_structure_item_links(request):
    return paginated_modelformset_view(request, CUBE_STRUCTURE_ITEM_LINK, 'pybirdai/edit_cube_structure_item_links.html', order_by='cube_structure_item_link_id')

def edit_mapping_to_cubes(request):
    return paginated_modelformset_view(request, MAPPING_TO_CUBE, 'pybirdai/edit_mapping_to_cubes.html')

def edit_mapping_definitions(request):
    return paginated_modelformset_view(request, MAPPING_DEFINITION, 'pybirdai/edit_mapping_definitions.html', order_by='mapping_id')

# Delete views for various models
def delete_item(request, model, id_field, redirect_view):
    item = get_object_or_404(model, **{id_field: request.POST.get(id_field)})
    if request.method == 'POST':
        item.delete()
        messages.success(request, f'{model.__name__} deleted successfully.')
    else:
        messages.error(request, 'Invalid request for deletion.')
    return redirect(f'pybirdai:{redirect_view}')

def delete_variable_mapping(request, variable_mapping_id):
    return delete_item(request, VARIABLE_MAPPING, 'variable_mapping_id', 'edit_variable_mappings')

def execute_data_point(request, data_point_id):
    app_config = RunExecuteDataPoint('pybirdai', 'birds_nest')
    result = app_config.run_execute_data_point(data_point_id)
    return HttpResponse("DataPoint " + data_point_id + " calculated as: " + result)

def delete_variable_mapping_item(request, item_id):
    return delete_item(request, VARIABLE_MAPPING_ITEM, 'id', 'edit_variable_mapping_items')

def delete_member_mapping(request, member_mapping_id):
    return delete_item(request, MEMBER_MAPPING, 'member_mapping_id', 'edit_member_mappings')

def delete_member_mapping_item(request, item_id):
    return delete_item(request, MEMBER_MAPPING_ITEM, 'id', 'edit_member_mapping_items')

def delete_cube_link(request, cube_link_id):
    return delete_item(request, CUBE_LINK, 'cube_link_id', 'edit_cube_links')

def delete_cube_structure_item_link(request, cube_structure_item_link_id):
    return delete_item(request, CUBE_STRUCTURE_ITEM_LINK, 'cube_structure_item_link_id', 'edit_cube_structure_item_links')

def delete_mapping_to_cube(request, mapping_to_cube_id):
    return delete_item(request, MAPPING_TO_CUBE, 'id', 'edit_mapping_to_cubes')

def delete_mapping_definition(request, mapping_id):
    return delete_item(request, MAPPING_DEFINITION, 'mapping_id', 'edit_mapping_definitions')