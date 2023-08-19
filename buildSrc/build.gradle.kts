plugins {
    `kotlin-dsl`
    kotlin("jvm") version embeddedKotlinVersion
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation("gradle.plugin.org.cadixdev.gradle:licenser:0.6.1")
    implementation("org.ajoberstar.grgit:grgit-gradle:4.1.1")
    implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
    implementation("org.jfrog.buildinfo:build-info-extractor-gradle:4.27.1")
}

allprojects {
    tasks.withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
    }

    tasks.withType<Test> {
        systemProperty("file.encoding", Charsets.UTF_8.name())
    }

    tasks.withType<Javadoc> {
        options.encoding = Charsets.UTF_8.name()
    }

    tasks.withType<ProcessResources> {
        filteringCharset = Charsets.UTF_8.name()
    }
}