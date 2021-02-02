package frontend.bdd.Amazon;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.frontend.Basket;
import pages.frontend.Books;
import pages.frontend.Home;
import pages.frontend.PDP;
import utils.Browser;

public class BooksStepDefinitions {

    @Before
    public void setUp(){
        Browser.setup();
    }

    @After
    public void tearDown(){
        Browser.quit();
    }

    @Given("the user is on Home page")
    public void the_user_is_on_Home_page() {
        Home.goTo();
        Home.acceptCookies();
    }

    @When("he goes to Books section")
    public void he_goes_to_Books_section() {
        Home.openBooksSection();
    }

    @When("he searches for {string} book title")
    public void he_searches_for_book_title(String bookTitle) {
        Books.clearSearchField();
        Books.typeBookTitle(bookTitle);
        Books.tapSearchIcon();
    }

    @Then("ensure that the first items has the title: {string}")
    public void ensure_that_the_first_items_has_the_title(String expectedTitle) {
        Books.verifyFirstItemTitle(expectedTitle, "Not the right title is displayed!");
    }

    @Then("it has a badge {string}")
    public void it_has_a_badge(String badgeTitle) {
        Books.verifyBadge(badgeTitle, "No badge text!");
    }

    @Then("it has a type {string}")
    public void it_has_a_type(String expectedType) {
        Books.verifyType(expectedType, "Wrong type is displayed!");
    }

    @Then("ensure that the price is {string}")
    public void ensure_that_the_price_is(String expectedPrice) {
        Books.verifyPrice(expectedPrice, "Wrong price is displayed!!!");
    }

    @When("he taps the type {string}")
    public void he_taps_the_type(String bookType) {
        Books.tapBookType();
    }

    @When("he taps the thumbnail of the first book that is displayed")
    public void he_taps_the_thumbnail_of_the_first_book_that_is_displayed() {
        Books.goToDetailsViaThumbnail();
    }

    @When("he taps the title of the first book that is displayed")
    public void he_taps_the_title_of_the_first_book_that_is_displayed() {
        Books.goToDetailsViaTitle();
    }

    @Then("ensure that the title contains {string}")
    public void ensure_that_the_title_contains(String bookTitle) {
        PDP.verifyItemTitle(bookTitle, "Title does not match!");
    }

    @Then("verify that the {string} badge is displayed")
    public void verify_that_the_badge_is_displayed(String badgeTitle) {
        PDP.verifyBadgeTitle(badgeTitle, "Badge is missing!");
    }

    @Then("verify the price is {string}")
    public void verify_the_price_is(String price) {
        PDP.verifyPrice(price, "Wrong price!");
    }

    @Then("verify that the marked type is {string}")
    public void verify_that_the_marked_type_is(String expectedType) {
        PDP.verifyType(expectedType, "Wrong book type is shown!");
    }

    @When("he adds the book to the basket")
    public void he_adds_the_book_to_the_basket() {
        PDP.addToBasket();
    }

    @Then("verify that a notification is shown with the title {string}")
    public void verify_that_a_notification_is_shown_with_the_title(String expectedTextNotification) {
        Basket.verifyItemAddedNotification(expectedTextNotification, "Missing notification when an item is added to the basket!");
    }

    @Then("there is {string} in the basket")
    public void there_is_in_the_basket(String expectedCount) {
        Basket.verifyItemsCount(expectedCount, "The count of items added is not correct");
    }

    @When("he taps to edit the basket")
    public void he_taps_to_edit_the_basket() {
        Basket.editBasket();
    }

    @Then("verify that the book thumbnail is shown on the list")
    public void verify_that_the_book_thumbnail_is_shown_on_the_list() {
        Basket.verifyThumbnailIsPresent("No thumbnail!");
    }

    @Then("the title {string}")
    public void the_title(String expectedTitle) {
        Basket.verifyBookTitle(expectedTitle, "Wrong title!");
    }

    @Then("the type of print is {string}")
    public void the_type_of_print_is(String expectedType) {
        Basket.verifyBookType(expectedType, "Wrong book type is displayed!");
    }

    @Then("the price is {string}")
    public void the_price_is(String expectedBookPrice) {
        Basket.verifyPrice(expectedBookPrice, "Not the required price is displayed!");
    }

    @Then("quantity is {string}")
    public void quantity_is(String expectedQuantity) {
        Basket.verifyQuantity(expectedQuantity, "Wrong quantity is displayed!");
    }

    @Then("the total price is {string}")
    public void the_total_price_is(String expectedTotalPrice) {
        Basket.verifyTotalPrice(expectedTotalPrice, "Not the required total price is displayed");
    }

    @When("he goes to Basket")
    public void he_goes_to_Basket() {
        Basket.open();
    }

    @Then("ensure that {string} message appears")
    public void ensure_that_message_appears(String expectedMessage) {
        Basket.verifyBasketIsEmpty(expectedMessage, "Missing message for empty Basket");
    }

    @When("he sets the quantity to {string}")
    public void he_sets_the_quantity_to(String setQuantity) {
        PDP.changeQuantity(setQuantity);
    }

    @Then("the price in notification is {string}")
    public void the_price_in_notification_is(String expectedPrice) {
        Basket.verifyPriceInNotification(expectedPrice, "The price displayed ");
    }

    @When("he taps the Delete link")
    public void he_taps_the_Delete_link() {
        Basket.deleteItem();
    }

}
