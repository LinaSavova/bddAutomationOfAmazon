package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import static org.testng.Assert.*;

import java.util.List;

public class Electronics extends BasePage {

    private static final By LABEL_AMAZON_CERTIFIED = By.cssSelector(".a-row.a-spacing-small.a-size-base.a-color-secondary span"); //Collection
    private static final By LABEL_PRIME = By.cssSelector(".s-prime"); //Collection pf Prime labels
    private static final By PRICES = By.cssSelector("span.a-price");

    /**
     * Verify that the item contains label "Amazon Certified"
     * @param expectedLabel the label we expect to see
     * @param messageOnFailure message to appear in case of failure in our reports
     */
    public static void verifyAmazonLabel(String expectedLabel, String messageOnFailure) {
        List<WebElement> labelsList = Browser.driver.findElements(LABEL_AMAZON_CERTIFIED);
        String actualLabelFirstElement = labelsList.get(0).getText().trim();
        assertEquals(actualLabelFirstElement, expectedLabel, messageOnFailure);
    }

    public static void verifyPrimeCheckmark(String messageOnFailure) {
        List<WebElement> labelsPrime = Browser.driver.findElements(LABEL_PRIME);
        WebElement actualLabelFirstElement = labelsPrime.get(0);
        assertTrue(actualLabelFirstElement.isDisplayed(), messageOnFailure);
    }

    public static void verifyPriceFirstItem(String expectedPrice, String messageOnFailure) {
        List<WebElement> allPricesListed = Browser.driver.findElements(PRICES);
        String actualPrice = allPricesListed.get(0).getText().replaceAll("\\s", ".");
        assertEquals(actualPrice, expectedPrice, messageOnFailure);


    }
}
