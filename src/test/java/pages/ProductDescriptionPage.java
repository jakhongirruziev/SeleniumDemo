package pages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;


public class ProductDescriptionPage {
    private final WebDriver driver;

    // Web elements
    private final By addToCartButton = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[3]/div[1]/p[1]/button[1]/span[1]");
    private final By crossButton = By.xpath("//span[@title='Close window']");
    private final By cartButton = By.xpath("//b[contains(text(),'Cart')]");

    // Constructor
    public ProductDescriptionPage(WebDriver driver) {
        this.driver = driver;
    }


    //------------- Page methods --------------
    public void hitAddToCartButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);     //Waits until "add to cart" is visible
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        js.executeScript("arguments[0].scrollIntoView();", addToCart); //Scrolls to button
        addToCart.click();
    }

    public void hitCrossButton() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement cross = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(crossButton);
            }
        });
        cross.click();
    }

    public void hitCartButton() {
        driver.findElement(cartButton).click();
    }
}
