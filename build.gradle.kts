plugins {
    id("java")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit Platform (suite API + launcher)
    testImplementation("org.junit.platform:junit-platform-suite-api:1.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-suite-engine:1.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // JUnit Jupiter (por si tenés tests normales)
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Cucumber
    testImplementation("io.cucumber:cucumber-java:7.18.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.1")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
