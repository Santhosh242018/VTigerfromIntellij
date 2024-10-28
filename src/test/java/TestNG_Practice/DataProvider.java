package TestNG_Practice;

import org.testng.annotations.Test;

public class DataProvider {

    @Test(dataProvider = "setData")
    public void bookTickets(String scr, String desc)
    {
        System.out.println("Book Tickets From " + scr + " to " + desc);
    }

   @org.testng.annotations.DataProvider
    public Object[][] setData()
    {
        Object[][] obj_arr = new Object[3][2];
        obj_arr[0][0] = "Repalle";
        obj_arr[0][1] = "Guntur";
        obj_arr[1][0] = "Repalle";
        obj_arr[1][1] = "Amudalapalli";
        obj_arr[2][0] = "Repalle";
        obj_arr[2][1] = "Hyderabad";

        return obj_arr;
    }
}
