package GoogleForms;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyStepdefs {
    WebDriver driver;
   

    @Given("^I open the Google form$")
    public void iOpenTheGoogleForm() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://forms.gle/tgJvAHg5h5FpAV5o9");
    }

    @And("^I enter the username and click on next$")
    public void iEnterTheUsernameAndClickOnNext() throws Throwable {
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("ngorrepati@nisum.com");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        String url = driver.getCurrentUrl();
        System.out.println("url >>" + url);
        // assertTrue(url.contains("https://accounts.google.com/signin/"));
    }

    @And("^I enter user name and password in login page$")
    public void iEnterUserNameAndPasswordInLoginPage(DataTable dt) throws Throwable {
        Thread.sleep(2000);

        List<String> list = dt.asList(String.class);

        driver.findElement(By.xpath("//input[@id='okta-signin-username']")).sendKeys(list.get(0));

        driver.findElement(By.xpath("//input[@id='okta-signin-password']")).sendKeys(list.get(1));
        driver.findElement(By.xpath("//input[@id='okta-signin-submit']")).click();
    }
    @Then("^I click on the submit button and click continue$")
    public void I_click_on_the_submit_button_and_click_continue() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Continue']")));
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
    }

    @Then("^I enter the first name and Last name$")
    public void I_enter_the_first_name_and_Last_name(DataTable data) throws Throwable {
        Thread.sleep(2000);
        List<String> list = data.asList(String.class);
        System.out.println(list.get(0));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'entry.954027915')]")));
        driver.findElement(By.xpath("//input[contains(@name,'entry.954027915')]")).sendKeys(list.get(0));
        driver.findElement(By.xpath("//input[contains(@name,'entry.805397959')]")).sendKeys(list.get(1));

    }

    @And("^I select Gender$")
    public void I_select_Gender() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose']")));
        driver.findElement(By.xpath("//span[text()='Choose']")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@jsname='V68bde']/child::div[@jsname='wQNmvb']")));
        List<WebElement> list = driver.findElements(By.xpath("//*[@jsname='V68bde']/child::div[@jsname='wQNmvb']"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().matches("Female"))
            {
                list.get(i).click();
                break;
            }


        }
    }

    @And("^I select Work Experience$")
    public void select_Work_Experience() throws Throwable {

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='mG61Hd']//div[6]/label/div/div[1]")).click();

    }

    @And("^I enter date of birth$")
    public void I_enter_date_of_birth() throws Throwable {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='date']")).sendKeys("03/06/2000");

    }

    @And("^I select the skills$")
    public void I_select_the_skills() throws Throwable {

        Thread.sleep(2000);
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@jsname='JNdkSc']/div"));
        System.out.println(list1.size());

        for (WebElement element : list1) {
            if (element.getText().matches("Functional Testing") || element.getText().matches("Automation Testing")) {
                element.click();

            }
        }
    }

    @And("^I select automation tools$")
    public void I_select_automation_tools() throws Throwable {
        Thread.sleep(2000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView();",e);
        js1.executeScript("window.scrollBy(0, 350)");
        List<WebElement> list = driver.findElements(By.xpath(
                "//*[@jsname='JNdkSc']/following::div[@class='freebirdFormviewerViewItemsCheckboxOptionContainer']"));
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getText());
            if (list.get(i).getText().matches("Selenium Java") || list.get(i).getText().matches("Ui Path")) {

                list.get(i).click();
            }

        }

    }

    @And("^I enter my work experience$")
    public void I_enter_my_work_experience() throws Throwable {



        driver.findElement(By.xpath("//*[@id='mG61Hd']//div[8]//div[1]/div[2]/textarea")).sendKeys("7");
    }

    @And("^I upload the file$")
    public void I_upload_the_file() throws Throwable {

        driver.findElement(By.xpath("//*[@id='mG61Hd']//div[9]//div[3]/span/span")).click();

        driver.switchTo().frame(1);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=':g.select-files-button']/div")).click();
        Thread.sleep(2000);
        Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");

        Thread.sleep(7000);
        Actions a = new Actions(driver);
        WebElement e = driver.findElement(By.xpath("//*[@id='picker:ap:0']"));
        a.moveToElement(e).click().build().perform();

    }

    @And("^I enter current time$")
    public void I_enter_current_time() throws Throwable {

        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@role='combobox' and @aria-label='Hour']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@role='combobox' and @aria-label='Minute']")).sendKeys("11");

    }

    @And("^I enter my signature$")
    public void I_enter_my_signature() throws Throwable {

        driver.findElement(By.xpath("//input[@type='text' and @aria-label='Add your signature.']")).sendKeys("lakshmi");

    }

    @And("^I click on submit button$")
    public void I_click_on_submit_button() throws Throwable {

        WebElement e = driver.findElement(By.xpath("//*[@id='mG61Hd']//div[3]/div[2]//div[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", e);

    }

    @Then("^response has been recorded$")
    public void response_has_been_recorded() throws Throwable {

        String response = driver.getTitle();
        System.out.println(response);
        assertTrue("not responding", response.contains("Selenium Practice Form"));

    }
}


