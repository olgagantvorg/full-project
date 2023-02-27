package tests.errorHandlingTest;

import helpers.ApplicationUsl;
import helpers.Credentials;
import helpers.LoginErrorMessages;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

public class ErrorHandlingTest extends BaseTest {
    @Test (dataProvider = "getData")
    public void errorHandlingLoginTest(String username, String password, String expectedMessage){
        driver.get(ApplicationUsl.BASEURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        Assert.assertEquals(loginPage.getPageUrl(), ApplicationUsl.BASEURL + "/");
        Assert.assertEquals(loginPage.getLoginErrorMessage(),expectedMessage);
    }

    @DataProvider
    public Object [][] getData() {
        return new Object[][]{
                {Credentials.LOCKED_OUT, Credentials.CORRECT_PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
                {Credentials.EMPTY_USERNAME, Credentials.EMPTY_PASSWORD, LoginErrorMessages.EMPTY_USERNAME},
                {Credentials.EMPTY_USERNAME, Credentials.CORRECT_PASSWORD, LoginErrorMessages.EMPTY_USERNAME},
                {Credentials.STANDART_USER, Credentials.EMPTY_PASSWORD, "Epic sadface: Password is required"},
                {Credentials.STANDART_USER, "edgdgdvx", LoginErrorMessages.INCORRECT_NAME_OR_PASS},
                {"gdgdgdgdv", Credentials.CORRECT_PASSWORD, LoginErrorMessages.INCORRECT_NAME_OR_PASS},
    };
    }



}
