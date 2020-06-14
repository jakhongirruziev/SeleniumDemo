package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.MyAccountPage;
import pages.SignInPage;
import utils.ConfigRegisterData;

import java.io.IOException;


@Listeners(listeners.Listeners.class)
public class RegisterTest extends TestBase {
    public static String email;
    public static String firstName;
    public static String lastName;
    public static String password;
    public static String days;
    public static String months;
    public static String years;
    public static String address;
    public static String city;
    public static String state;
    public static String zip;
    public static String country;
    public static String phone;
    public static String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";


    @Test(testName = "Positive case", priority = 1)
    public void register1() throws IOException {
        test = extent.createTest("Register - Positive case");
        // Get data from properties file
        ConfigRegisterData registerData = new ConfigRegisterData();
        registerData.getProperties();

        // Navigates to sign in/register page
        driver.get(loginPageUrl);
        test.pass("Navigates to sign in page");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.setCreateAccountEmail(email); //Enters email address and hits create account button
        test.pass("Enters email address");
        signInPage.createAccount();
        test.pass("Hits create account button");

        // Create account page
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.setTitleMr(); //Fills personal information fields with valid data and hits register button
        test.pass("Sets title to Mr");
        createAccountPage.setFirstName(firstName);
        test.pass("Sets first name");
        createAccountPage.setLastName(lastName);
        test.pass("Sets last name");
        createAccountPage.setPassword(password);
        test.pass("Sets password");
        createAccountPage.setDays(days);
        test.pass("Sets days");
        createAccountPage.setMonths(months);
        test.pass("Sets months");
        createAccountPage.setYears(years);
        test.pass("Sets years");
        createAccountPage.setAddress(address);
        test.pass("Sets address");
        createAccountPage.setState(state);
        test.pass("Sets state");
        createAccountPage.setCity(city);
        test.pass("Sets city");
        createAccountPage.setCountry(country);
        test.pass("Sets country");
        createAccountPage.setZip(zip);
        test.pass("Sets zip code");
        createAccountPage.setPhone(phone);
        test.pass("Sets phone number");
        createAccountPage.register();
        test.pass("Hits register button");

        // My Account page
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.signOut();
        test.pass("Signs out");
        test.info("Verified creating account");
    }

    @Test(testName = "Negative case", priority = 2)
    public void register2() throws IOException, InterruptedException {
        test = extent.createTest("Register - Negative case");
        // Get data from properties file
        ConfigRegisterData registerData = new ConfigRegisterData();
        registerData.getProperties();

        System.out.println(email);
        // Navigates to sign in/register page
        driver.get(loginPageUrl);
        test.pass("Navigates to sign in page");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.setCreateAccountEmail(email); //Enters existing email address and hits create account
        test.pass("Enters existing email address");
        signInPage.createAccount();
        test.pass("Hits create account");
        Assert.assertEquals(driver.getCurrentUrl(), loginPageUrl); // Checks if it did not take to create account page
        test.info("Verified: Unable to create account with existing email");
    }
}
