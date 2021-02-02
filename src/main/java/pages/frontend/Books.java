package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import static org.testng.Assert.*;

import java.util.List;

public class Books extends BasePage {

    private static final By SEARCH_INPUT_FIELD = By.id("twotabsearchtextbox");
    private static final By SEARCH_ICON = By.id("nav-search-submit-button");
    private static final By SEARCH_RESULTS_TITLES = By.cssSelector(".a-section.a-spacing-none h2 a"); //COLLECTION
    private static final By BEST_SELLER_BADGE_LABEL = By.cssSelector("#B073P9348D-best-seller-label span span");
    private static final By BOOKS_TYPES = By.xpath("//div[@class='a-row a-size-base a-color-base'][1]/a"); // COLLECTION of types
    private static final By BOOKS_PRICES = By.cssSelector("span.a-price"); //COLLECTION of the prices of all books displayed
    private static final By BOOKS_THUMBNAILS = By.cssSelector(".a-section.aok-relative.s-image-fixed-height"); //COLLECTION of the thumbnails of items found

    /**
     * Method to clear the Search field input
     */
    public static void clearSearchField() {
        clear(SEARCH_INPUT_FIELD);
    }

    /**
     * Input the item you are searching for into the Search field
     * @param bookTitle title of the searched item
     */
    public static void typeBookTitle(String bookTitle) {
        type(SEARCH_INPUT_FIELD, bookTitle);
    }

    /**
     * Tap the search icon next to the search field to start the search
     */
    public static void tapSearchIcon() {
        click(SEARCH_ICON);
    }

    /**
     * Verify that the first item has the required title
     * @param expectedFirstItemTitle the title we expect to see
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyFirstItemTitle(String expectedFirstItemTitle, String messageOnFailure) {
        List<WebElement> itemsDisplayed = Browser.driver.findElements(SEARCH_RESULTS_TITLES);
        String actualFirstItemTitle = itemsDisplayed.get(0).getText();
        assertTrue(actualFirstItemTitle.contains(expectedFirstItemTitle), messageOnFailure);
    }

    /**
     * Verify that the item has a badge with a text on it
     * @param expectedBadgeTitle the text we expect to see on the badge
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyBadge(String expectedBadgeTitle, String messageOnFailure) {
        String actualBadgeText = getText(BEST_SELLER_BADGE_LABEL);
        assertEquals(actualBadgeText, expectedBadgeTitle, messageOnFailure);
    }

    /**
     * Verify that the book has a paperback type
     * @param expectedType the type we expect to see
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyType(String expectedType, String messageOnFailure) {
        List<WebElement> allTypesOnePage = Browser.driver.findElements(BOOKS_TYPES);
        String actualType = allTypesOnePage.get(2).getText();
        assertEquals(actualType, expectedType, messageOnFailure);
    }

    /**
     * Verify that the correct price is displayed
     * @param expectedPrice the expected price of the first item
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyPrice(String expectedPrice, String messageOnFailure) {
        List<WebElement> allPricesOnePage = Browser.driver.findElements(BOOKS_PRICES);
        String actualPrice = allPricesOnePage.get(3).getText().replaceAll("\\s",".");
        assertEquals(actualPrice, expectedPrice, messageOnFailure);
    }

    /**
     * Finds the thumbnails of the found items and taps the first one
     */
    public static void goToDetailsViaThumbnail() {
        List<WebElement> allThumbnails = Browser.driver.findElements(BOOKS_THUMBNAILS);
        allThumbnails.get(0).click();
    }

    /**
     * Finds the first title of list and taps it
     */
    public static void goToDetailsViaTitle() {
        List<WebElement> allTitles = Browser.driver.findElements(SEARCH_RESULTS_TITLES);
        WebElement firstTitle = allTitles.get(0);
        firstTitle.click();
    }

    /**
     * Finds the first of paperback items and tap it
     */
    public static void tapBookType() {
        List<WebElement> allBookTypes = Browser.driver.findElements(BOOKS_TYPES);
        WebElement firstPaperback = allBookTypes.get(2);
        int indexOfTypeSelected = allBookTypes.indexOf(firstPaperback);
        allBookTypes.get(indexOfTypeSelected).click();
    }

}
