package VTiger_App_Organization;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.time.Duration;

public class OrganizationsDataFromExcel {
    static WebDriver driver;
    public static void main(String[] args) throws Throwable {
        //Step 1 : Fetch the Data from Excel
        FileInputStream file = new FileInputStream("./Excel/VTiger.xlsx");
        Workbook book = WorkbookFactory.create(file);
        String Url = book.getSheet("Sheet1").getRow(1).getCell(0).toString();
        String name = book.getSheet("Sheet1").getRow(1).getCell(1).toString();
        String phone = book.getSheet("Sheet1").getRow(1).getCell(2).toString();
        String email = book.getSheet("Sheet1").getRow(1).getCell(3).toString();
        book.close();

        //Step 2 : Launch the Browser and VTiger Application
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Login Page Title : " + driver.getTitle());

        //Step 3 : Enter the login credentials of VTiger Application
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();

        //Step 4 : Navigate to Organizations page and enter the OrganizationName, Phone number and Email and add the Excel data to consent WebElements
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(email);
        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();

        //Step 5 : Check whether record is created or not
        WebElement text = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
        String msg = text.getText();
        System.out.println("Record Created Message : " + msg);
        if(text.isDisplayed())
        {
            System.out.println("Record is Created Successfully - Test Case Passed");
        }
        else
        {
            System.out.println("Record is not Created - Test Case Failed");
        }

        driver.quit();

    }
}
