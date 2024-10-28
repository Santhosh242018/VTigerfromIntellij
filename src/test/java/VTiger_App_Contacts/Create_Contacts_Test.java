package VTiger_App_Contacts;

import Genaric_Utility.Excel_Utility;
import Genaric_Utility.File_Utility;
import Genaric_Utility.Java_Utility;
import Genaric_Utility.WebDriver_Utility;
import Object_Repository.Contacts.Click_Contact_Icon;
import Object_Repository.Home_Page;
import Object_Repository.LoginPage;
import Object_Repository.Organization.Navigation_Org_Icon;
import Object_Repository.Organization.Create_Organization;
import Object_Repository.Organization.Validate_Org_Record;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Create_Contacts_Test {
    static WebDriver driver;
@Test
    public void crate_Contact() throws  Throwable{
        //Fetch the details from File_Utility
        File_Utility pfile = new File_Utility();
        Java_Utility jfile = new Java_Utility();
        Excel_Utility efile = new Excel_Utility();
        WebDriver_Utility wfile = new WebDriver_Utility();

        String url = pfile.getKeyAndValuePair("Url");
        System.out.println("URL : " + url);
        String username = pfile.getKeyAndValuePair("User_Name");
        System.out.println("User Name : " + username);
        String password = pfile.getKeyAndValuePair("Password");
        System.out.println("Password : " + password);

        System.out.println("------------------------------------------------------------");
        System.out.println("New Organization Details");
        System.out.println("------------------------------------------------------------");
        //get the Organization Name
        String name = efile.getExceldataUsingDataFormatter("Sheet1", 1, 1) + jfile.getRandomNum();;
        System.out.println("Organization Name : " + name);

        //get the Organization Phone Number
        String phone = efile.getExceldataUsingDataFormatter("Sheet1", 1, 2);
        System.out.println("Phone Number :  " + phone);

        //get the Organization Email
        String Org_email = efile.getExceldataUsingDataFormatter("Sheet1", 1, 3);
        System.out.println("Email : " + Org_email);

        System.out.println("------------------------------------------------------------");
        System.out.println("New Contact Details");
        System.out.println("------------------------------------------------------------");
        // get the Contacts First Name
        String fname = efile.getExcelData("Sheet4", 1, 0);
        System.out.println("First Name : " + fname);

        //get the Contacts Last Name
        String lname = efile.getExcelData("Sheet4", 1, 1);
        System.out.println("Last Name : " + lname);

        //get the Contacts title
        String title = efile.getExcelData("Sheet4", 1, 2);
        System.out.println("Title : " + title);

        //get the Contacts Department
        String C_dept = efile.getExcelData("Sheet4", 1, 3);
        System.out.println("Department : " + C_dept);

        //get the Contacts Email
        String email = efile.getExcelData("Sheet4", 1, 4);
        System.out.println("Email : " + email);

        //file.close(); // Close the Excel file

        //Step 2 : Launch the Browser and VTiger Application
        driver = new ChromeDriver();
        driver.get(url);
        wfile.maximize_Window(driver);
       wfile.waitForElementsload(driver);
        System.out.println("Login Page Title : " + driver.getTitle());

        //Step 3 : Enter the login credentials of VTiger Application
        LoginPage login = new LoginPage(driver);
        login.login_Vtiger(username, password);

        //Step 4 : Create Organization
        Home_Page home = new Home_Page(driver);
        home.setOrg_link();
        Navigation_Org_Icon plusicon = new Navigation_Org_Icon(driver);
        plusicon.setOrg_Icon();
        Create_Organization Org_Record= new Create_Organization(driver);
        Org_Record.Enter_Org(name, phone, email);

        //Step 5 : Check whether Organization is created or not
        Validate_Org_Record valid = new Validate_Org_Record(driver);
        valid.validate_msg(driver, name);

        //Step 6 : Create Contacts
        home.setContactlink();
        Click_Contact_Icon plussign = new Click_Contact_Icon(driver);
        plussign.setClickPlusicon();
       // driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

        Select sel = new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
        sel.selectByVisibleText("Mr.");
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fname);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lname);
        driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
        //Window Handle..........
        Set<String> allwindows = driver.getWindowHandles();
        Iterator<String> itr = allwindows.iterator();
        while (itr.hasNext())
        {
            String Child_window = itr.next();
            driver.switchTo().window(Child_window);
            String window_title = driver.getTitle();
            System.out.println(window_title);
            if(window_title.contains("Accounts&action"))
            {
                break;
            }
        }
        driver.findElement(By.id("search_txt")).sendKeys(name);
        driver.findElement(By.xpath("//input[@type='button']")).click();
        driver.findElement(By.xpath("//a[text()='"+name+"']")).click();

        //get back to parent window
        Set<String> allwindows1 = driver.getWindowHandles();
        Iterator<String> itr1 = allwindows1.iterator();
        while (itr1.hasNext())
        {
            String Parent_Window = itr1.next();
            driver.switchTo().window(Parent_Window);
            String Win_title = driver.getTitle();
            System.out.println(Win_title);
            if(Win_title.contains("Contacts&action"))
            {
                break;
            }
        }
        sel = new Select(driver.findElement(By.xpath("//select[@name='leadsource']")));
        sel.selectByValue("Employee");
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(title);
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys(C_dept);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='emailoptout']")).click();
        driver.findElement(By.xpath("//input[@name='reference']")).click();
        driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

        //Step 7 : Check record is created or not
        String Act_FirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
        if(Act_FirstName.equals(fname))
        {
            System.out.println("Contacts record is created Successfully - Test Case Passed");
        }
        else
        {
            System.out.println("Contacts record is not created - Test Case Failed ");
        }

        //Step  8 : Sign out the Application

        home.setSignoutlink(driver);

        //Step 9 : Quit the Browser
        Thread.sleep(2000);
        driver.quit();





    }

}
