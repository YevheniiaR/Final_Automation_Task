package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage{

    @FindBy(id = "EMAIL_REG_FORM_SUBMIT")
    private WebElement submitRegistr;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Email_err")
    private WebElement emailError;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEnabledSubmit(){

        return submitRegistr.isSelected();
    }

    public void clickEmail(){
        email.click();
    }
    public void clickPassword(){
        password.click();
    }

    public String getEmailError(){
        return emailError.getText();
    }

}
