package VTiger_App_Organization;

import Genaric_Utility.Excel_Utility;
import Genaric_Utility.File_Utility;
import Genaric_Utility.Java_Utility;
import Genaric_Utility.WebDriver_Utility;
import Object_Repository.Home_Page;
import Object_Repository.LoginPage;
import Object_Repository.Organization.Navigation_Org_Icon;
import Object_Repository.Organization.Create_Organization;
import Object_Repository.Organization.Validate_Org_Record;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Create_Organization_Test {
    static WebDriver driver;
    @Test
    public  void create_Organization() throws Throwable {

         // To Avoid the duplicates
        Java_Utility jfile = new Java_Utility();

        //Step 1 : Fetch the Data from Excel
        Excel_Utility efile = new Excel_Utility();
        //get the VTiger URL
        String Url = efile.getExceldataUsingDataFormatter("Sheet1", 1, 0);
        System.out.println("URL : " + Url);

        //get the Organization Name
        String name = efile.getExceldataUsingDataFormatter("Sheet1",1,1) + jfile.getRandomNum();
        System.out.println("Organization Name : " + name);

        //get the Phone Number
        String phone = efile.getExceldataUsingDataFormatter("Sheet1",1,2);
        System.out.println("Phone Number :  " + phone);

        //get the Email
        String email = efile.getExceldataUsingDataFormatter("Sheet1", 1, 3);
        System.out.println("Email : " + email);

        //Step 2 : Launch the Browser and VTiger Application
        WebDriver_Utility wfile = new WebDriver_Utility();
        driver = new ChromeDriver();
        driver.get(Url);
        wfile.maximize_Window(driver);
        wfile.waitForElementsload(driver);

        //Step 3 : Enter the login credentials of VTiger Application from properties file
        File_Utility pfile = new File_Utility();
        String username = pfile.getKeyAndValuePair("User_Name");
        String password = pfile.getKeyAndValuePair("Password");
        LoginPage login = new LoginPage(driver);
        login.login_Vtiger(username, password);

        //Step 4 : Navigate to Organizations page and enter the OrganizationName, Phone number and Email and add the Excel data to consent WebElements
        Home_Page home = new Home_Page(driver);
        home.setOrg_link();
        Navigation_Org_Icon plus_Icon = new Navigation_Org_Icon(driver);
        plus_Icon.setOrg_Icon();
        Create_Organization Org = new Create_Organization(driver);
        Org.Enter_Org(name,phone,email);

        //Step 5 : Check whether record is created or not
        Validate_Org_Record valid = new Validate_Org_Record(driver);
        valid.validate_msg(driver, name);

        //Step 6 : Logout the  Application
        WebDriver_Utility wfiile = new WebDriver_Utility();
        home.setSignoutlink(driver);

        //Quit the Browser
        Thread.sleep(2000);
        driver.quit();

    }
}

