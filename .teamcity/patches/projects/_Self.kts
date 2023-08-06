package patches.projects

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.ProjectReportTab
import jetbrains.buildServer.configs.kotlin.projectFeatures.projectReportTab
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the root project
accordingly, and delete the patch script.
*/
changeProject(DslContext.projectId) {
    features {
        add {
            projectReportTab {
                id = "PROJECT_EXT_5"
                title = "report"
                startPage = "index.html"
                buildType = "SafariSerivice_Build"
                sourceBuildRule = ProjectReportTab.SourceBuildRule.LAST_SUCCESSFUL
            }
        }
    }
}