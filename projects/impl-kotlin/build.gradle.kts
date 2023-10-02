import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
}

dependencies {
    implementation(project(":api"))
}

tasks.named<KotlinCompile>("compileKotlin") {
    compilerOptions.allWarningsAsErrors = true
    val buildPath = layout.buildDirectory.file("classes/kotlin/main/com/github/asodja/test/impl/ClientImpl.class")
    val property = project.objects.property<Long>()
    doFirst {
        if (buildPath.get().asFile.exists()) {
            property.set(buildPath.get().asFile.lastModified())
        } else {
            property.set(-1)
        }
    }
    doLast {
        val time = buildPath.get().asFile.lastModified()
        if (property.get() == -1L) {
            println("File ${buildPath.get().asFile} compiled")
        } else if (time != property.get()) {
            println("File ${buildPath.get().asFile} recompiled")
        } else {
            println("File ${buildPath.get().asFile} not recompiled")
        }
    }
}