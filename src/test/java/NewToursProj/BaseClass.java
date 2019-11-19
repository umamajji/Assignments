package potterybarnkids;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
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

    @Test
    public void initializeDriver() throws IOException, InterruptedException {
        FileInputStream file = new FileInputStream("Config.properties");
        prop = new Properties();
        prop.load(file);

        if (prop.getProperty("browser").equals("chrome")) {

            try {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                Thread.sleep(10000);
                driver.get(prop.getProperty("airlinesUrl"));
                driver.manage().window().maximize();
                if(prop.getProperty("Url").equals("https://www.potterybarnkids.com")) {
                    WebDriverWait wait = new WebDriverWait(driver, 10);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='home']/div[10]/div/a[1]")));
                    driver.switchTo().frame(0);
                    WebElement element = driver.findElement(By.xpath("//*[@id='home']/div[10]/div/a[1]"));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", element);
                }

            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
