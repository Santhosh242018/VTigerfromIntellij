package Object_Repository.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organization {
    public Create_Organization(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='accountname']")
    private WebElement Org_Name;
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement Org_Phone;
    @FindBy(xpath="//input[@id='email1']")
    private WebElement Org_Email;
    @FindBy(xpath="//input[@name='button']")
    private WebElement saveButton;

     public WebElement getOrg_Name() {
        return Org_Name;
    }

    public WebElement getOrg_Phone() {
        return Org_Phone;
    }

    public WebElement getOrg_Email() {
        return Org_Email;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public void Enter_Org(String name, String Phno, String email){
        Org_Name.sendKeys(name);
        Org_Phone.sendKeys(Phno);
        Org_Email.sendKeys(email);
        saveButton.click();
    }

}
