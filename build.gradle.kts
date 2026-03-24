plugins {
    id("java")
    id("maven-publish")
}

group = project.property("group") as String
version = project.property("version") as String

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jsoup:jsoup:1.22.1")
    compileOnly("org.jetbrains:annotations:24.0.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"]) // add compiled jar
            groupId = project.property("group") as String
            artifactId = project.property("artifactId") as String
            version = project.property("version") as String

            pom {
                name.set(project.property("name") as String)
                description.set(project.property("description") as String)
                url.set(project.property("url") as String)

                licenses {
                    license {
                        name.set("Mozilla Public License, version 2.0")
                        url.set("https://www.mozilla.org/en-US/MPL/2.0/")
                    }
                }

                developers {
                    developer {
                        id.set("evilsquirrelguy")
                        name.set("EvilSquirrelGuy")
                    }
                }
            }


        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/EvilSquirrelGuy/JHaaC")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}

//tasks.test {
//    useJUnitPlatform()
//}