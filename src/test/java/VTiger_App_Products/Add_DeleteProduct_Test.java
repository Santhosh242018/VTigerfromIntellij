package VTiger_App_Products;

import Genaric_Utility.Excel_Utility;
import Genaric_Utility.File_Utility;
import Genaric_Utility.Java_Utility;
import Genaric_Utility.WebDriver_Utility;
import Object_Repository.Products.CreateProduct;
import Object_Repository.Home_Page;
import Object_Repository.LoginPage;
import Object_Repository.Products.Delete_Product;
import Object_Repository.Products.Validation_Delete_Product;
import Object_Repository.Products.Validation_Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Add_DeleteProduct_Test {
    static WebDriver driver;

    @Test
    public void add_delete_Product() throws Throwable {
        Java_Utility jfile = new Java_Utility();
        Excel_Utility efile = new Excel_Utility();

        //Step1 : get the Product Name
        String name =  efile.getExcelData("Sheet2",1,0)+ jfile.getRandomNum();
        System.out.println("Product Name : " + name);

        //Step 2 : Launch the Browser with VTiger Application
        driver = new ChromeDriver();
        File_Utility pfile = new File_Utility();
        String Url = pfile.getKeyAndValuePair("Url");
        driver.get(Url);
        WebDriver_Utility wfile = new WebDriver_Utility();
        wfile.maximize_Window(driver);
        wfile.waitForElementsload(driver);

        //Step 3 : Enter the login credentials of VTiger Application
        LoginPage login = new LoginPage(driver);
        String username = pfile.getKeyAndValuePair("User_Name");
        String password = pfile.getKeyAndValuePair("Password");
        login.login_Vtiger(username, password);

        //Step 4 : Create Product
        Home_Page home =new Home_Page(driver);
        home.setProductlink();
         CreateProduct createpro = new CreateProduct(driver);
        createpro.setCreatepro();
        createpro.setProname(name);

        //Step 5 : Check whether record is created or not
        Validation_Product valid = new Validation_Product(driver);
        valid.Validation_Product(driver, name);

        //Step 6 : Delete the Product
        home.setProductlink();
        Delete_Product delete = new Delete_Product(driver);
        delete.sel_Proname(driver, name);
        delete.setDelButton();
        Thread.sleep(2000);

        wfile.alertAccept(driver);

        Validation_Delete_Product del_valid = new Validation_Delete_Product(driver);
        del_valid.Delete_Validation(driver, name);

        //Step  7 : Logout the Application
           home.setSignoutlink(driver);

        Thread.sleep(3000);

        // Step 8 : Quit the browser
        driver.quit();

    }
}
