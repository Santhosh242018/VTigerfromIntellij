package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     public  LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="user_name")
    private WebElement user_Txt;
    @FindBy(name = "user_password")
    private WebElement pwd_Txt;
    @FindBy(id = "submitButton")
    private WebElement login_Button;

//Getter Methods

    public WebElement getUser_Txt() {
        return user_Txt;
    }
    public WebElement getPwd_Txt() {
        return pwd_Txt;
    }

    public WebElement getLogin_Button() {
        return login_Button;
    }

    /**
     * This method is used to login the application
     * @param username
     * @param password
     */

    public void login_Vtiger(String username, String password)
    {
        user_Txt.sendKeys(username);
        pwd_Txt.sendKeys(password);
        login_Button.click();
    }

}
