import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends Base{

    CartPage cartPage;

    @BeforeMethod
    void starting(){
        openBrowser("https://cart.payments.ebay.com/");
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @AfterMethod
    void close(){
        closeBrowser();
    }



    @Test
    void testText(){
        String expected = "You don't have any items in your cart.";
        String actual = cartPage.text();

        Assert.assertEquals(actual, expected);
    }

    @Test
    void testShop(){
        cartPage.clickShop();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

}
