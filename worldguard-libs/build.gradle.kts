tasks.register("build") {
    dependsOn(subprojects.map { it.tasks.named("build") })
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