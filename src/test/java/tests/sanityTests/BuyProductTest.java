package tests.sanityTests;

import helpers.ApplicationUsl;
import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

public class BuyProductTest extends BaseTest {
    @Test
    public void buyProductsTest(){
        driver.get(ApplicationUsl.BASEURL);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login(Credentials.STANDART_USER,Credentials.CORRECT_PASSWORD);

        productsPage.validatePageTitle("PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(),ApplicationUsl.BASEURL+"/inventory.html");

        int productsAmount = productsPage.chooseProduct("Sauce Labs Backpack","Sauce Labs Fleece Jacket","Sauce Labs Onesie");
        productsPage.validateNumberOfAddedItems(productsAmount);
        productsPage.goToCart();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.validatePageTitle("YOUR CART");
        yourCartPage.validateCartItemsAmount(productsAmount);
        yourCartPage.checkOut();

        CheckOutYourInformationPage checkOutYourInformationPage = new CheckOutYourInformationPage(driver);
        checkOutYourInformationPage.validatePageTitle("CHECKOUT: YOUR INFORMATION");
        checkOutYourInformationPage.fillCheckOutForm("Olga","Gant","195279");
        checkOutYourInformationPage.continueToNextStep();

        CheckoutOverViewPage checkoutOverViewPage = new CheckoutOverViewPage(driver);
        checkoutOverViewPage.validatePageTitle("CHECKOUT: OVERVIEW");
        checkoutOverViewPage.finishCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.validatePageTitle("CHECKOUT: COMPLETE!");
        checkoutCompletePage.validateCompleteHeader("THANK YOU FOR YOUR ORDER");
    }

}
