package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class, 'srp-grid')]/li[1]")
    private WebElement productButton;

    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }

    public void clickProductButton(){
        productButton.click();
    }
}
