package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ScreenshotUtils {
    public static ByteArrayInputStream takeScreenshotAsBytes(){
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        return new ByteArrayInputStream(screenshot);
    }

    public static String takeScreenshotAsBase64(){
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        String screenshot=ts.getScreenshotAs(OutputType.BASE64);
        return screenshot;
    }

    public static String takeScreenshotAsFile() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Random rand = new Random(1000);
        String screenshotFolderPath = System.getProperty("user.dir") + "/extentReport/";
        String screenshotName = "screenshot" + rand.nextInt() + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(screenshotFolderPath + screenshotName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshotName;
    }
}
