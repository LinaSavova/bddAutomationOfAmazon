package frontend.bdd.Amazon;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.frontend.Home;
import pages.frontend.Prime;

public class PrimeStepDefinitions {
    @When("he goes to Prime section")
    public void he_goes_to_Prime_section() {
        Home.opensPrimeSection();
    }

    @When("he taps to see more details")
    public void he_taps_to_see_more_details() {
        Prime.exploreMoreInfo();
    }

    @Then("verify that an additional page with detailed information is loaded")
    public void verify_that_an_additional_page_with_detailed_information_is_loaded() {
        Prime.verifyPrimeLeadText("Join Prime today to get amazing delivery benefits along with exclusive ways to shop, stream and more. Cancel anytime.", "Missing welcome message with Prime info!!!");
    }

    @Then("verify that a {string} button is displayed")
    public void verify_that_a_button_is_displayed(String expectedButtonLabel) {
        Prime.verifyTryButtonLabel(expectedButtonLabel, "Try button label differs!!!");
    }

    @Then("the button is usable")
    public void the_button_is_usable() {
        Prime.verifyTryButtonIClickable("Sign-In", "No Sign-in label!");
    }

}
