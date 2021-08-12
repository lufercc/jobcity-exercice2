package jobcity.test.steps;

import io.cucumber.java.en.*;
import jobcity.test.pages.BottomMenu;
import jobcity.test.pages.ShoppingCard;
import jobcity.test.pages.SingIn;
import jobcity.test.pages.StorePage;

import org.junit.Assert;

public class StepsDefinition {
    private SingIn singin;
    private BottomMenu bottomMenu;
    private StorePage store;
    private ShoppingCard shoppingCart;

    public StepsDefinition(SingIn singin, BottomMenu bottomMenu, StorePage store, ShoppingCard shoppingCart) {
        this.singin = singin;
        this.bottomMenu = bottomMenu;
        this.store = store;
        this.shoppingCart = shoppingCart;
    }

    @Given("Open Automation Practice page")
    public void openAutomationPracticePage() {
        singin.openPage();
    }

    @When("I click on {string} option in bottom menu")
    public void iClickOnOptionInBottomMenu(String linkName) {
        bottomMenu.goLink(linkName);
    }

    @Then("I expect the {string} has {string} as discount")
    public void iExpectTheHasAsDiscount(String itemName, String percentageExpect) {
        String percentageReduction = store.getPercentageReduction(itemName);
        Assert.assertEquals(percentageReduction, percentageExpect);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        store.clickOn(buttonName);
    }

    @And("I hover {string} then add to the card")
    public void iHoverThenAddToTheCard(String itemName) {
        store.addToCardHover(itemName);
    }

    @And("I go to the Cart dropdown and select {string}")
    public void iGoToTheCartDropdownAndSelectCheckout(String buttonInShopping) {
        store.viewShoppingCard();
        store.clickOn(buttonInShopping);
    }

    @Then("I expect {string} is displayed in summary table and the availability is {string}")
    public void iExpectItemIsDisplayedInSummaryTableAndTheAvailabilityIsStatus(String itemName, String availavilityStatus) {
        Assert.assertEquals(true, shoppingCart.itemIsDisplayed(itemName));
        String status = shoppingCart.getAvailabilityStatus(itemName);
        Assert.assertEquals(availavilityStatus, status);
    }

    @And("I remove {string} from the summary table")
    public void iRemoveItemFromTheSummaryTable(String itemName) {
        shoppingCart.deleteItem(itemName);
    }

    @And("I expect {string} is no longer displayed in the summary table")
    public void iExpectIsNoLongerDisplayedInTheSummaryTable(String itemName) {
        Assert.assertEquals(shoppingCart.itemIsDisplayed(itemName), false);
    }

    @And("I expect the total amount to pay is {string}")
    public void iExpectTheTotalAmountToPayIs(String priceExpected) {
        Assert.assertEquals(shoppingCart.totalPrice(), priceExpected);
    }

    @And("I input {string} in search field")
    public void iInputInSearchField(String text) {
        store.setSearchField(text);
        store.clickOn("Search Button");
    }
}