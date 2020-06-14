package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage {
    private final WebDriver driver;

    // Web elements
    private final By proceedToAddressButton = By.xpath("//div[@id='center_column']//span[contains(text(),'Proceed to checkout')]");
    private final By proceedToShippingButton = By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");
    private final By agreeCheckButton = By.xpath("//input[@id='cgv']");
    private final By proceedToPaymentButton = By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");
    private final By byBankWireButton = By.xpath("//a[@class='bankwire']//span[contains(text(),'(order processing will be longer)')]");
    private final By byCheckButton = By.xpath("//a[@class='cheque']");
    private final By confirmButton = By.xpath("//span[contains(text(),'I confirm my order')]");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    //--------------------- Page methods ------------------
    public void proceedToAddress() {
        driver.findElement(proceedToAddressButton).click();
    }

    public void proceedToShipping() {
        driver.findElement(proceedToShippingButton).click();
    }

    public void checkAgree() {
        driver.findElement(agreeCheckButton).click();
    }

    public void proceedToPayment() {
        driver.findElement(proceedToPaymentButton).click();
    }

    public void payByBankWire() {
        driver.findElement(byBankWireButton).click();
    }

    public void payByCheck() {
        driver.findElement(byCheckButton).click();
    }

    public void confirmOrder() {
        driver.findElement(confirmButton).click();
    }
}
