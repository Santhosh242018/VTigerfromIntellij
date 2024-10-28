package Object_Repository.Compaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Validate_Campaigns {
    public Validate_Campaigns(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void Validate_Campaigns(WebDriver driver, String Camp_name)
    {
        String Act_Name = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
        if(Act_Name.equals(Camp_name))
        {
            System.out.println("Campaign is created Successfully - Test Case Passed");
        }
        else
        {
            System.out.println("Campaign is not created - Test Case Failed ");
        }
    }
}
