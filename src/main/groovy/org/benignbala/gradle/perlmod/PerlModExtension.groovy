package org.benignbala.gradle.perlmod

import org.gradle.api.Project
import org.gradle.api.tasks.Input

class PerlModExtension {
    static final String EXTENSION_NAME = "perlmod"

    PerlModExtension(Project p) {
        this.project = p
    }

    @Input
    String getModuleName() {
        this.moduleName
    }

    void setModuleName(String name) {
        this.moduleName = name
    }

    void moduleName(String name) {
        this.moduleName = name
    }

    @Input
    String getAuthor() {
        this.author
    }

    void setAuthor(String author) {
        this.author = author
    }

    void author(String author) {
        this.author = author
    }

    @Input
    String getEmail() {
        this.email
    }

    void setEmail(String mail) {
        this.email = mail
    }

    void email(String mail) {
        this.email = mail
    }

    @Input
    String getBuilder() {
        this.builder
    }

    void setBuilder(String builder) {
        this.builder = builder
    }

    void builder(String builder) {
        this.builder = builder
    }

    final Project project
    private String moduleName
    private String author
    private String email
    private String builder = "Module::Build"
}

