package VTiger_App_Campaigns;

import Genaric_Utility.Excel_Utility;
import Genaric_Utility.File_Utility;
import Genaric_Utility.Java_Utility;
import Genaric_Utility.WebDriver_Utility;
import Object_Repository.*;
import Object_Repository.Compaign.Campaign_Create_Icon;
import Object_Repository.Compaign.Create_Campaignpage;
import Object_Repository.Compaign.Validate_Campaigns;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Create_Campaign_Test {
    static WebDriver driver;

    @Test
    public  void create_Campaign() throws Throwable {

        //Step 1 : To avoid duplicates
        Java_Utility jfile = new Java_Utility();

        // Step 2 : get the URL, Username and Password from properties file
        File_Utility pfile = new File_Utility();
        String Url = pfile.getKeyAndValuePair("Url");
        System.out.println("URL : " + Url);
        String username = pfile.getKeyAndValuePair("User_Name");
        System.out.println("User Name : " + username);
        String password = pfile.getKeyAndValuePair("Password");
        System.out.println("Password : " + password);

        //Step 3 : Fetch the Campaign Data from Excel
        Excel_Utility efile = new Excel_Utility();
        //get the Campaign from sheet3
        String Camp_name = efile.getExcelData("Sheet3", 1, 0) + jfile.getRandomNum();
        System.out.println("Campaign Name : " + Camp_name);

        //Step 3 : Launch the Browser and VTiger Application
        WebDriver_Utility wfile = new WebDriver_Utility();
        driver = new ChromeDriver();
        driver.get(Url);
        wfile.maximize_Window(driver);
        wfile.waitForElementsload(driver);

        //Step 4 : Enter the login credentials of VTiger Application
        LoginPage login = new LoginPage(driver);
        login.login_Vtiger(username, password);

       //Step 5 : Navigate to More -> Campaign page
        Home_Page home = new Home_Page(driver);
        home.setMorelink();
        home.setCompaignlink();
        Campaign_Create_Icon campcreate = new Campaign_Create_Icon(driver);
        campcreate.setCampaignplus();
        Create_Campaignpage camppage = new Create_Campaignpage(driver);
        camppage.setCamp_Name(Camp_name);
        //Step 6 :  Check whether record is created or not
        Validate_Campaigns valid = new Validate_Campaigns(driver);
        valid.Validate_Campaigns(driver, Camp_name);

        //Step  7 : Logout the Application
        home.setSignoutlink(driver);

        //Step 8 : Quit the Browser
        Thread.sleep(2000);
        driver.quit();

    }
}
