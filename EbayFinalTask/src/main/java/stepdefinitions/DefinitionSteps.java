package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    AccessoriesPage accessoriesPage;
    CartPage cartPage;
    FashionPage fashionPage;
    HomePage homePage;
    ProductPage productPage;
    PageFactoryManager pageFactoryManager;
    SearchPage searchPage;
    RegistrationPage registrationPage;

    @Before
    public void testsSetup(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    /*@After
    public void tearDown(){
        driver.close();
    }*/

    @Given("User opens {string} page")
    public void userOpensHomePagePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }


    @And("User clicks Fashion button")
    public void userClicksFashionButton() {
        homePage.clickFashionButton();
    }

    @And("User click Women's Accessories button")
    public void userClickWomenSAccessoriesButton() {
        fashionPage = pageFactoryManager.getFashionPage();
        fashionPage.clickAccessoriesButton();
    }

    @And("User click product button")
    public void userClickProductButton() {
        accessoriesPage = pageFactoryManager.getAccessoriesPage();
        accessoriesPage.clickProductButton();
    }

    @When("User clicks add to cart")
    public void userClicksAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCart();
    }

    @Then("User checks that amount of products in cart are {string}")
    public void userChecksThatAmountOfProductsInCartAreAmountOfProducts(final String expected) {
        cartPage = pageFactoryManager.getCartPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        String tmp = cartPage.getCountProductsInCart();
        assertEquals(tmp, expected);
    }

    @When("User type {string} amount")
    public void userTypeNotAvailableAmount( final String key) {
        productPage = pageFactoryManager.getProductPage();
        productPage.inputKeywordInQuantity(key);
    }

    @Then("User checks that {string} is appear")
    public void userChecksThatErrorMessageIsAppear(final String errorMessage) {
        productPage = pageFactoryManager.getProductPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        String message = productPage.getErrorMessage();
        assertEquals(message, errorMessage);
    }


    @Then("User checks free shipping in cart")
    public void userChecksFreeShippingInCart() {
        cartPage = pageFactoryManager.getCartPage();
        String productFree = cartPage.getFreeFromProduct();
        String cartFree = cartPage.getFreeFromCart();
        assertEquals(productFree, cartFree);
    }

    @When("User clicks add to watchlist")
    public void userClicksAddToWatchlist() {
        productPage = pageFactoryManager.getProductPage();
        productPage.addToWatchlist();
    }

    @Then("User checks that new page opened")
    public void userChecksThatNewPageOpened() {
        productPage = pageFactoryManager.getProductPage();
        assertFalse(productPage.isPageOpen());
    }


    @When("User type {string} in field")
    public void userTypeKeyInField(final String key) {
        homePage = pageFactoryManager.getHomePage();
        homePage.typeInputSearch(key);
    }

    @And("User clicks search")
    public void userClicksSearch() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickSearchInput();
    }

    @Then("User checks URL contains {string}")
    public void userChecksURLContainsSearchKey(final String key) {
        searchPage = pageFactoryManager.getSearchPage();
        assertTrue(searchPage.getSearchURL().contains(key));
    }

    @When("User clicks button with price")
    public void userClicksButtonWithPrice() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickPriceUnder5();
    }

    @Then("User checks {string} price in filter")
    public void userChecksMaxPriceInFilter(final String maxPrice) {
        searchPage = pageFactoryManager.getSearchPage();
        String maxPriceInFilter = searchPage.getMaxValueInFilter();
        assertEquals(maxPrice, maxPriceInFilter);
    }

    @And("User click registration")
    public void userClickRegistration() {
        homePage.clickRegister();
    }

    @Then("User checks that button not enabled")
    public void userChecksThatButtonNotEnabled() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        registrationPage = pageFactoryManager.getRegistrationPage();
        boolean isEnabled = registrationPage.isEnabledSubmit();
        assertFalse(isEnabled);
    }

    @Then("User see {string}")
    public void userSeeErrorEmailMessage(final String errorMessage) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        String emailError = registrationPage.getEmailError();
        assertEquals(errorMessage, emailError);
    }

    @When("User clicks email")
    public void userClicksEmail() {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.clickEmail();
    }

    @And("User clicks password")
    public void userClicksPassword() {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.clickPassword();
    }

    @When("User NOT type personal information")
    public void userNOTTypePersonalInformation() {
    }

    @Then("User checks page contains more than should products")
    public void userChecksPageContainsMoreThanShouldProducts() {
        searchPage = pageFactoryManager.getSearchPage();
        int expectedCount = Integer.parseInt(searchPage.getAmountProductsOnPage());
        int actualCount = searchPage.getSearchResult();
        assertTrue(expectedCount < actualCount);
    }


    @When("User clicks return to Fashion page")
    public void userClicksReturnToFashionPage() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickNavigateToFashion();
    }


    @Then("User check page name")
    public void userCheckPageName() {
        productPage = pageFactoryManager.getProductPage();
        fashionPage = pageFactoryManager.getFashionPage();
        String navigateName = productPage.getNavigatePageName();
        String pageName = fashionPage.getPageName();
        assertEquals(navigateName, pageName);
    }







    @When("User clicks")
    public void userClicks() {
        homePage = pageFactoryManager.getHomePage();
        homePage.myClick();
    }

    @Then("User check")
    public void userCheck() {
    }
}
