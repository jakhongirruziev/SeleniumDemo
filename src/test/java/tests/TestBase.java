package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;


    @BeforeClass // Creates browser that's been passed as a parameter
    @Parameters("browserName")
    public void setup(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (browserName.equalsIgnoreCase("headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize(); // Maximizes window size
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Waits before throwing exception

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/report/");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @AfterClass  // Closes the browser
    public void tearDown() {
        driver.close();
        extent.flush();
    }
}
