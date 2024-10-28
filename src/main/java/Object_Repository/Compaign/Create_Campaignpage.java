package Object_Repository.Compaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campaignpage {

    public Create_Campaignpage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@name='campaignname']")
    private WebElement camp_Name;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement saveButton;

    public WebElement getCamp_Name() {
        return camp_Name;
    }
    public WebElement getSaveButton() {
        return saveButton;
    }
    public void setCamp_Name(String campName)
    {
                camp_Name.sendKeys(campName);
                saveButton.click();
    }
}
