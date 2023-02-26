package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverViewPage extends CommonElements{
    @FindBy(css = "#finish" )
    private WebElement finishButton;
    public CheckoutOverViewPage(WebDriver driver) {
        super(driver);
    }
    public void finishCheckout(){
        clickElement(finishButton);
    }
}
