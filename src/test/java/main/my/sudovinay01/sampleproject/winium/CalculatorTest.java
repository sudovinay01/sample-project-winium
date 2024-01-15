package main.my.sudovinay01.sampleproject.winium;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    private static final int WINIUM_PORT = 9999;
    DesktopOptions options;
    WiniumDriverService service;
    WiniumDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        winiumUtils.checkDisplay();
        winiumUtils.killPort(WINIUM_PORT);

        options = new DesktopOptions();
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
        File driverPath = new File("Winium.Desktop.Driver.exe");
        //TODO add comments below assignment
        service = new WiniumDriverService.Builder()
                .usingDriverExecutable(driverPath)
                .usingPort(WINIUM_PORT)
                .withVerbose(false)
                .withSilent(false)
                .buildDesktopService();
        service.start();
        driver = new WiniumDriver(service, options);
    }

    @AfterTest
    public void afterTest() throws IOException {
        driver.findElement(By.name("Close Calculator")).click();
        service.stop();
        winiumUtils.killPort(WINIUM_PORT);
    }

    @Test
    public void test() throws InterruptedException {
        int num1 = 5, num2 = 2;
        Thread.sleep(1000);
        System.out.println("number 1 = " + num1
                + "\nnumber 2 = " + num2);
        driver.findElement(By.id("clearButton")).click();
        driver.findElement(By.id("num" + num1 + "Button")).click();
        driver.findElement(By.name("Multiply by")).click();
        driver.findElement(By.id("num" + num2 + "Button")).click();
        driver.findElement(By.id("equalButton")).click();
        String results = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
        System.out.println("Actual value = " + results
                + "\nExpecting vaule = Display is " + num1 * num2);
        assertEquals(results, "Display is " + num1 * num2);
    }
}
