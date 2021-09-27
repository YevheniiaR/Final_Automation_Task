package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public AccessoriesPage getAccessoriesPage(){
        return new AccessoriesPage(driver);
    }
    public CartPage getCartPage(){
        return new CartPage(driver);
    }
    public FashionPage getFashionPage(){
        return new FashionPage(driver);
    }
    public HomePage getHomePage(){
        return new HomePage(driver);
    }
    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }
    public SearchPage getSearchPage(){
        return new SearchPage(driver);
    }
    public RegistrationPage getRegistrationPage(){
        return new RegistrationPage(driver);
    }
}
