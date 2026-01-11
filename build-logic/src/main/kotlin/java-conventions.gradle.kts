plugins {
    java
    jacoco
    id("com.diffplug.spotless")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

spotless {
    java {
        target("src/**/*.java")

        removeUnusedImports()
        forbidWildcardImports()
        forbidModuleImports()

        eclipse().configFile("../spotless/spotless.xml")

        formatAnnotations()
    }
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}