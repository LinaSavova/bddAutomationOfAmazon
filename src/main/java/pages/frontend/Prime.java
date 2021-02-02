package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import static org.testng.Assert.*;

public class Prime extends BasePage {


    private static final By EXPLORE_PRIME_DELIVERY_BUTTON = By.cssSelector("#shipBenefitPanel .a-link-normal");
    private static final By JOIN_PRIME_TEXT = By.cssSelector(".is-right-content");
    private static final By TRY_PRIME_FREE_BUTTON = By.id("a-autoid-0-announce");
    private static final By SIGN_IN_PAGE_TITLE = By.cssSelector(".a-box-inner h1");

    /**
     * Taps the "Explore Prime Delivery" button
     */
    public static void exploreMoreInfo() {
        click(EXPLORE_PRIME_DELIVERY_BUTTON);
    }

    /**
     * Verify that a welcome message is visible explaining the Join Prime benefits
     * @param expectedMessage the message we expect to see on that page
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyPrimeLeadText(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(JOIN_PRIME_TEXT);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Verify that the Try Prime button contains a concrete text
     * @param expectedButtonLabel
     * @param messageOnFailure
     */
    public static void verifyTryButtonLabel(String expectedButtonLabel, String messageOnFailure) {
        String actualButtonLabel = getText(TRY_PRIME_FREE_BUTTON);
        assertEquals(actualButtonLabel, expectedButtonLabel, messageOnFailure);
    }

    public static void verifyTryButtonIClickable(String expectedSignInMessage, String messageOnFailure) {
        click(TRY_PRIME_FREE_BUTTON);
        String actualSignInPageTitle = getText(SIGN_IN_PAGE_TITLE);
        assertEquals(actualSignInPageTitle, expectedSignInMessage, messageOnFailure);


    }

}
