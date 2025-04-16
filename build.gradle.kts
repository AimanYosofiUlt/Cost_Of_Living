plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com.moscow.squad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project.dependencies.platform("io.insert-koin:koin-bom:4.0.4"))
    implementation("io.insert-koin:koin-core")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}