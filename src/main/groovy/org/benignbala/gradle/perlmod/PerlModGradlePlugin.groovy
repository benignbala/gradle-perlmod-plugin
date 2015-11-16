package org.benignbala.gradle.perlmod

import org.gradle.api.Plugin
import org.gradle.api.Project

class PerlModGradlePlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create(PerlModExtension.EXTENSION_NAME, PerlModExtension, project)
        project.extensions.create(PauseExtension.EXTENSION_NAME, PauseExtension, project)
        project.tasks.create('perlmod', PerlModuleTask).configure {
            description 'Create a Perl module using Module::Starter'
            group 'Perl Modules'
        }
    }
}
