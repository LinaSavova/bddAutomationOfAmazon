package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

import static org.testng.Assert.*;

public class PDP extends BasePage {

    private static final By PRODUCT_TITLE = By.id("productTitle");
    private static final By PRODUCT_BADGE = By.cssSelector(".p13n-best-seller-badge");
    private static final By PRODUCT_PRICE = By.cssSelector(".swatchElement.selected.resizedSwatchElement .a-color-price");
    private static final By PRODUCT_SUBTITLE_TYPE = By.id("productSubtitle");
    private static final By ADD_TO_BASKET_BUTTON = By.id("add-to-cart-button");
    private static final By QUANTITY_DROPDOWN = By.name("quantity");

    /**
     * Verify that the title in PDP is as on PDL(Books) page
     * @param expectedProductTitle the title we expect to see when opening the Product Details Page
     * @param messageOnFailure the message that appears in case of failure in our reports
     */
    public static void verifyItemTitle(String expectedProductTitle, String messageOnFailure) {
        String actualProductTitle = getText(PRODUCT_TITLE);
        assertTrue(actualProductTitle.contains(expectedProductTitle), messageOnFailure);
    }

    /**
     * Verify that the correct text is into the badge
     * @param expectedBadgeTitle the text we expect to see into the badge
     * @param messageOnFailure the message that appears in case of failure in our reports
     */
    public static void verifyBadgeTitle(String expectedBadgeTitle, String messageOnFailure) {
        String actualBadgeTitle = getText(PRODUCT_BADGE);
        assertEquals(actualBadgeTitle, expectedBadgeTitle, messageOnFailure);
    }

    /**
     * Verify that the required price is displayed
     * @param expectedPrice the price we expect to see
     * @param messageOnFailure the message that appears in case of failure in our reports
     */
    public static void verifyPrice(String expectedPrice, String messageOnFailure) {
        String actualPrice = getText(PRODUCT_PRICE);
        assertEquals(actualPrice, expectedPrice, messageOnFailure);
    }

    /**
     * Verify that the type of the book in PDP is as expected
     * @param expectedType expected type of the selected book
     * @param messageOnFailure the message that appears in case of failure in our reports
     */
    public static void verifyType(String expectedType, String messageOnFailure) {
        String actualType = getText(PRODUCT_SUBTITLE_TYPE);
        assertTrue(actualType.contains(expectedType), messageOnFailure);
    }

    /**
     * Add an item to the basket
     */
    public static void addToBasket() {
        click(ADD_TO_BASKET_BUTTON);
    }

    /**
     * Change the quantity of an item from the drop down Quantity
     */
    public static void changeQuantity(String setQuantity) {
        WebElement dropDown = Browser.driver.findElement(QUANTITY_DROPDOWN);
        Select quantity = new Select(dropDown);
        quantity.selectByValue(setQuantity);
    }
}
