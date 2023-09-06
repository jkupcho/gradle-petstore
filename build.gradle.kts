plugins {
    java
    id("org.springframework.boot") version("3.1.3")
    id("io.spring.dependency-management") version("1.1.3")
}

group = "com.jkupcho.petstore"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}