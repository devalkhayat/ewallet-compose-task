pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ewallet"
include(":app")
include(":feature:dashboard:data")
include(":feature:dashboard:domain")
include(":feature:dashboard:ui")
include(":core:common")
include(":core:datasource")
include(":core:feature_api")
include(":feature:statistics:data")
include(":feature:statistics:domain")
include(":feature:statistics:ui")
include(":feature:payment:data")
include(":feature:payment:domain")
include(":feature:payment:ui")
include(":feature:notification:data")
include(":feature:notification:domain")
include(":feature:notification:ui")
include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:profile:ui")
