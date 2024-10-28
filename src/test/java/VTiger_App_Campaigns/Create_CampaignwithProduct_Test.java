package VTiger_App_Campaigns;

import Genaric_Utility.Excel_Utility;
import Genaric_Utility.File_Utility;
import Genaric_Utility.Java_Utility;
import Genaric_Utility.WebDriver_Utility;
import Object_Repository.Home_Page;
import Object_Repository.LoginPage;
import Object_Repository.Compaign.Validate_Campaigns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Create_CampaignwithProduct_Test {
    static WebDriver driver;

@Test
    public void create_Compaignwithproduct() throws Throwable {
        //To avoid duplicates
        Java_Utility jfile = new Java_Utility();

        //Get the details from Excel file
        Excel_Utility efile = new Excel_Utility();
        //get the details from sheets
        String Url = efile.getExcelData("Sheet1", 1, 0);
        System.out.println("URL : " + Url);

        String Pname = efile.getExcelData("Sheet2", 1, 0) + jfile.getRandomNum();
        System.out.println("Product Name : " + Pname);

        String Cname = efile.getExcelData("Sheet3", 1, 0) + jfile.getRandomNum();
        System.out.println("Campaign Name : " + Cname);

        //Launch Application
        WebDriver_Utility wfile = new WebDriver_Utility();
        driver = new ChromeDriver();
        driver.get(Url);
        wfile.maximize_Window(driver);
        wfile.waitForElementsload(driver);

        //Login Application
        File_Utility pfile = new File_Utility();
        String username = pfile.getKeyAndValuePair("User_Name");
        String password = pfile.getKeyAndValuePair("Password");
        LoginPage login = new LoginPage(driver);
        login.login_Vtiger(username, password);

        //Create Product
//        driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
        Home_Page home = new Home_Page(driver);
        home.setProductlink();
        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
        driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Pname);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Create Campaign
        home.setMorelink();
        home.setCompaignlink();
        driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
        driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(Cname);

        //Add Product in Campaign
        // Get the current window handle
        String parentWindow = driver.getWindowHandle();

        // Click to open a new window (product selection window)
        driver.findElement(By.xpath("//img[@title='Select']")).click();

        // Switch to the new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle); // Switch to child window
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(Pname);
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//a[text()='"+Pname+"']")).click();
        driver.switchTo().window(parentWindow);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Step 6 :  Check whether record is created or not
        Validate_Campaigns valid = new Validate_Campaigns(driver);
        valid.Validate_Campaigns(driver, Cname);

        //Step  7 : Logout the Application
       home.setSignoutlink(driver);

//Step 8 : Quit the Browser
        Thread.sleep(2000);
        driver.quit();


    }

}
