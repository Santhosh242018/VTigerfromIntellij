package TestNG_Practice;

import Genaric_Utility.Java_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Org {

    public void create_Org()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8888");
    }

    public void getData()
    {
        Java_Utility jfile = new Java_Utility();
        Object[][] Obj = new Object[2][3];
        Obj[0][0] = "AAA" + jfile.getRandomNum();
        Obj[0][1]  = "6565656565";
        Obj[0][2] = "abc@gmail.com";

        Obj[1][0] = "BBB" + jfile.getRandomNum();
        Obj[1][1]  = "5656565656";
        Obj[1][2] = "def@gmail.com";

    }
}
