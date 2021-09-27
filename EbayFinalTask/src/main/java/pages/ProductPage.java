package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    @FindBy(id = "isCartBtn_btn")
    private WebElement addToCart;

    @FindBy(id = "qtyTextBox")
    private  WebElement inputQuantity;

    @FindBy(xpath = "//div[@id = 'w1-15-_errMsg']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[text() = 'Add to Watchlist']")
    private WebElement watchList;

    @FindBy(xpath = "//body[contains(@class, 'vi-contv2')]")
    private WebElement pageWithProduct;

    @FindBy(xpath = "//span[text() = 'Clothing, Shoes & Accessories']")
    private WebElement navigateToFashion;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart(){
        addToCart.click();
    }

    public void inputKeywordInQuantity(final String keyword){
        inputQuantity.click();
        inputQuantity.sendKeys(keyword);
    }

    public String getErrorMessage(){
        char[] array = errorMessage.getText().toCharArray();
        String tmp = "";
        for (char el : array)
        {
            if (!Character.isDigit(el)) tmp += el;
        }
        return tmp;
    }

    public void addToWatchlist(){
        watchList.click();
    }

    public boolean isPageOpen(){
        try{
            return pageWithProduct.isDisplayed();
        }catch (Exception e)
        {
            return false;
        }
    }

    public void clickNavigateToFashion(){
        navigateToFashion.click();
    }

    public String getNavigatePageName(){
        return navigateToFashion.getText();
    }

}
