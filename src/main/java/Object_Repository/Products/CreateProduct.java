package Object_Repository.Products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProduct {

    //Constructor
    public CreateProduct(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //WebElement
    @FindBy(xpath="//img[@title='Create Product...']")
    private WebElement createpro;
    @FindBy(xpath="//input[@name='productname']")
    private WebElement proname;
    @FindBy(xpath="//input[@type='submit']")
    private WebElement submitButton;

    //Getter Methods
    public WebElement getCreatepro() {
        return createpro;
    }
    public WebElement getProname() {
        return proname;
    }
    public WebElement getSubmitButton() {
        return submitButton;
    }
    //Business Logic
    public void setCreatepro()
    {
        createpro.click();
    }

    public void setProname(String name) {
        proname.sendKeys(name);
        submitButton.click();
    }


}
