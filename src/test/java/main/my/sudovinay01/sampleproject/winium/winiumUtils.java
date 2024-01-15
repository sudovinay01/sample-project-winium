package main.my.sudovinay01.sampleproject.winium;

import static org.testng.Assert.assertTrue;

public class winiumUtils {

    private static boolean checkScale() {
        return getdisplayScale() == 1.0;
    }

    private static double getdisplayScale() {
        int resolution = java.awt.Toolkit.getDefaultToolkit().getScreenResolution();
        return (double) resolution / 96;
    }

    /**
     * Method check if display scale is 100% as winium drive does not run test properly on other scale values.
     */
    public static void checkDisplay() {
        assertTrue(checkScale(), "\nDisplay scale is not 100%. Set Display scale to 100% for test to begin.\n");
    }
}
