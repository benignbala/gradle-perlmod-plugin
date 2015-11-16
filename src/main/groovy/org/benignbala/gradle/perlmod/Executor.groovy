package org.benignbala.gradle.perlmod

import org.gradle.api.Project
import org.gradle.process.ExecResult

class Executor {
    static ExecResult generateSkeleton(Project project, String initCmd, String moduleName, String author, String email, String builder) {
        project.exec {
            executable = initCmd
            args = ['--module', moduleName, '--author', author, '--email', email, builder]
        }
    }

    static ExecResult buildModule(Project project, String moduleName) {
        String path = moduleName.replaceAll(~/::/, "-")
        project.exec {
            workingDir "./${path}"
            executable = "perl"
            args = ["Build.PL"]
        }

    }
}
