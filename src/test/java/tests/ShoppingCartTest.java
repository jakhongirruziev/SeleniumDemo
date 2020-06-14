package tests;

import listeners.RetryAnalyzer;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDescriptionPage;
import pages.ShoppingCartPage;

import java.util.concurrent.TimeUnit;

@Listeners(listeners.Listeners.class)
public class ShoppingCartTest extends TestBase implements ITestListener {

    // ----- Constructors ------
    public ShoppingCartTest() {
    }

    public ShoppingCartTest(WebDriver driver) {
        this.driver = driver;
    }


    @Test(testName = "Add to shopping cart", priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Parameters("productCount")  //Adds "product count" products to cart
    public void addProductToCart(@Optional("3") int productCount) throws InterruptedException {
        test = extent.createTest("Shopping cart - Add products");

        HomePage homePage = new HomePage(driver);
        for (int i = 0; i < productCount; i++) {
            // Navigates to home page
            driver.get("http://automationpractice.com/index.php");
            test.pass("Navigates to home page");
            homePage.selectProduct(); //Selects product
            test.pass("Selects product number: " + (i + 1));

            // Product Description page
            ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
            productDescriptionPage.hitAddToCartButton();
            test.pass("Hits add to cart button");
            Thread.sleep(2000); // Waits product to be added to cart
            productDescriptionPage.hitCrossButton();
            test.pass("Hits cross button");
        }
        test.info("Verified adding products to cart");
    }

    @Test(testName = "Edit shopping cart", priority = 2)
    public void editShoppingCart() {
        test = extent.createTest("Shopping cart - Edit shopping cart products");

        // Navigates to shopping cart page
        driver.get("http://automationpractice.com/index.php?controller=order");
        test.pass("Navigates to shopping cart page");
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeProduct(); //Removes product
        test.pass("Removes product");
        shoppingCartPage.addProductCount(); //Adds product count
        test.pass("Adds product count");
        shoppingCartPage.reduceProductCount(); //Reduces product count
        test.pass("Reduces product count");
        test.info("Verified editing shopping cart");
    }
}
