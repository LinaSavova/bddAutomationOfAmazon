package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class Gifts extends BasePage {

    private static final By SORT_BY_FILTER = By.cssSelector(".a-dropdown-label");
    private static final By FILTER_BY_PRICE_LOW_TO_HIGH = By.id("s-result-sort-select_1");
    private static final By GIFTS_PRICES = By.cssSelector(".a-price");
    private static final By GIFTS_WHOLE_PRICES = By.cssSelector(".a-price-whole");
    private static final By FILTER_BY_NEWEST_ARRIVALS = By.id("s-result-sort-select_4");
    private static final By FILTER_BY_PRICE_HIGH_TO_LOW = By.id("s-result-sort-select_2");
    private static final By SEARCH_RESULTS_TITLES = By.cssSelector(".a-section.a-spacing-none h2 a");



    /**
     * Verify that there is a filter with a "Sort by" label
     * @param expectedLabel the text we expect to see displayed on that filter
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyFilterIsPresent(String expectedLabel, String messageOnFailure) {
        WebElement actualFilter = Browser.driver.findElement(SORT_BY_FILTER);
        assertTrue(actualFilter.isDisplayed());
        String actualLabel = actualFilter.getText();
        assertTrue(actualLabel.contains(expectedLabel), messageOnFailure);
    }

    public static void verifyFilterOptionPriceLowToHigh(String expectedFilterLabel, String messageOnFailure) {
        click(SORT_BY_FILTER);
        String actualFilterLabel = getText(FILTER_BY_PRICE_LOW_TO_HIGH);
        assertEquals(actualFilterLabel, expectedFilterLabel, messageOnFailure);

    }

    public static void verifyItemsArrangedFromLowToHighPrice() {
        click(FILTER_BY_PRICE_LOW_TO_HIGH);
        List<String> obtainedListPrices = new ArrayList<>();
        List<WebElement> allPrices = Browser.driver.findElements(GIFTS_PRICES);
        for (WebElement currPrice : allPrices) {
            obtainedListPrices.add(currPrice.getText().replaceAll("\\s", ".").replace("£", ""));

            System.out.println(obtainedListPrices);
            System.out.println("===================================");
        }
        List<String> sortedList = new ArrayList<>();
        for(String s:obtainedListPrices){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        System.out.println(sortedList);
        assertTrue(sortedList.equals(obtainedListPrices));
    }

    public static void verifyFilterCanBeSetToNewArrivals(String messageOnFailure) {
        List<WebElement> allITEMSTitles = Browser.driver.findElements(SEARCH_RESULTS_TITLES);
        String firstTitle = allITEMSTitles.get(0).getText();
        click(SORT_BY_FILTER);
        click(FILTER_BY_NEWEST_ARRIVALS);
        List<WebElement> titlesAfterFilter = Browser.driver.findElements(SEARCH_RESULTS_TITLES);
        String firstTitleAfterFilter = titlesAfterFilter.get(0).getText();
        assertFalse(firstTitleAfterFilter.equals(firstTitle), messageOnFailure);
    }

    public static void sortByHighToLowPrice() {
        click(SORT_BY_FILTER);
        click(FILTER_BY_PRICE_HIGH_TO_LOW);
    }

    public static void verifyFilterOptionPriceHighToLow() {
        List<Integer> obtainedListPrices = new ArrayList<Integer>();
        List<WebElement> allWholePrices = Browser.driver.findElements(GIFTS_WHOLE_PRICES);

        for (WebElement currWholePrice : allWholePrices) {
            obtainedListPrices.add(Integer.parseInt(currWholePrice.getText()));
            System.out.println(obtainedListPrices);
        }
        //1st variant for comparison:
//        List<Integer> sortedList = new ArrayList<Integer>();
//        for (Integer sortedInt : obtainedListPrices) {
//            sortedList.add(sortedInt);
//        }
//        Collections.sort(sortedList);
//        System.out.println("Sorted list: " + sortedList);
//        assertFalse(sortedList.equals(obtainedListPrices));

        //2nd variant:
        Integer firstElement = obtainedListPrices.get(0);
        Integer secondElement = obtainedListPrices.get(1);
        int length = obtainedListPrices.size();
        System.out.println(length);
        Integer lastElement = obtainedListPrices.get(length - 1);
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        assertTrue(firstElement>secondElement && secondElement>lastElement);
    }

    }


