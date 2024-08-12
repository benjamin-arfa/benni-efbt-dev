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


import django
from django.apps import AppConfig


class RunCreateDjangoModels(AppConfig):
    
    path = '/workspaces/efbt/bird/birdseed_creator/birds_nest'
    def ready(self):

        from whitebox.context.sdd_context_django import SDDContext
        from whitebox.context.context import Context
        from whitebox.process_steps.sqldeveloper_import.import_sqldev_ldm_to_regdna import SQLDevLDMImport
        from whitebox.process_steps.sqldeveloper_import.import_sqldev_ldm_to_django import RegDNAToDJango

        sdd_context = SDDContext()
        sdd_context.file_directory = '/workspaces/efbt/birdsnest/resources'
        sdd_context.output_directory = '/workspaces/efbt/birdsnest/results'
        context = Context()
        context.file_directory = '/workspaces/efbt/birdsnest/resources'
        context.output_directory = '/workspaces/efbt/birdsnest/results'

        SQLDevLDMImport.do_import(self,context)
        RegDNAToDJango.convert(self,context)


if __name__ == '__main__':
    django.setup()
    RunCreateDjangoModels('whitebox','birds_nest').ready()
    
    

    
    

 

    