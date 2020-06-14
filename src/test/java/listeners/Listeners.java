package listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.TestBase;
import utils.Screenshot;

import java.io.IOException;


public class Listeners extends TestBase implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*********************** TEST FAILED ******************************");
        try {
            Screenshot take = new Screenshot();
            String screenshot = take.Screenshot(driver);
            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

