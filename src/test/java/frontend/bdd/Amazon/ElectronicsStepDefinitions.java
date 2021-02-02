package frontend.bdd.Amazon;

import components.Header;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.frontend.Electronics;
import pages.frontend.Home;

public class ElectronicsStepDefinitions {

    @When("he goes to Electronics section")
    public void he_goes_to_Electronics_section() {
        Home.openElectronicsSection();
    }

    @When("he searches for {string}")
    public void he_searches_for(String itemTitle) {
        Header.searchForItem(itemTitle);
    }

    @Then("it contains a label {string}")
    public void it_contains_a_label(String labelCertified) {
        Electronics.verifyAmazonLabel(labelCertified, "Missing \"Amazon Certified\" label");
    }

    @Then("it has a Prime checkmark")
    public void it_has_a_Prime_checkmark() {
        Electronics.verifyPrimeCheckmark("Missing Prime label");
    }

    @Then("ensure that the price of the first item is {string}")
    public void ensure_that_the_price_of_the_first_item_is(String expectedPrice) {
        Electronics.verifyPriceFirstItem(expectedPrice, "The price is not the correct one!");
    }
}
