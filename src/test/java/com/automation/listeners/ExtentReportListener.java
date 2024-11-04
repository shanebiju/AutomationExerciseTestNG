package com.automation.listeners;

import com.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;
    boolean isConfigured=false;

    public void onStart(ITestContext context) {
        if(!isConfigured){
            isConfigured=true;
            extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/extentReport/extent-report.html");

            extentReports=new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);

            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setReportName("Automation Exercise Test");
            extentSparkReporter.config().setDocumentTitle("Automation Exercise");
        }
    }

    public void onTestStart(ITestResult result) {
        extentTest= extentReports.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"Test case passed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL,"Test case failed");
        //extentTest.addScreenCaptureFromBase64String(ScreenshotUtils.takeScreenshotAsBase64());
        String path=ScreenshotUtils.takeScreenshotAsFile();
        System.out.println(path);
        extentTest.addScreenCaptureFromPath(path);
        extentTest.log(Status.INFO, "Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.takeScreenshotAsFile()).build());
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,"Test case skipped");
    }


    public void onFinish(ITestContext context) {
        extentReports.flush();
    }



}
