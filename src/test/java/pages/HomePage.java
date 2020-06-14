package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Random;


public class HomePage {
    private final WebDriver driver;

    // Web elements
    private final By product1 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]");
    private final By product2 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/h5[1]/a[1]");
    private final By product3 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[2]/h5[1]/a[1]");
    private final By product4 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[4]/div[1]/div[2]/h5[1]/a[1]");
    private final By product5 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[5]/div[1]/div[2]/h5[1]/a[1]");
    private final By product6 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[6]/div[1]/div[2]/h5[1]/a[1]");
    private final By product7 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[7]/div[1]/div[2]/h5[1]/a[1]");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //--------- Page methods ---------
    public void selectProduct() {
        ArrayList<By> products = new ArrayList<>();
        By randomProduct = null;
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);

        //selects random product
        for (int i = 0; i < products.size(); i++) {
            Random random = new Random();
            int num = random.nextInt(6);
            randomProduct = products.get(num);
        }

        driver.findElement(randomProduct).click();
    }
}
