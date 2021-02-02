package frontend.bdd.Amazon;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.frontend.LoggedIn;
import pages.frontend.Home;
import utils.Browser;

public class NavigateToStepDefinitions {

    @After
    public void tearDown(){
        Browser.quit();
    }

    @Given("a Chrome browser is set up")
    public void a_Chrome_browser_is_set_up() {
        Browser.setup();
    }

    @When("user enters amazon.co.uk into the address bar")
    public void user_enters_amazon_co_uk_into_the_address_bar() {
        Home.goTo();
    }

    @Then("ensure the right page is loaded")
    public void ensure_the_right_page_is_loaded() {
        Home.verifySignInSection("Hello, Sign in", "Home page is not loaded properly!");
    }

    @When("he logs in with valid credentials {string} and {string}")
    public void he_logs_in_with_valid_credentials_and(String email, String password) {
        Home.logIn(email, password);
    }

    @Then("ensure the user's name {string} is displayed")
    public void ensure_the_user_s_name_is_displayed(String expectedUsername) {
        LoggedIn.verifyUsername(expectedUsername, "Missing username in the upper corner!");
    }

    @When("he logs out")
    public void he_logs_out() {
        LoggedIn.logOut();
    }

    @Then("verify Sign-In section to appear")
    public void verify_Sign_In_section_to_appear() {
        Home.verifyLogOutViaSignInSection("Missing email field!");
    }

    @Then("amazon.co.uk if tapped leads to LogIn page")
    public void amazon_co_uk_if_tapped_leads_to_LogIn_page() {
        Home.verifyLogOutPageTitleLeadsToLoginPage();
        Home.verifySignInSection("Hello, Sign in", "Home page is not loaded properly!");
    }

    @When("he changes the currency to Euro")
    public void he_changes_the_currency_to_Euro() {
        LoggedIn.changeCurrencyToEuro();
    }

    @Then("verify that the price from here on have {string} label")
    public void verify_that_the_price_from_here_on_have_label(String expectedCurrency) {
        LoggedIn.verifyCurrencyChange(expectedCurrency, "Wrong currency is displayed!");
    }

    @When("he changes the currency to USD")
    public void he_changes_the_currency_to_USD() {
        LoggedIn.changeCurrencyToUSD();
    }

    @When("he changes the currency to BGN")
    public void he_changes_the_currency_to_BGN() {
        LoggedIn.changeCurrencyToBGN();
    }

    @When("he changes the country")
    public void he_changes_the_country() {
        LoggedIn.changeCountry("A new country/region website selection will open in a new tab", "The note for a website change!is missing!!");
    }

    @Then("ensure that the user is redirected to the appropriate site")
    public void ensure_that_the_user_is_redirected_to_the_appropriate_site() {
        LoggedIn.verifyNewCountryWebsite("Wrong flag is displayed!");
    }

    @When("he scrolls down")
    public void he_scrolls_down() {
        Home.scrollDown();
    }

    @When("he taps the {string} button")
    public void he_taps_the_button(String string) {
        Home.changeCurrencyFromBottom();
    }
}
