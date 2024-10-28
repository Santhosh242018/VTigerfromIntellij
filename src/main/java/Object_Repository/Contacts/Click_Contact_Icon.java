package Object_Repository.Contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Click_Contact_Icon {
    public Click_Contact_Icon(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@title='Create Contact...']")
    private WebElement clickPlusicon;

    public WebElement getClickPlusicon() {
        return clickPlusicon;
    }

    public void setClickPlusicon()
    {
        clickPlusicon.click();
    }
}
