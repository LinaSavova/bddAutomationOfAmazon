package components;

import core.BasePage;
import org.openqa.selenium.By;

public class Header extends BasePage {
    private static final By SEARCH_FIELD_UPPER_MENU = By.id("twotabsearchtextbox");
    private static final By SEARCH_ICON_UPPER_MENU = By.id("nav-search-submit-button");

    public static void searchForItem(String itemTitle) {
        clear(SEARCH_FIELD_UPPER_MENU);
        type(SEARCH_FIELD_UPPER_MENU, itemTitle);
        click(SEARCH_ICON_UPPER_MENU);
    }
}
