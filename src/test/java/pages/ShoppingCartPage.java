package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShoppingCartPage {
    private final WebDriver driver;

    // Web elements
    private final By trashButton = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/a[1]/i[1]");
    private final By addCountButton = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[2]/span[1]/i[1]");
    private final By reduceCountButton = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[1]/span[1]/i[1]");

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }


    //-------------- Page methods -----------------
    public void removeProduct() {
        driver.findElement(trashButton).click();
    }

    public void addProductCount() {
        driver.findElement(addCountButton).click();
    }

    public void reduceProductCount() {
        driver.findElement(reduceCountButton).click();
    }
}
