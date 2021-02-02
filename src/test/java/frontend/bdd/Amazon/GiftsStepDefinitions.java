package frontend.bdd.Amazon;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.frontend.Gifts;
import pages.frontend.Home;

public class GiftsStepDefinitions {
    @When("he goes to Gift Ideas section")
    public void he_goes_to_Gift_Ideas_section() {
        Home.openGiftsIdeasSection();
    }

    @Then("ensure that there is a {string} filter in the upper right corner")
    public void ensure_that_there_is_a_filter_in_the_upper_right_corner(String expectedLabel) {
        Gifts.verifyFilterIsPresent(expectedLabel, "Missing filter!");
    }

    @Then("the filter has a {string} option into it")
    public void the_filter_has_a_option_into_it(String expectedFilterLabel) {
        Gifts.verifyFilterOptionPriceLowToHigh(expectedFilterLabel, "Wrong filter label is displayed!");
    }

    @Then("the items are rearranged from low to high price when this option is selected")
    public void the_items_are_rearranged_from_low_to_high_price_when_this_option_is_selected() {
        Gifts.verifyItemsArrangedFromLowToHighPrice();
    }

    @Then("ensure that the user can change the filter to {string} option")
    public void ensure_that_the_user_can_change_the_filter_to_option(String expectedLabel) {
        Gifts.verifyFilterCanBeSetToNewArrivals("The same first title after rearrangement!");
    }

    @When("he sorts the items displayed by {string}")
    public void he_sorts_the_items_displayed_by(String string) {
        Gifts.sortByHighToLowPrice();
    }

    @Then("ensure that the items are rearranged from to high to low price")
    public void ensure_that_the_items_are_rearranged_from_to_high_to_low_price() {
        Gifts.verifyFilterOptionPriceHighToLow();
    }
}
