package org.benignbala.gradle.perlmod

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction
import groovy.transform.CompileDynamic


class PerlModuleTask extends DefaultTask {
    PerlModuleTask() {
    }
    
    @Input
    String getModuleName() {
        this.moduleName ?: project.extensions.getByName(PerlModExtension.EXTENSION_NAME)?.moduleName
    }
    
    @Input
    String getAuthor() {
        this.author ?: project.extensions.getByName(PerlModExtension.EXTENSION_NAME)?.author
    }

    @Input
    String getEmail() {
        this.author ?: project.extensions.getByName(PerlModExtension.EXTENSION_NAME)?.email
    }

    @Input
    String getBuilder() {
        project.extensions.getByName(PerlModExtension.EXTENSION_NAME)?.builder ?: this.builder
    }

    @TaskAction
    @CompileDynamic
    void exec() {
        String builder = getBuilder()
        String buildUtil = ""
        if (builder.toLowerCase() == "module::build") {
            buildUtil = "--mb"
        } else {
            buildUtil = "--mi"
        }
        Executor.generateSkeleton(project, initCmd, getModuleName(), getAuthor(), getEmail(), buildUtil)
        Executor.buildModule(project, getModuleName())
    }

    static final String initCmd = "module-starter"
    private String moduleName
    private String author
    private String email
    private String builder
    private Object srcDir
    private Object buildDir
}


