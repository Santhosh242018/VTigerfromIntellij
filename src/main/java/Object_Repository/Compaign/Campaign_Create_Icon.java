package Object_Repository.Compaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign_Create_Icon {

    //Constructor
    public Campaign_Create_Icon(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //WebElements
    @FindBy(xpath = "//img[@title='Create Campaign...']")
    private WebElement Campaignplus;

    //getter method
    public WebElement getCampaignplus() {
        return Campaignplus;
    }
    //Business logic
    public void setCampaignplus()
    {
        Campaignplus.click();
    }
}
