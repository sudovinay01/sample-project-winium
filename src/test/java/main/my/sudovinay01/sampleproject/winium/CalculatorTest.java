package main.my.sudovinay01.sampleproject.winium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    @BeforeTest
    public void beforeTest() {
        winiumUtils.checkDisplay();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }

    @Test
    public void test() {
        System.out.println("current test");
    }
}
