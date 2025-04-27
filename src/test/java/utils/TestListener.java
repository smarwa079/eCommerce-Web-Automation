package utils;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;

public class TestListener implements ITestListener, ISuiteListener
{

    @Override
    public void onStart(ISuite suite)
    {
      deleteFolder("Screenshots");
      deleteFolder("allure-results");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String screenshotPath = null;

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        screenshotPath = TakeScreenshot.takeScreenshot(result.getMethod().getMethodName(), driver);

        AllureUtils.attachScreenshot(result.getMethod().getMethodName(), screenshotPath);

    }

    @Override
    public void onFinish(ISuite suite)
    {
        AllureUtils.generateAllureReport();
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
