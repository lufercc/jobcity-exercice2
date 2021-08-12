package jobcity.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class BottomMenu extends AbstractPage {
    @FindBy(css = "[title=\'Best sellers\']")
    private WebElement bestSellersLink;

    private HashMap<String, WebElement> menuElements = new HashMap<>();

    public BottomMenu(){
        menuElements.put("Best sellers", bestSellersLink);
    }

    public void goLink(String linkName){
        action.click(menuElements.get(linkName));
    }
}
