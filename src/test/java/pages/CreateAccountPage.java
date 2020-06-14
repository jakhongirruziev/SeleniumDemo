package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateAccountPage {
    private final WebDriver driver;

    // Web elements
    private final By titleMr = By.xpath("//input[@type='radio'][@name='id_gender']");
    private final By firstName = By.xpath("//input[@type='text'][@name='customer_firstname']");
    private final By lastName = By.xpath("//input[@type='text'][@name='customer_lastname']");
    private final By password = By.xpath("//input[@type='password'][@name='passwd']");
    private final By days = By.xpath("//select[@name='days']");
    private final By months = By.xpath("//select[@name='months']");
    private final By years = By.xpath("//select[@name='years']");
    private final By address = By.xpath("//input[@type='text'][@name='address1']");
    private final By city = By.xpath("//input[@type='text'][@name='city']");
    private final By state = By.xpath("//select[@name='id_state']");
    private final By zip = By.xpath("//input[@type='text'][@name='postcode']");
    private final By country = By.xpath("//select[@name='id_country']");
    private final By phone = By.xpath("//input[@type='text'][@name='phone_mobile']");
    private final By registerButton = By.xpath("//span[contains(text(),'Register')]");

    // Constructor
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    // --------- Page methods -----------
    public void setTitleMr() {
        driver.findElement(titleMr).click();
    }

    public void setFirstName(String FirstName) {
        driver.findElement(firstName).sendKeys(FirstName);
    }

    public void setLastName(String LastName) {
        driver.findElement(lastName).sendKeys(LastName);
    }

    public void setPassword(String Password) {
        driver.findElement(password).sendKeys(Password);
    }

    public void setDays(String Days) {
        driver.findElement(days).sendKeys(Days);
    }

    public void setMonths(String Months) {
        driver.findElement(months).sendKeys(Months);
    }

    public void setYears(String Years) {
        driver.findElement(years).sendKeys(Years);
    }

    public void setAddress(String Address) {
        driver.findElement(address).sendKeys(Address);
    }

    public void setCity(String City) {
        driver.findElement(city).sendKeys(City);
    }

    public void setState(String State) {
        driver.findElement(state).sendKeys(State);
    }

    public void setZip(String Zip) {
        driver.findElement(zip).sendKeys(Zip);
    }

    public void setCountry(String Country) {
        driver.findElement(country).sendKeys(Country);
    }

    public void setPhone(String Phone) {
        driver.findElement(phone).sendKeys(Phone);
    }

    public void register() {
        driver.findElement(registerButton).click();
    }
}
