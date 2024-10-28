package Object_Repository.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Validation_Product {

    public Validation_Product(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void Validation_Product(WebDriver driver, String name)
    {
        String Act_Name = driver.findElement(By.xpath("//span[@id = 'dtlview_Product Name']")).getText();

        if(Act_Name.equals(name))
        {
            System.out.println("Product is created Successfully - Test Case Passed");
        }
        else
        {
            System.out.println("Product is not created - Test Case Failed ");
        }
    }
}
