package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    private final String reportPath = System.getProperty("user.dir") + "/report/";


    public String Screenshot(WebDriver driver) throws IOException {
        String screenshotName = System.currentTimeMillis() + ".png";

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(reportPath + screenshotName));

        return screenshotName;
    }
}
