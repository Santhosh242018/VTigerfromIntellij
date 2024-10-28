package Genaric_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriver_Utility {
    /**
     * This method is used to maximize the window
     * @param driver
     * @Author Santhosh
     */
    public void maximize_Window(WebDriver driver)
    {
        driver.manage().window().maximize();
    }

    /**
     * This method is used to minimize the window
     * @param driver
     * @Author Santhosh
     */
    public void minimize_Window(WebDriver driver){
        driver.manage().window().minimize();
    }

    public void waitForElementsload(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void waitForCondition(WebDriver driver, String Title)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(Title));
    }
    public void customizedWait(WebDriver driver, String Title)
    {
        FluentWait wait = new FluentWait(driver);
        wait.pollingEvery(Duration.ofSeconds(10));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(Title));
    }
    public void alertAccept(WebDriver driver)
    {
        driver.switchTo().alert().accept();
    }
    public void moveToElementCursor(WebDriver driver, WebElement ele)
    {
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
    }
}
