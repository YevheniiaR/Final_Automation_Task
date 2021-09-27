package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FashionPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'b-visualnav__grid']/a[8]")
    private WebElement accessoriesButton;

    @FindBy(xpath = "//span[contains(@class, 'b-pageheader')]")
    private WebElement pageName;

    public FashionPage(WebDriver driver) {
        super(driver);
    }

    public void clickAccessoriesButton(){
        accessoriesButton.click();
    }

    public String getPageName(){
        return pageName.getText();
    }
}
