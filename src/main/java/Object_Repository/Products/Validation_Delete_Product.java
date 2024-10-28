package Object_Repository.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Validation_Delete_Product {

    public Validation_Delete_Product(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void Delete_Validation(WebDriver driver, String name)
    {
        WebElement pro = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+name+"']"));
        if(pro.equals(name))
        {
            System.out.println("Product is present");
        }
        else
        {
            System.out.println("Product is not present ");
        }
    }
}
