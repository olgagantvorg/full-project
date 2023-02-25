package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CommonElements extends BasePage{
    public CommonElements(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".title")
    private WebElement title;
    public void validatePageTitle(String pagetitle){

        Assert.assertEquals(getElementText(title),pagetitle);
    }

}
