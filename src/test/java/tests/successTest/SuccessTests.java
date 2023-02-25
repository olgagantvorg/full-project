package tests.successTest;

import helpers.ApplicationUsl;
import helpers.Credentials;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class SuccessTests extends BaseTest {

    @Test(dataProvider = "getData",description = "Group of successful tests")
    public void testSuccessLogin(String username,String password){
        driver.get(ApplicationUsl.BASEURL);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login(username,password);
        productsPage.validatePageTitle("PRODUCTS");
        Assert.assertEquals(productsPage.getPageUrl(),ApplicationUsl.BASEURL+"/inventory.html");

    }

    @DataProvider
    public Object [][] getData(){
            return new Object[][]{
                {Credentials.STANDART_USER, Credentials.CORRECT_PASSWORD},
                {Credentials.PROBLEM_USER,Credentials.CORRECT_PASSWORD},
                {Credentials.PERFORMANCE_USER,Credentials.CORRECT_PASSWORD}
            };
    }
}
