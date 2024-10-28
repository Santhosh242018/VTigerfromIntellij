package Object_Repository.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation_Org_Icon {
    public Navigation_Org_Icon(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//img[contains(@title,'Create Organization')]")
    private WebElement Org_Icon;

    public WebElement getOrg_Icon() {
        return Org_Icon;
    }

    public void setOrg_Icon()
    {
        Org_Icon.click();
    }
}
