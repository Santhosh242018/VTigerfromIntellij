package VTiger_App_Organization;

import Genaric_Utility.File_Utility;
import Genaric_Utility.Java_Utility;
import Genaric_Utility.WebDriver_Utility;
import Object_Repository.Home_Page;
import Object_Repository.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrganizationsDataFromPropertiesFile {
    static WebDriver driver;

    public static void main(String[] args) throws Throwable {

        //Step 1 : To avoid duplicates
        Java_Utility jfile = new Java_Utility();
        //Step 1 : Fetch the Data from Properties File
        File_Utility pfile = new File_Utility();

        String Url = pfile.getKeyAndValuePair("Url");
        String Org_Name = pfile.getKeyAndValuePair("Name") + jfile.getRandomNum();
        String Phone_Number =pfile.getKeyAndValuePair("Phone");
        String Email = pfile.getKeyAndValuePair("Email");
        String username = pfile.getKeyAndValuePair("User_Name");
        String password = pfile.getKeyAndValuePair("Password");

//Step 2 : Launch the Browser and VTiger Application
        WebDriver_Utility wfile = new WebDriver_Utility();
        driver = new ChromeDriver();
        driver.get(Url);
        wfile.maximize_Window(driver);
        wfile.waitForElementsload(driver);

        //Step 3 : Enter the login credentials of VTiger Application
        LoginPage login = new LoginPage(driver);
        login.login_Vtiger(username, password);

        //Step 4 : Navigate to Organizations page and enter the OrganizationName, Phone number and Email and add the Excel data to consent WebElements
        Home_Page home = new Home_Page(driver);
        home.setOrg_link();
        driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Org_Name);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(Phone_Number);
        driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(Email);
        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();

        //Step 5 : Check whether record is created or not
        WebElement text = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
        String msg = text.getText();
        System.out.println("Record Created Message : " + msg);
        if (text.isDisplayed()) {
            System.out.println("Record is Created Successfully - Test Case Passed");
        } else {
            System.out.println("Record is not Created - Test Case Failed");
        }

        driver.quit();


    }
}
