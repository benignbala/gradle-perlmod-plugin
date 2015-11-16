package org.benignbala.gradle.perlmod

import org.gradle.api.Project
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Input

class PauseExtension {
    static final String EXTENSION_NAME = "pause"

    PauseExtension(Project p) {
        this.project = p
    }

    @InputFile
    String getBuild() {
        this.build
    }

    void setBuild(File file) {
        this.build = file
    }

    void build(File file) {
        this.build = file
    }

    @Input
    String getAuthor() {
        this.author
    }

    void setAuthor() {
        this.author = author
    }

    void author() {
        author = author
    }

    private String author
    private File build
    final Project project
}
