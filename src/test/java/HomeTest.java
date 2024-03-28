import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest extends Base{

    HomePage homePage;

    @BeforeMethod
    void starting(){
        openBrowser("https://ebay.com");
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    void finishTest(){
        closeBrowser();
    }


    @Test(enabled = false, priority = 0, groups = {"smoke"})
    void testFashion(){
        String expectedTitle = "Clothing, Shoes & Accessories for sale | eBay + 2";
        homePage.clickFashion();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(enabled = false)
    void testWoCloth(){
        homePage.moveToFashion();
        homePage.clickWomenClothing();
        String expectedUrl = "https://www.ebay.com/b/Womens-Clothing/15724/bn_661783";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 0, enabled = true)
    void testSearch(){
        String key = "iphone";
        homePage.search(key);
        String  currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains(key));
    }

    @Test(priority = 1)
    void testAbout(){
        String expectedText = "About eBay";
        String actualText = homePage.textAbout();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 2, groups = {"smoke"})
    void testLinks(){
//        Assert.assertEquals(homePage.allLinks(), 453);
        Assert.assertTrue(homePage.allLinks() > 400);
    }
}
