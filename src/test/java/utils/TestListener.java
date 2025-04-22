package utils;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TestListener implements ITestListener
{

    @Override
    public void onStart(ITestContext context)
    {
        deleteFolder("Screenshots");
        deleteFolder("allure-results");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String screenshotPath = null;
        try {
            screenshotPath = BaseTest.takeScreenshot(result.getMethod().getMethodName());
            Allure.addAttachment(result.getMethod().getMethodName(), new FileInputStream(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFolder(String folderName)
    {
        File folder = new File(folderName);

        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
        }
    }
}
