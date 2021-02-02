package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import utils.Browser;

import static org.testng.Assert.*;

public class Basket extends BasePage {

    private static final By ADDED_TO_BASKET_NOTIFICATION = By.cssSelector("#huc-v2-order-row-confirm-text h1");
    private static final By ITEMS_COUNT_NOTIFICATION = By.cssSelector(".a-row.a-spacing-micro span span:nth-of-type(1)");
    private static final By EDIT_BASKET_BUTTON = By.id("hlb-view-cart");
    private static final By ITEM_THUMBNAIL = By.cssSelector(".sc-list-item-content img");
    private static final By ITEM_TITLE = By.xpath("//div[@class='a-fixed-left-grid-col a-col-right']/ul/li/span/a/span[1]");
    private static final By ITEM_TYPE = By.cssSelector(".a-size-small.a-color-secondary.sc-product-binding");
    private static final By ITEM_PRICE = By.cssSelector(".sc-product-price");
    private static final By ITEM_QUANTITY_ONE_ITEM = By.cssSelector(".a-dropdown-prompt");
    private static final By SUBTOTAL_PRICE = By.id("sc-subtotal-amount-activecart");
    private static final By BASKET_UPPER_MENU = By.cssSelector("#nav-tools a:nth-of-type(4)");
    private static final By EMPTY_BASKET_MESSAGE = By.cssSelector(".sc-your-amazon-cart-is-empty");
    private static final By PRICE_NOTIFICATION_BASKET = By.xpath("//div[@class='a-row a-spacing-micro']/span//span[2]");
    private static final By DELETE_ITEM_LINK = By.cssSelector(".sc-action-delete span input");

    /**
     * Verify that a notification appears when an item is added to the basket
     * @param expectedTextNotification the text we expect to see for a successful add
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyItemAddedNotification(String expectedTextNotification, String messageOnFailure) {
        String actualTextNotification = getText(ADDED_TO_BASKET_NOTIFICATION);
        assertEquals(actualTextNotification, expectedTextNotification, messageOnFailure);
    }

    /**
     * Verify that the notification for successful add contains the count of items added
     * @param expectedCount the count we expect to see when an item is added
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyItemsCount(String expectedCount, String messageOnFailure) {
        String actualCount = getText(ITEMS_COUNT_NOTIFICATION);
        assertTrue(actualCount.contains(expectedCount), messageOnFailure);
    }

    /**
     * User goes to the basket
     */
    public static void editBasket() {
        click(EDIT_BASKET_BUTTON);
    }

    /**
     * Verify that a thumbnail of the item is present in the basket
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyThumbnailIsPresent(String messageOnFailure) {
        assertTrue(Browser.driver.findElement(ITEM_THUMBNAIL).isDisplayed(), messageOnFailure);
    }

    /**
     * Verify that the correct item title is shown in the basket
     * @param expectedTitle the title we expect to see
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyBookTitle(String expectedTitle, String messageOnFailure) {
        String actualTitle = getText(ITEM_TITLE);
        assertTrue(actualTitle.contains(expectedTitle), messageOnFailure);
    }

    /**
     * Verify that the correct book type is shown
     * @param expectedType the type we expect to see
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyBookType(String expectedType, String messageOnFailure) {
        String actualType = getText(ITEM_TYPE);
        assertEquals(actualType, expectedType, messageOnFailure);
    }

    /**
     * Verify that the required price is visualized
     * @param expectedBookPrice the price we expect to see
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyPrice(String expectedBookPrice, String messageOnFailure) {
        String actualBookPrice = getText(ITEM_PRICE);
        assertEquals(actualBookPrice, expectedBookPrice, messageOnFailure);

    }

    /**
     * Verify that the required quantity is displayed
     * @param expectedQuantity the quantity that we expect to see when 1 item is added
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyQuantity(String expectedQuantity, String messageOnFailure) {
        String actualQuantity = getText(ITEM_QUANTITY_ONE_ITEM);
        assertEquals(actualQuantity, expectedQuantity, messageOnFailure);

    }

    /**
     * Verify that the required total price is displayed
     * @param expectedTotalPrice the total price we expect to see displayed
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyTotalPrice(String expectedTotalPrice, String messageOnFailure) {
        String actualTotalPrice = getText(SUBTOTAL_PRICE);
        assertEquals(actualTotalPrice, expectedTotalPrice, messageOnFailure);
    }

    /**
     * Opens the basket from the upper menu
     */
    public static void open() {
        click(BASKET_UPPER_MENU);
    }

    /**
     * Verify that the basket is empty when no items are added
     * @param expectedMessage the message we expect to see when open an empty basket
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyBasketIsEmpty(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(EMPTY_BASKET_MESSAGE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    public static void verifyPriceInNotification(String expectedPrice, String messageOnFailure) {
        String actualPrice = getText(PRICE_NOTIFICATION_BASKET);
        assertEquals(actualPrice, expectedPrice, messageOnFailure);

    }

    public static void deleteItem() {
        click(DELETE_ITEM_LINK);
    }
}
