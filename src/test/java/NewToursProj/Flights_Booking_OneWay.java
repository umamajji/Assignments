package FlightBooking;

import com.google.gson.JsonParser;
import com.uma.BaseTestMethods;
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
    static String email;
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
            s1.selectByValue("1");


         /*   WebElement infant = driver.findElementByXPath("//select[@id='Infants']");
            Select s2 = new Select(infant);
            s2.selectByValue("1");*/

            driver.findElementByXPath("//*[@id='SearchBtn']").click();
            //Thread.sleep(5000);
            WebDriverWait waittime=new WebDriverWait(driver,5000);
            for (int i =1;i<3;i++) {

                WebElement depart = driver.findElement(By.xpath("//nav/ul/li['i']/table/tbody[2]/tr[1]/th[2]"));
                depart.getText();
                System.out.println(depart.getText());
                if(depart.getText().equals("18:50"))
                {
                   driver.findElementByXPath("//ul/li[1]/table/tbody[2]/tr[2]/td[3]/button").click();

                 }
                 else
                 break;
                 driver.findElementByXPath("//*[@id='itineraryBtn']").click();
                email = BaseTestMethods.generateName().toLowerCase() + "@gmail.com";
                driver.findElementByXPath("//input[@id='username']").sendKeys(email);
                driver.findElementByXPath("//*[@id='LoginContinueBtn_1']").click();
                WebDriverWait travellerpage=new WebDriverWait(driver,100);
                WebElement title=driver.findElementByXPath("//section[3]/div[2]/div[3]//form/div[1]/div//dl[1]/dd/select");
                Select sel=new Select(title);
                sel.selectByValue("Mr");
                driver.findElementByXPath("//section[3]//div[3]/div//form/div[1]//div/dl[1]//input[1]").sendKeys("passenger1");
                driver.findElementByXPath("//div[1]/div/div/dl[1]/dd/input[2][@id='AdultLname1']").sendKeys("passenger1");
                WebElement title_psr=driver.findElementByXPath("//*[@id='AdultTitle2']");
                Select sele=new Select(title_psr);
                sele.selectByValue("Mrs");


                driver.findElementByXPath(" //div[1]//section[3]//div[3]/div//form/div[2]/div//dd/input[1]").sendKeys("passenger2");
                driver.findElementByXPath("//div[2]/div/div/dl[1]/dd/input[2][@id='AdultLname2']").sendKeys("passenger2");
                WebElement titlepsr=driver.findElementByXPath("//*[@id='ChildTitle1']");
                Select select=new Select(titlepsr);
                select.selectByValue("Miss");


                driver.findElementByXPath("//section[3]/div[2]/div[3]//form/div[3]/div//dl[1]/dd/input[1]").sendKeys("passenger3");
                driver.findElementByXPath("//div[3]/div/div/dl[1]/dd/input[2][@id='ChildLname1']").sendKeys("passenger3");
               WebElement DOB=driver.findElementByXPath("//*[@id='ChildDobDay1']");
               Select day=new Select(DOB);
               day.selectByValue("5");

               WebElement month=driver.findElementByXPath("//*[@id='ChildDobMonth1']");
               Select mm=new Select(month);
               mm.selectByValue("3");

                WebElement year=driver.findElementByXPath("//*[@id='ChildDobYear1']");
                Select yr=new Select(year);
                yr.selectByValue("2013");
                driver.findElementByXPath("//section[3]/div[2]/div[3]//form/dl[1]/dd/input[1]").sendKeys(BaseTestMethods.generatePhone());
                driver.findElementByXPath("//*[@id='travellerBtn']").click();

                 }

             }
         }

}
