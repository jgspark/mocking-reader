import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("maven-publish")
}

group = "org.newbalancer"
version = "0.0.2-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-core:5.3.22")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.0.1")
    implementation("org.mockito:mockito-core:2.1.0")
    testImplementation(kotlin("test"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            // groupId = "org.newbalancer"
            group = project.group.toString()
            artifactId = "mock-expansion-util"
            // version = "0.0.2-SNAPSHOT"
            version = project.version.toString()
            from(components["java"])
        }
    }
}
