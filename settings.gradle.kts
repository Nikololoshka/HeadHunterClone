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

rootProject.name = "hh_clone"
include(":app")
include(":core:core_api")
include(":core:core_impl")
include(":core:core_ui")
include(":feature:search_impl")
include(":feature:favorite_impl")
include(":module_injector")
include(":feature:message_impl")
include(":feature:feedback_impl")
include(":feature:profile_impl")
