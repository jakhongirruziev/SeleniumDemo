package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductDescriptionPage;


@Listeners(listeners.Listeners.class)
public class PaymentTest extends TestBase {


    @Test(testName = "Payment")
    @Parameters("paymentType")
    public void payment(@Optional("bank") String paymentType) throws InterruptedException {
        // Signs in
        SignInTest signInTest = new SignInTest(driver);
        signInTest.signIn2("jaymail@mail.com", "test123");

        // Adds product to cart
        ShoppingCartTest shoppingCartTest = new ShoppingCartTest(driver);
        int productCount = 1; // Sets product count to be added to shopping cart
        shoppingCartTest.addProductToCart(productCount);
        test.pass("Adds " + productCount + " product(s) to cart");

        // Product Description page
        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
        productDescriptionPage.hitCartButton(); // Navigates to checkout page
        test.pass("Navigates to checkout page");

        test = extent.createTest("Payment test");
        // Checkout page
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToAddress();
        test.pass("Proceeds to address");
        checkoutPage.proceedToShipping();
        test.pass("Proceeds to shipping");
        checkoutPage.checkAgree();
        test.pass("Checks agree");
        checkoutPage.proceedToPayment();
        test.pass("Proceeds to payment");
        if (paymentType.contains("bank")) {
            checkoutPage.payByBankWire();
            test.pass("Hits Pay Bank Wire payment type");
        }
        if (paymentType.contains("check")) {
            checkoutPage.payByCheck();
            test.pass("Hits Pay By Check payment type");
        }
        checkoutPage.confirmOrder();
        test.pass("Hits confirm order button");
        test.info("Verified payment");
    }
}
