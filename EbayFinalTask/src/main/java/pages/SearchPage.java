package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//h3[@class = 's-item__title']")
    private WebElement searchResult;

    @FindBy(xpath = "//div[text() = 'Under $5.00']")
    private WebElement priceUnder5;

    @FindBy(xpath = "//input[contains(@aria-label, 'Maximum value')]")
    private WebElement maxValue;

    @FindBy(xpath = "//span[text() = '50']")
    private WebElement amountOfProductsOnPage;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchURL(){
        return driver.getCurrentUrl();
    }

    public int getSearchResult(){
        List<WebElement> list = driver.findElements(By.xpath("//h3[@class = 's-item__title']"));
        return list.size();
    }

    public void clickPriceUnder5(){
        priceUnder5.click();
    }

    public String getMaxValueInFilter(){
        return maxValue.getAttribute("value");
    }

    public String getAmountProductsOnPage(){
        return amountOfProductsOnPage.getText();
    }

}
