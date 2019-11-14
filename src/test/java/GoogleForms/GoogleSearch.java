package GoogleForms;

import NewToursProj.BaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoogleSearch extends BaseClass {

    @Given("^I click on the Google link")
    public void GoogleSearch() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @And("^I enter keyword as \"([^\"]*)\" in search bar$")
    public void iEnterKeywordAsInSearchBar(String arg1) throws Throwable {
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(arg1);
    }

    @And("^I validate whether selected company is first option from drop down$")
    public void iValidateWhetherSelectedCompanyIsFirstOptionFromDropDown() throws Throwable {
        WebElement element = driver.findElement(By.className("erkvQe"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        List<WebElement> list = element.findElements(By.tagName("li"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {

            String company=list.get(0).getText();
            assertTrue("not first option from drop down",company.equalsIgnoreCase("nisum technologies"));
            break;
        }

    }

    @And("^I select the options from the drop down$")
    public void iSelectTheOptionsFromTheDropDown() throws Throwable {
        WebElement element = driver.findElement(By.className("erkvQe"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        List<WebElement> list = element.findElements(By.tagName("li"));
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getText().equalsIgnoreCase("nisum technologies")) {
                list.get(i).click();

                break;
            }

        }
    }
    @And("^I click on (\\d+)st link in search options$")
    public void i_click_on_st_link_in_search_options(int arg1) throws Throwable {
        driver.findElement(By.xpath("//h3[contains(text(), 'Nisum: inicio')]")).click();

        String title = driver.getTitle();
        System.out.println(title);
        assertTrue("not valid", title.equalsIgnoreCase("inicio | Nisum"));
    }
}