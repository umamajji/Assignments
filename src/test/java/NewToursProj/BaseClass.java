package NewToursProj;

import static org.junit.Assert.assertTrue;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class BaseClass {

    public static ChromeDriver driver;
    public static Properties prop;
    public String json;

    @Test
    public void initializeDriver() throws IOException, InterruptedException {
        FileInputStream file = new FileInputStream("Config.properties");
        prop = new Properties();
        prop.load(file);

        if (prop.getProperty("browser").equals("chrome")) {

            try {
                System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                Thread.sleep(10000);
                driver.get(prop.getProperty("url"));
                driver.manage().window().maximize();
                Thread.sleep(20000);
                driver.switchTo().frame(0);
                driver.findElement(By.xpath("//*[@id='home']/div[10]/div/a[1]")).click();

            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}