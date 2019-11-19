package FlightBooking;

import com.google.gson.JsonParser;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import potterybarnkids.BaseClass;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class FlightBooking_Oneway extends BaseClass {
    @Test
    public void oneway() throws IOException, InterruptedException {

        BaseClass b;
        {
            b = new BaseClass();
            b.initializeDriver();
            WebDriverWait wait=new WebDriverWait(driver,50);
           String heading= driver.findElementByXPath("//*[@id='SearchForm']/h1").getText();
           Assert.assertEquals(heading,"Search flights");
            driver.findElementByXPath("//*[@id='FromTag']").click();
            driver.findElementByXPath("//*[@id='FromTag']").sendKeys("DELHI");
            driver.findElementByXPath("//*[@id='ToTag']").sendKeys("HYDERABAD");
            driver.findElementByXPath("//*[@id='ToTag']").sendKeys(Keys.ARROW_DOWN);
            driver.findElementByXPath("//*[@id='ToTag']").sendKeys(Keys.RETURN);
            WebDriverWait waitTime=new WebDriverWait(driver,50);
            driver.findElementByXPath("//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i").click();
            driver.findElementByXPath("//*[@id='ui-datepicker-div']/div[2]//tr[4]/td[3]/a").click();
            WebDriverWait Wait=new WebDriverWait(driver,50);
            WebElement element = driver.findElementByXPath("//select[@id='Adults']");
            Select s = new Select(element);
            s.selectByValue("2");


            WebElement child = driver.findElementByXPath("//select[@id='Childrens']");
            Select s1 = new Select(child);
            s1.selectByValue("2");


            WebElement infant = driver.findElementByXPath("//select[@id='Infants']");
            Select s2 = new Select(infant);
            s2.selectByValue("2");

            driver.findElementByXPath("//*[@id='SearchBtn']").click();
            //Thread.sleep(5000);
            WebDriverWait waittime=new WebDriverWait(driver,100);
            for (int i =1;i<3;i++) {

                WebElement depart = driver.findElement(By.xpath("//nav/ul/li['i']/table/tbody[2]/tr[1]/th[2]"));
                depart.getText();
                System.out.println(depart.getText());
                if(depart.getText().equals("18:50"))
                {
                   driver.findElementByXPath("//ul/li[1]/table/tbody[2]/tr[2]/td[3]/button").click();

                 }
                driver.findElementByXPath("//*[@id='beforeBaggae']/span[2]/button").click();
                String heading_itenary=driver.findElementByXPath("//*[@id='itineraryOpen']/div[1]/h2").getText();
                Assert.assertEquals(heading_itenary," Itinerary");

                 }

             }
         }

}
