plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.ow2.asm:asm:9.6")
    implementation("org.ow2.asm:asm-tree:9.6")
    implementation("org.ow2.asm:asm-analysis:9.6")
    implementation("org.ow2.asm:asm-util:9.6")
    implementation("org.ow2.asm:asm-commons:9.6")
}

val extractJar by tasks.creating(Copy::class) {
    val fileJar = file("assets/KsatriaOnline_400.jar")
    from(zipTree(fileJar))
    into("tmp/ori")
}

val prepareTargetClass by tasks.registering(Copy::class) {
    group = "patching"
    description = "Menyiapkan file a.class ke folder mod sebelum dipatch"

    from("tmp/ori") {
        include("com/silverknight/a.class")
        include("fu.class")
    }
    into("tmp/mod")

    dependsOn(extractJar)
}

val copyOriginalJar by tasks.registering(Copy::class) {
    from("assets/KsatriaOnline_400.jar")
    into(layout.buildDirectory.dir("libs"))
    rename { "KsatriaOnline_Modded.jar" }
    dependsOn(prepareTargetClass)
}

val patchClass by tasks.registering(JavaExec::class) {
    group = "patching"
    mainClass.set("com.myfw.Main") 
    classpath = sourceSets["main"].runtimeClasspath
    
    dependsOn(copyOriginalJar)
}

val copyCompiledApi by tasks.registering(Copy::class) {
    group = "patching"
    description = "Menyalin hasil compile API ke folder mod sebelum digabung"
    from(sourceSets["main"].output) {
        include("com/payload/api/**")
        include("com/payload/inject/**")
    }
    into("tmp/mod")
    dependsOn(patchClass)
}

val runStubRemover by tasks.registering(JavaExec::class) {
    group = "patching"
    mainClass.set("com.myfw.StubRemover")
    classpath = sourceSets["main"].runtimeClasspath
    dependsOn(copyCompiledApi)
}

val mergeResources by tasks.registering(Copy::class) {
    group = "patching"
    
    from("tmp/ori") {
        exclude("com/silverknight/a.class")
        exclude("fu.class")
    }
    into("tmp/mod")
    
    dependsOn(runStubRemover)
}

val repackJar by tasks.registering(Jar::class) {
    group = "patching"
    archiveFileName.set("KsatriaOnline_Modded.jar")
    
    from("tmp/mod") {
        exclude("META-INF/MANIFEST.MF")
    }
    
    manifest {
        val manifestFile = file("tmp/ori/META-INF/MANIFEST.MF")
        if (manifestFile.exists()) {
            from(manifestFile)
        }
    }
    
    destinationDirectory.set(layout.buildDirectory.dir("libs"))
    dependsOn(mergeResources)
}

val runEmulator by tasks.registering(JavaExec::class) {
    group = "execution"
    description = "Menjalankan JAR modifikasi menggunakan MicroEmulator"

    val emulatorJar = file("assets/microemulator.jar") 
    
    classpath = files(emulatorJar)
    
    mainClass.set("org.microemu.app.Main")
    
    args(repackJar.get().archiveFile.get().asFile.absolutePath)
    
    dependsOn(repackJar)
}