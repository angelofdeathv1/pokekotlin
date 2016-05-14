import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.publish.bintray

@Suppress("unused")
val repos = repos()

object Versions {
    val kotlin = "1.0.2"
    val retrofit = "2.0.2"
    val kovenant = "3.2.2"
    val testng = "6.9.10"
}

@Suppress("unused")
val p = project {

    name = "PokeKotlin"
    group = "me.sargunvohra.lib"
    artifactId = name
    version = "0.12.0"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependencies {
        // kotlin
        compile("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

        // retrofit
        compile("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
        compile("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")

        // kovenant
        compile("nl.komponents.kovenant:kovenant:${Versions.kovenant}")
    }

    dependenciesTest {
        compile("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
        compile("org.testng:testng:${Versions.testng}")
    }

    assemble {
        jar {
        }
        mavenJars {
        }
    }

    bintray {
        publish = true
    }
}
