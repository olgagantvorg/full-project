package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutYourInformationPage extends CommonElements{
    @FindBy(css = "[data-test=\"firstName\"]")
    private WebElement firstNameInput;
    @FindBy(css = "[data-test=\"lastName\"]")
    private WebElement lastNameInput;
    @FindBy(css = "[data-test=\"postalCode\"]")
    private WebElement zipCode;
    @FindBy(css = "[data-test=\"continue\"]")
    private WebElement buttonContinue;
    public CheckOutYourInformationPage(WebDriver driver) {
        super(driver);
    }
    public void fillCheckOutForm(String firstName,String lastName,String postalCode){
        typeText(firstNameInput,firstName);
        typeText(lastNameInput,lastName);
        typeText(zipCode,postalCode);
    }
    public void continueToNextStep(){
        clickElement(buttonContinue);
    }
}
