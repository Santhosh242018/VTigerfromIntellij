package Object_Repository.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Delete_Product {

    public Delete_Product(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement delButton;

    public void sel_Proname(WebDriver driver, String name)
    {
        driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+name+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
    }

    public WebElement getDelButton() {
        return delButton;
    }
    public void setDelButton()
    {
        delButton.click();
    }
}
