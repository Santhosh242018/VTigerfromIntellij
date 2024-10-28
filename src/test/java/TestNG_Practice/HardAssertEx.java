package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

    @Test
    public void m1()
    {
        System.out.println("Setp1");
        System.out.println("Setp2");
        Assert.assertEquals(false, false);
        System.out.println("Setp3");
        System.out.println("Setp4");
    }

    @Test
    public void m2()
    {
        int a = 10;
        int b = 10;
        Assert.assertEquals(a,b, "Equals = ");
        System.out.println("Both are equal");
    }

    @Test
    public void m3()
    {
        String a = "Cat";
        String b = "Rat";
        Assert.assertNotEquals(a,b,"Not Equals = ");
        System.out.println("Both Strings are not equal");
    }

    @Test
    public void m4()
    {
        String S = "Hello";
        String S1 = "Hello";
        Assert.assertTrue(S.equalsIgnoreCase(S1), "Assert False ");
        System.out.println("Assert True");
    }

    @Test
    public void m5()
    {
        String S = "Hello";
        String S1 = "Hello";
        Assert.assertFalse(S.equalsIgnoreCase(S1), "Assert Contains");
        System.out.println("Assert not contains");
    }

    @Test
    public void m6()
    {
        String S = "Hi";
        Assert.assertNull(S, "It is not null");
        System.out.println("It is null");
    }

    @Test
    public void m7()
    {
        String S = null;
        Assert.assertNull(S, "It is not null");
        System.out.println("It is null");
    }

    @Test
    public void m8()
    {
        int a = 10;
        int b = 10;
        Assert.assertSame(a, b, "Both are not same");
        System.out.println("Both are same");
    }

    @Test
    public void m9()
    {
        int a = 10;
        int b = 20;
        Assert.assertNotSame(a, b, "Both are same");
        System.out.println("Both are not same");
    }

    @Test
    public void m10()
    {
        Assert.fail("I'm failing the Test Script");
    }
}
