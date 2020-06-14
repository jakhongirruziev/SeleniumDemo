package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private final WebDriver driver;

    // Web elements
    private final By signOutButton = By.xpath("//a[@class='logout']");

    // Constructor
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    //------------------- Page methods ---------------------
    public void signOut() {
        driver.findElement(signOutButton).click();
    }
}
