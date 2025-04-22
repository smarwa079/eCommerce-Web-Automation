package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TestListener implements ITestListener
{
    private static boolean alreadyCleaned = false;

    @Override
    public void onStart(ITestContext context)
    {
        if (!alreadyCleaned) {
            deleteFolder("Screenshots");
            deleteFolder("allure-results");
            alreadyCleaned = true;
        }
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String screenshotPath = null;
        try {
            Object testClass = result.getInstance();
            WebDriver driver = ((BaseTest) testClass).getDriver();

            screenshotPath = TakeScreenshot.takeScreenshot(result.getMethod().getMethodName(), driver);
            Allure.addAttachment(result.getMethod().getMethodName(), new FileInputStream(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFolder(String folderName)
    {
        File folder = new File(folderName);

        if (folder.exists())
        {
            for (File file : folder.listFiles())
            {
                file.delete();
            }
        }
    }
}
