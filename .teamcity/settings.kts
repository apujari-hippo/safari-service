import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2023.05"

project {

    buildType(Build)

    subProject(BuildAndroid)
}

object Build : BuildType({
    name = "Build"

    steps {
        script {
            name = "build"
            scriptContent = """echo "Build""""
        }
        script {
            name = "build2"
            scriptContent = """echo "Build2""""
        }
    }
})


object BuildAndroid : Project({
    name = "Build Android"
    description = "Building android app."

    buildType(BuildAndroid_Deploy)
    buildType(BuildAndroid_Build)
})

object BuildAndroid_Build : BuildType({
    name = "Build"

    steps {
        script {
            name = "build"
            scriptContent = """echo "Building android app.""""
        }
    }
})

object BuildAndroid_Deploy : BuildType({
    name = "Deploy"

    steps {
        script {
            name = "deploy"
            scriptContent = """echo "Deploying android app""""
        }
    }
})
