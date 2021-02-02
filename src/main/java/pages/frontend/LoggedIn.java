package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;

import java.util.List;

import static org.testng.Assert.*;

public class LoggedIn extends BasePage {

    private static final By USERNAME_SIGNIN = By.id("nav-link-accountList-nav-line-1");
    private static final By SIGN_OUT_LINK = By.id("nav-item-signout");
    private static final By CHANGE_CURRENCY_OR_COUNTRY_UPPER_MENU = By.cssSelector("#nav-tools a:nth-of-type(1)");
    private static final By CURRENCY_DROPDOWN = By.id("a-autoid-0-announce");
    private static final By EURO_CURRENCY_DROPDOWN = By.id("icp-sc-dropdown_4");
    private static final By USD_CURRENCY_DROPDOWN = By.id("icp-sc-dropdown_7");
    private static final By BGN_CURRENCY_DROPDOWN = By.id("icp-sc-dropdown_17");
    private static final By SAVE_CHANGES_BUTTON = By.cssSelector(".a-button-input");
    private static final By CURRENCY_SYMBOLS = By.cssSelector(".a-price-symbol"); //List of all currency symbols of the items in 1 single page
    private static final By CHANGE_COUNTRY_LINK = By.cssSelector(".icp-mkt-change-lnk");
    private static final By COUNTRY_BUTTON = By.id("a-autoid-0-announce");
    private static final By COUNTRY_USA_DROPDOWN = By.cssSelector(".a-lgtbox-vertical-scroll li:nth-of-type(19)");
    private static final By CHANGE_SITE_NOTE = By.cssSelector(".a-column.a-span6.a-text-center span");
    private static final By GO_TO_WEBSITE_BUTTON = By.id("a-autoid-2");
    private static final By US_FLAG_UPPER_MENU = By.cssSelector(".icp-nav-flag-us");

    /**
     * Verify that the correct user is logged in by the correct username is displayed
     * @param expectedUsername the username we expect to see
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyUsername(String expectedUsername, String messageOnFailure) {
        String actualUsername = getText(USERNAME_SIGNIN);
        assertTrue(actualUsername.contains(expectedUsername), messageOnFailure);

    }

    /**
     * Logout from https://www.amazon.co.uk/
     */
    public static void logOut() {
        Actions builder = new Actions(Browser.driver);
        WebElement target = Browser.driver.findElement(USERNAME_SIGNIN);
        builder.moveToElement(target).perform();
        click(SIGN_OUT_LINK);
    }

    /**
     * Change the currency to EUR
     */
    public static void changeCurrencyToEuro() {
        click(CHANGE_CURRENCY_OR_COUNTRY_UPPER_MENU);
        click(CURRENCY_DROPDOWN);
        click(EURO_CURRENCY_DROPDOWN);
        click(SAVE_CHANGES_BUTTON);
    }

    /**
     * Change the currency to USD
     */
    public static void changeCurrencyToUSD() {
        click(CHANGE_CURRENCY_OR_COUNTRY_UPPER_MENU);
        click(CURRENCY_DROPDOWN);
        click(USD_CURRENCY_DROPDOWN);
        click(SAVE_CHANGES_BUTTON);
    }

    public static void changeCurrencyToBGN() {
        click(CHANGE_CURRENCY_OR_COUNTRY_UPPER_MENU);
        click(CURRENCY_DROPDOWN);
        click(BGN_CURRENCY_DROPDOWN);
        click(SAVE_CHANGES_BUTTON);
    }

    /**
     * Verify that the currency on all items displayed is set to EUR
     * @param expectedCurrency the expected currency that should appear
     * @param messageOnFailure message that should appear in case of failure in our reports
     */
    public static void verifyCurrencyChange(String expectedCurrency, String messageOnFailure) {
        List<WebElement> currencySymbols = Browser.driver.findElements(CURRENCY_SYMBOLS);
        WebElement secondInList = currencySymbols.get(1);
        String actualCurrencyOfElement = secondInList.getText();
        assertEquals(actualCurrencyOfElement, expectedCurrency, messageOnFailure);
    }

    public static void changeCountry(String expectedNote, String messageOnFailure) {
        WebElement target = Browser.driver.findElement(CHANGE_CURRENCY_OR_COUNTRY_UPPER_MENU);
        Actions hover = new Actions(Browser.driver);
        hover.moveToElement(target).perform();
        click(CHANGE_COUNTRY_LINK);
        click(COUNTRY_BUTTON);
        click(COUNTRY_USA_DROPDOWN);
        String actualNote = getText(CHANGE_SITE_NOTE);
        assertTrue(actualNote.contains(expectedNote), messageOnFailure);
        click(GO_TO_WEBSITE_BUTTON);

    }

    public static void verifyNewCountryWebsite(String messageOnFailure) {
        Browser.driver.navigate().to("https://www.amazon.com/");
        WebElement flagUS = Browser.driver.findElement(US_FLAG_UPPER_MENU);
        assertTrue(flagUS.isDisplayed(), messageOnFailure);
    }
}
