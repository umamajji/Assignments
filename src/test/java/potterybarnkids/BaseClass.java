package potterybarnkids;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class BaseClass {

    public static ChromeDriver driver;
    public static Properties prop;
    public String json;

    @BeforeClass
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
                //Thread.sleep(10000);
                WebDriverWait wait=new WebDriverWait(driver,100);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='home']/div[10]/div/a[1]")));
                driver.switchTo().frame(0);
                driver.findElement(By.xpath("//*[@id='home']/div[10]//a[1]//following-sibling::div[1]")).click();

            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}