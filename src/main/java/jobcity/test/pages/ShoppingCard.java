package jobcity.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCard extends AbstractPage {

    @FindBy(css = "#total_price")
    WebElement totalPrice;

    private final static String ITEM_INTO_CARD = "//p[@class='product-name' and .=\"%s\"]" ;
    private final static String ITEM_AVAILABILITY = "//p[@class='product-name' and .=\"%s\"]/ancestor::td/following-sibling::td[@class=\"cart_avail\"]/child::span[@class=\"label label-success\"]";
    private final static String ITEM_DELETE = "//p[@class='product-name' and .=\"%s\"]/ancestor::td/following-sibling::td[@class=\"cart_delete text-center\"]/descendant::i[@class=\"icon-trash\"]";

    public boolean itemIsDisplayed(String itemName) {
        return action.isElementPresent(By.xpath(String.format(ITEM_INTO_CARD, itemName)));
    }

    public String getAvailabilityStatus( String itemName) {
        String locator = String.format(ITEM_AVAILABILITY, itemName);
        return action.getText(By.xpath(locator));

    }

    public void deleteItem( String itemName) {
        String locator = String.format(ITEM_DELETE, itemName);
        action.click(By.xpath(locator));
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public String totalPrice(){
        return action.getText(totalPrice);
    }
}
