package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(), 'Item')]")
    private WebElement countProductsInCart;

    @FindBy(xpath = "//span[text() = 'Free shipping']")
    private WebElement freeShipping;

    @FindBy(xpath = "//span[text() = 'Free']")
    private WebElement freeInCart;



    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCountProductsInCart(){
        String tmp = "";
        char[] array = countProductsInCart.getText().toCharArray();
        for (char el : array)
        {
            if (Character.isDigit(el)) tmp += el;
        }
        return tmp;
    }


    public String getFreeFromProduct(){
        String[] array = freeShipping.getText().split("");
        String tmp = "";
        for (int i = 0; i < 4; i++) tmp += array[i];
        return tmp;
    }

    public String getFreeFromCart(){
        return freeInCart.getText();
    }

}
