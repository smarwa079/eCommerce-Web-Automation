package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot
{
    public static String takeScreenshot(String testCaseName, WebDriver driver)
    {
        String filePath = System.getProperty("user.dir") + "/Screenshots/" + testCaseName +".png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(filePath);
        try {
            FileUtils.copyFile(source, destination);
            LogUtils.info("Screenshot saved at: ", filePath);
        } catch (IOException e) {
            LogUtils.error("Error while taking screenshot: ", e.getMessage());
        }

        return filePath;
    }
}
