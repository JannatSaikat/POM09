import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    static WebDriver driver;

    void openBrowser(String url){
        driver = new ChromeDriver();
        driver.get(url);
    }

    void closeBrowser(){
        driver.quit();
    }

    void waitForElementVisibility(int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time) );
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    void waitForElementClickable(int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time) );
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
