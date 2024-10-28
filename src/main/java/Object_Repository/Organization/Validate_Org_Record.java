package Object_Repository.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Validate_Org_Record {
    public Validate_Org_Record(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void validate_msg(WebDriver driver, String name)
    {
        WebElement text = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']"));
        String msg = text.getText();
        System.out.println("Record Created Message : " + msg);
        if (msg.equals(name)){
            System.out.println("Record is Created Successfully - Test Case Passed");
        } else {
            System.out.println("Record is not Created - Test Case Failed");
        }
    }
}
