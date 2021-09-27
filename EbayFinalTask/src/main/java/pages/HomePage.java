package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(linkText = "Fashion")
    private WebElement fashionButton;

    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement inputArea;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[text() = 'register']")
    private WebElement register;




    @FindBy(xpath = "//a[text() = 'Accessories for women']")
    private WebElement accessories;
    @FindBy(xpath = "//nav[@aria-label = 'More categories']")
    private WebElement moreCategories;




    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickFashionButton(){
        fashionButton.click();
    }

    public void typeInputSearch(final String key){
        inputArea.sendKeys(key);
    }

    public void clickSearchInput(){
        searchInput.click();
    }

    public void clickRegister(){
        register.click();
    }



    public void myClick(){

        Actions actions = new Actions(driver);
        actions.moveToElement(fashionButton).click(accessories).perform();
    }



}
