package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private final WebDriver driver;

    // Web elements
    private final By createAccountEmail = By.xpath("//input[@type='text'][@name='email_create']");
    private final By signInEmail = By.xpath("//input[@id='email']");
    private final By password = By.xpath("//input[@id='passwd']");
    private final By createAccountButton = By.xpath("//form[@id='create-account_form']//span[1]");
    private final By signInButton = By.xpath("//p[@class='submit']//span[1]");
    private final By signOutButton = By.xpath("//a[@class='logout']");

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }


    //------------------- Page methods ---------------------
    public void setCreateAccountEmail(String Email) {
        driver.findElement(createAccountEmail).sendKeys(Email);
    }

    public void setSignInEmail(String Email) {
        driver.findElement(signInEmail).sendKeys(Email);
    }

    public void setSignInPassword(String Password) {
        driver.findElement(password).sendKeys(Password);
    }

    public void createAccount() {
        driver.findElement(createAccountButton).click();
    }

    public void signIn() {
        driver.findElement(signInButton).click();
    }

    public void signOut() {
        driver.findElement(signOutButton).click();
    }
}
