plugins {
    id("java")
}

group = "main.my.sudovinay01"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/com.github.2gis.winium/winium-webdriver
    implementation("com.github.2gis.winium:winium-webdriver:0.1.0-1")
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.5.1")
}

tasks.test {
    useTestNG()
}
