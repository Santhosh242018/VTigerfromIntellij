package Object_Repository;

import Genaric_Utility.WebDriver_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

    //Constructor
    public Home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //WebElements
    @FindBy(xpath = "//a[@href='javascript:;'][normalize-space()='More']")
    private WebElement morelink;
    @FindBy(xpath = "//a[@name='Campaigns']")
    private WebElement campainglink;
    @FindBy(linkText = "Organizations")
    private WebElement Org_Link;
    @FindBy(linkText = "Leads")
    private WebElement Leadslink;
    @FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
    private WebElement productlink;
    @FindBy(xpath = "//a[normalize-space()='Contacts']")
    private WebElement contactlink;

    @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement preference;
    @FindBy(xpath = "//a[normalize-space()='Sign Out']")
    private WebElement signoutlink;


    //getter Methods
    public WebElement getContactlink() {
        return contactlink;
    }

    public WebElement getProductlink() {
        return productlink;
    }

    public WebElement getLeadslink() {
        return Leadslink;
    }

    public WebElement getOrg_Link() {
        return Org_Link;
    }

    public WebElement getMorelink() {
        return morelink;
    }

    public WebElement getCampainglink() {
        return campainglink;
    }

    public WebElement getPreference() {
        return preference;
    }

    public WebElement getSignout() {
        return signoutlink;
    }

    //Business Logics
    /**
     * This method is used to click more link
     */
    public void setMorelink() {
        morelink.click();
    }
    /**
     * This method is used to click campaign link
     */
    public void setCompaignlink() {
        campainglink.click();
    }
    /**
     * This method is used to click Organizations link
     */
    public void setOrg_link() {
        Org_Link.click();
    }
    /**
     * This method is used to click the Contacts link
     */
    public void setContactlink() {
        contactlink.click();
    }
    /**
     * This method is used to click the product link
     */
    public void setProductlink() {
        productlink.click();
    }
    /**
     * This method is used to click the Sign out link
     */
    public void setSignoutlink(WebDriver driver) {
        WebDriver_Utility wfile = new WebDriver_Utility();
        wfile.moveToElementCursor(driver, preference);
        signoutlink.click();
    }

}
