package TestNG_Practice;

import org.testng.annotations.Test;


public class Simple_Test {

    @Test
    public void createProduct()
    {
        System.out.println("Create Product");
    }
    @Test(invocationCount = 2)
    public void modifyProduct()
    {
        System.out.println("Modify Product");

    }
    @Test(enabled = false)
    public void deleteProduct()
    {
        System.out.println("Delete Product");
    }
}
