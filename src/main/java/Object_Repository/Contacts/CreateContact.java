package Object_Repository.Contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {
    public CreateContact(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@title='Create Contact...']")
    private WebElement firstname;
    @FindBy(xpath="//input[@name='lastname']")
    private WebElement lastname;


}
