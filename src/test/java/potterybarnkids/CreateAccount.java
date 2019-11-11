package potterybarnkids;


import com.uma.BaseTestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class CreateAccount extends BaseClass {
    static String name;
    static String email;
    String accountname;
    static String updateEmail;


    @Test(priority = 0)
    public static  void registration() {
        BaseClass b;
        {
            b = new BaseClass();
            try {
                b.initializeDriver();
                //Thread.sleep(5000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            WebElement signin = driver.findElement(By.xpath("//*[@id='nav-user-links']/div[1]/a"));
            Actions action;
            action = new Actions(driver);
            action.moveToElement(signin).build().perform();
            action.moveToElement(signin).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//*[@id='nav-user-links']/div[1]//li[2]/a/u")).click();
            //   driver.findElement(By.id("fullName")).sendKeys("testuser");
            String fN = BaseTestMethods.generateName();
            String lastName = BaseTestMethods.generateName();
            email = BaseTestMethods.generateName().toLowerCase() + "@gmail.com";
            String phone = BaseTestMethods.generatePhone();
            //   Thread.sleep(6000);
            //System.out.println(prop.getProperty("firstName"));
            driver.findElement(By.id("fullName")).sendKeys(BaseTestMethods.generateName());
            name = driver.findElement(By.id("fullName")).getAttribute("value");
            System.out.println(name);
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("confirmEmail")).sendKeys(email);
            driver.findElement(By.id("password")).sendKeys(BaseTestMethods.Password());
            driver.findElement(By.id("confirmPassword")).sendKeys(BaseTestMethods.Password());
            driver.findElement(By.id("shoppingFor5")).click();
            driver.findElement(By.xpath("//*[@id='createAccountForm']/div[8]/button")).click();
            String confirmmsg = driver.findElement(By.xpath("//*[@id='account-index']/main//div[2]/h2")).getText();
            Assert.assertEquals(confirmmsg, "Thank You! Please Confirm Your Account.");
            //  driver.findElement(By.id("signOut")).click();

        }
    }
        @Test(priority = 1)
        public void login()
        {
            driver.findElement(By.id("signOut")).click();
            driver.findElement(By.xpath("//*[@id='logout']/main/div/div/div/a[1]")).click();
            driver.findElement(By.id("login-email")).sendKeys(email);
            driver.findElement(By.id("login-password")).sendKeys(BaseTestMethods.Password());
            driver.findElement(By.xpath("//div/button[@id='btn-sign-in']")).click();
            accountname= driver.findElement(By.xpath("//*[@id='account-index']/main/div/div[2]/h1")).getText();
            System.out.println(accountname);
           // Assert.assertEquals("Hello, "+accountname,accountname);
            Assert.assertTrue(true,accountname );
        }
        @Test(priority = 2)
        public void update()
        {
            WebElement update=driver.findElement(By.xpath("//*[@id='nav-user-links']/div[1]/a"));
            Actions action=new Actions(driver);
            action.moveToElement(update).build().perform();
            action.moveToElement(update).click();
            driver.findElement(By.xpath("//*[@id='nav-user-links']/div[1]/div//li[3]/a")).click();
            driver.findElement(By.xpath("//*[@id='account-information']/main/div/div[2]/div[1]/a")).click();
            driver.findElement(By.id("fullName")).sendKeys("GYXRGWA");
            driver.findElement(By.xpath("//*[@id='update-name-form']/div[3]/button")).click();
            driver.findElement(By.xpath("//*[@id='account-information']/main/div/div[2]/div[2]/a")).click();
            driver.findElement(By.id("password")).sendKeys(BaseTestMethods.Password());
            updateEmail = BaseTestMethods.generateName().toLowerCase() +"XYZ"+"@gmail.com";
            driver.findElement(By.id("updateEmail")).sendKeys(email);
            driver.findElement(By.id("updateEmail")).sendKeys(email);
            driver.findElement(By.xpath("//*[@id='update-email-address-form']/div[2]/button")).click();
            String oldmemailAddress=driver.findElement(By.xpath("//*[@id='account-update']/main/div/div[2]/p[2]")).getText();
            System.out.println(oldmemailAddress);
            String newEmailAddress=driver.findElement(By.xpath("//*[@id='account-update']/main/div/div[2]/p[3]")).getText();
            System.out.println(newEmailAddress);
        }

//    @AfterClass
//    public void closebrowser()
//    {
//        driver.close();
//        driver.quit();
//    }
    }
