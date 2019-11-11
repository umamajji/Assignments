package NewToursProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Flights_Booking_OneWay extends BaseClass{
   // BaseClass base=new BaseClass();    @Test
    @Test
    public void oneway_flight() throws InterruptedException,IOException
    {
        initializeDriver();
        driver.findElement(By.linkText("Flights")).click();
    }

}
