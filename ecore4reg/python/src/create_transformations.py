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
'''
Created on 25 April 2022
'''

from context import Context

from import_input_layer_to_ecore4reg import InputLayerImport
from import_output_layer_to_ecore4reg import ROLImport
from import_finrep_vtl import ImportFinrepVTL
from persist_to_file import PersistToFile
from ecore4reg_to_ecore_converter import Ecore4regToEcoreConverter

if __name__ == '__main__':
    context = Context()

    context.persist_to_ecore4reg = True
    context.persist_vtl_comments = True
    context.use_subdomains = True
    context.file_directory = '/workspaces/efbt/ecore4reg/python/resourcesfinrep28'
    context.output_directory = '/workspaces/efbt/ecore4reg/python/results'

    InputLayerImport().do_import(context)
    ROLImport().doImport(context)
    ImportFinrepVTL().do_import(context)

    Ecore4regToEcoreConverter().convert_packages_in_ontext(context)

    persister = PersistToFile()
    persister.saveModelAsEcoreFile(context)
    persister.saveModelAsEcore4RegFile(context)
    persister.saveModelAsXMIFile(context)
