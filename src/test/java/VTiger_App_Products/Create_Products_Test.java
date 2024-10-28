package VTiger_App_Products;

import Genaric_Utility.Excel_Utility;
import Genaric_Utility.File_Utility;
import Genaric_Utility.Java_Utility;
import Genaric_Utility.WebDriver_Utility;
import Object_Repository.Products.CreateProduct;
import Object_Repository.Home_Page;
import Object_Repository.LoginPage;
import Object_Repository.Products.Validation_Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Create_Products_Test {
    static WebDriver driver;

    @Test
    public void create_Product() throws Throwable {

        //To Avoid Duplicates
        Java_Utility jfile = new Java_Utility();
        Excel_Utility efile = new Excel_Utility();

        String Url = efile.getExcelData("Sheet1",1,0);
        System.out.println("URL : " + Url);

        //get the Product Name
        //Cell product = sheet2_row.getCell(0);
        String name = efile.getExcelData("Sheet2", 1, 0)+ jfile.getRandomNum();
        System.out.println("Product Name : " + name);

        //Step 2 : Launch the Browser and VTiger Application
        WebDriver_Utility wfile = new WebDriver_Utility();
        driver = new ChromeDriver();
        driver.get(Url);
        wfile.maximize_Window(driver);
        wfile.waitForElementsload(driver);

        //Step 3 : Enter the login credentials of VTiger Application
        File_Utility pfile = new File_Utility();
        String username = pfile.getKeyAndValuePair("User_Name");
        String password = pfile.getKeyAndValuePair("Password");
        LoginPage login = new LoginPage(driver);
        login.login_Vtiger(username, password);

        //Step 4 : Create the Product
        Home_Page home = new Home_Page(driver);
        home.setProductlink();
        CreateProduct pro = new CreateProduct(driver);
        pro.setCreatepro();
        pro.setProname(name);
        //driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Step 5 : Check whether record is created or not
        Validation_Product valid = new Validation_Product(driver);
        valid.Validation_Product(driver, name);

        //Step  6 : Logout the Application
           home.setSignoutlink(driver);

        Thread.sleep(2000);

       // Step 7 : Quit the browser
         driver.quit();


    }
}
