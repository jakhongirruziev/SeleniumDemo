package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SignInPage;
import utils.ExcelUtils;


@Listeners(listeners.Listeners.class)
public class SignInTest extends TestBase {
    public String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private SignInPage signInPage;

    // ----- Constructors ------
    public SignInTest() {
    }

    public SignInTest(WebDriver driver) {
        this.driver = driver;
    }


    @DataProvider(name = "SignInNegative") //Gets data with invalid email and passwords
    public Object[] getInvalidData() {
        String projectPath = System.getProperty("user.dir");
        Object[][] data = testData(projectPath + "/excel/Book1.xlsx", "Sheet1");

        return data;
    }

    @DataProvider(name = "SignInPositive") //Gets data with valid email and passwords
    public Object[] getValidData() {
        String projectPath = System.getProperty("user.dir");
        Object[][] data = testData(projectPath + "/excel/Book1.xlsx", "Sheet2");

        return data;
    }

    //Gets data from excel sheet
    public Object[][] testData(String excelFilePath, String sheetName) {
        ExcelUtils excelUtils = new ExcelUtils(excelFilePath, sheetName);

        int rowCount = excelUtils.getRowCount();
        int columnCount = excelUtils.getColumnCount();

        Object[][] data = new Object[rowCount - 1][columnCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                String cellData = excelUtils.getCellData(i, j);
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }

    @Test(testName = "Negative case", dataProvider = "SignInNegative", priority = 1)
    public void signIn1(String email, String password) {
        test = extent.createTest("Sign in - Negative case");

        // Navigates to sign in/register page
        driver.get(loginPageUrl);
        test.pass("Navigates to sign in page");
        signInPage = new SignInPage(driver);
        signInPage.setSignInEmail(email);
        test.pass("Enters email");
        signInPage.setSignInPassword(password);
        test.pass("Enters password");
        signInPage.signIn();
        test.pass("Hits sign in button");
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication");
        test.info("Verified: Unable to sign in with invalid inputs");
    }

    @Test(testName = "Positive case", dataProvider = "SignInPositive", priority = 2)
    public void signIn2(String email, String password) {
        test = extent.createTest("Sign in - Positive case");
        // Checks if already signed in
        if (driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
            // My account page
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.signOut();
            test.pass("Hits sign out button");
        }


        // Navigates to sign in/register page
        driver.get(loginPageUrl);
        test.pass("Navigates to sign in page");

        signInPage = new SignInPage(driver);
        signInPage.setSignInEmail(email); //Enters valid Email and valid Password and hits sign in button
        test.pass("Enters valid Email");
        signInPage.setSignInPassword(password);
        test.pass("Enters valid Password");
        signInPage.signIn();
        test.pass("Hits sign in button");

        test.info("Verified sign in");
    }
}
