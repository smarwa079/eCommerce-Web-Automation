package utils;

import io.qameta.allure.Allure;

import java.io.FileInputStream;

public class AllureUtils
{
    private static final String ALLURE_REPORT_PATH = "reports/allure-report";
    private static final String ALLURE_RESULTS_PATH = "allure-results";

    public static void attachScreenshot(String testCaseName, String screenshotPath)
    {
        try {
            Allure.addAttachment(testCaseName, new FileInputStream(screenshotPath));
        } catch (Exception e) {
            LogUtils.error("Error while attaching screenshot", e.getMessage());
        }
    }

    public static void generateAllureReport()
    {
        try {
            String command = "allure generate "+ALLURE_RESULTS_PATH+" --clean -o "+ALLURE_REPORT_PATH+" --single-file";

            ProcessBuilder builder = new ProcessBuilder();
            // Windows
            builder.command("cmd.exe", "/c", command);

            builder.inheritIO();

            Process process = builder.start();
            process.waitFor();

            LogUtils.info("Allure report generated successfully");
        } catch (Exception e) {
            LogUtils.error("Error while generating Allure report", e.getMessage());
        }
    }
}
