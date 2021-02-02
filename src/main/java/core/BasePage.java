package core;

import org.openqa.selenium.By;
import utils.Browser;

public class BasePage {

    /**
     * Locate an element, get its text, trim it and return it as a String
     * @param locator locator of the element
     * @return the String that should be seen as a visible element
     */
    protected static String getText(By locator){
        return Browser.driver.findElement(locator).getText().trim();
    }

    /**
     * Finds an element and clicks on it
     * @param locator locator of the element
     */
    protected static void click(By locator){
        Browser.driver.findElement(locator).click();
    }

    /**
     * Finds an element and clear its input
     * @param locator locator of the element
     */
    protected static void clear(By locator){
        Browser.driver.findElement(locator).clear();
    }

    /**
     * Locates an element and types in it
     * @param locator locator of the element
     * @param whatToType the data to type in the field
     */
    protected static void type(By locator, String whatToType){
        Browser.driver.findElement(locator).sendKeys(whatToType);
    }

    /**
     * Finds an element
     * @param locator locator of the element
     */
    protected static void findElement(By locator){
        Browser.driver.findElement(locator);
    }

    protected static void findElements(By locator){
        Browser.driver.findElements(locator); //Returns a list of webElements
    }

}
