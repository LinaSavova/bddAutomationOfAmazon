package pages.frontend;

import core.BasePage;
import gherkin.deps.com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;

import static org.testng.Assert.*;

public class Home extends BasePage {

    private static final By AMAZON_TITLE = By.id("nav-logo-sprites");
    private static final By SIGN_IN_SECTION_UPPER_MENU = By.cssSelector(".nav-line-1-container span");
    private static final By BOOKS_TAB_UPPER_MENU = By.cssSelector("#nav-xshop a:nth-of-type(7)");
    private static final By ACCEPT_COOKIES_BUTTON = By.id("sp-cc-accept");
    private static final By ELECTRONICS_TAB_UPPER_MENU = By.cssSelector("#nav-xshop a:nth-of-type(9)");
    private static final By GIFTS_TAB_UPPER_MENU = By.cssSelector("#nav-xshop a:nth-of-type(8)");
    private static final By PRIME_TAB_UPPER_MENU = By.cssSelector("#nav-xshop a:nth-of-type(6)");
    private static final By TRY_PRIME_BUTTON_FROM_DROPDOWN = By.cssSelector(".pin-link-mask");
    private static final By EMAIL_OR_PHONE_INPUT_FIELD = By.id("ap_email");
    private static final By LOGIN_CONTINUE_BUTTON = By.id("continue");
    private static final By PASSWORD_INPUT_FIELD = By.id("ap_password");
    private static final By LOGIN_SIGN_IN_BUTTON = By.id("signInSubmit");
    private static final By AMAZON_PAGE_TITLE = By.cssSelector(".auth-navbar i");
    private static final By CHANGE_CURRENCY_BOTTOM_BUTTON = By.cssSelector(".icp-color-base");


    /**
     * Opens the area of www.amazon.co.uk
     */
    public static void goTo() {
        Browser.driver.get("https://www.amazon.co.uk/");
        Browser.driver.manage().window().maximize();
    }

    /**
     * Verify that the label SIGN IN appears when Home page is loaded
     * @param expectedSignInLabel the message we expect to see when Home page is loaded
     * @param messageOnFailure the message that appears in case of failure in our reports
     */
    public static void verifySignInSection(String expectedSignInLabel, String messageOnFailure) {
        String actualSignInLabel = getText(SIGN_IN_SECTION_UPPER_MENU);
        assertEquals(actualSignInLabel, expectedSignInLabel, messageOnFailure);
    }

    /**
     * Navigate to Books section from the upper menu
     */
    public static void openBooksSection() {
        click(BOOKS_TAB_UPPER_MENU);
    }

    /**
     * Accept cookies if the popup appears
     */
    public static void acceptCookies() {
        WebElement acceptButton = Browser.driver.findElement(ACCEPT_COOKIES_BUTTON);
        if(acceptButton.isDisplayed()){
            click(ACCEPT_COOKIES_BUTTON);
        }
    }

    /**
     * Opens Electronics section
     */
    public static void openElectronicsSection() {
        click(ELECTRONICS_TAB_UPPER_MENU);
    }

    /**
     * Log in to the area of https://www.amazon.co.uk/
     * @param email email to log in with
     * @param password password to log in with
     */
    public static void logIn(String email, String password) {
        click(SIGN_IN_SECTION_UPPER_MENU);
        type(EMAIL_OR_PHONE_INPUT_FIELD, email);
        click(LOGIN_CONTINUE_BUTTON);
        type(PASSWORD_INPUT_FIELD, password);
        click(LOGIN_SIGN_IN_BUTTON);
    }

    /**
     * Verify successful log out
     * @param messageOnFailure the message that should appear in our reports in case of failure
     */
    public static void verifyLogOutViaSignInSection(String messageOnFailure) {
        WebElement emailField = Browser.driver.findElement(EMAIL_OR_PHONE_INPUT_FIELD);
        assertTrue(emailField.isDisplayed(), messageOnFailure);
    }

    /**
     * Verify the logout page leads to Home page if the page title is tapped
     */
    public static void verifyLogOutPageTitleLeadsToLoginPage() {
        click(AMAZON_PAGE_TITLE);
    }

    /**
     * Opens Gifts Ideas section
     */
    public static void openGiftsIdeasSection() {
        click(GIFTS_TAB_UPPER_MENU);
    }

    /**
     * Opens Prime section
     */
    public static void opensPrimeSection() {
        click(PRIME_TAB_UPPER_MENU);
    }

    /**
     * Scrolls down the page to the bottom button for currency change
     */
    public static void scrollDown() {
        WebElement bottomButton = Browser.driver.findElement(CHANGE_CURRENCY_BOTTOM_BUTTON);
        JavascriptExecutor jse = (JavascriptExecutor)Browser.driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", bottomButton);
    }

    /**
     * Changes the currency from the button on the bottom of the page
     */
    public static void changeCurrencyFromBottom() {
        click(CHANGE_CURRENCY_BOTTOM_BUTTON);
    }
}
