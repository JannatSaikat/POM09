import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Base{

    @FindBy(xpath = "//*[@id=\"mainContent\"]  //a[contains(text(),'Fashion')]")
    WebElement fashion;

    @FindBy(xpath = "//a[@_sp=\"p4375194.m1383.l3251\"]")
    WebElement womenClothing;

    @FindBy(css = "input[placeholder=\"Search for anything\"]")
    WebElement searchBox;

    @FindBy(css = "[_sp=\"m571.l2932\"]")
    WebElement aboutEbay;

    @FindBy(xpath = "//a")
    List<WebElement> links;

    void clickFashion(){
        fashion.click();
    }

    void moveToFashion(){
        Actions actions = new Actions(driver);
        actions.moveToElement(fashion);
    }

    void clickWomenClothing(){
        womenClothing.click();
    }

    void search(String searchKey){
        waitForElementVisibility(10, searchBox);
        searchBox.sendKeys(searchKey, Keys.ENTER);
    }

    String textAbout(){
      return aboutEbay.getText();
    }

    int allLinks(){
        return links.size();
    }
}
