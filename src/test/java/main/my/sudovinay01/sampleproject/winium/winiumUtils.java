package main.my.sudovinay01.sampleproject.winium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    /**
     * Kill processes running on portID. If any.
     *
     * @param portID ID of port which tasks need to be killed
     * @throws IOException Throws IOException
     */
    public static void killPort(int portID) throws IOException {
        String command = "cmd /c netstat -ano | findstr :" + portID;
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.trim().split("\\s+");
            String pid = tokens[tokens.length - 1];
            Runtime.getRuntime().exec("taskkill /F /PID " + pid);
            if (!pid.equals("0"))
                System.out.println("Kill process with PID: " + pid);
        }
    }
}
