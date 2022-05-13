import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "moe.quill.mc"
version = "1.0-SNAPSHOT"
description = "kt-test"
java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    id("java-library")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    kotlin("jvm") version "1.7.0-Beta"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        url = uri("https://repo.maven.apache.org/maven2/")
        url = uri("https://jitpack.io")
    }
    mavenCentral()
}


dependencies {
    compileOnly(group = "io.papermc.paper", name = "paper-api", version = "1.18.2-R0.1-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
    jar {
        archiveClassifier.set("noshade")
    }
    shadowJar {
        archiveClassifier.set("")
        archiveFileName.set("${rootProject.name}-${project.version}.jar")
    }
    build{
        dependsOn(shadowJar)
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}