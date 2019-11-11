package NewToursProj;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.uma.BaseTestMethods;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.*;

public class Login extends BaseClass{
  Registration registration=new Registration();

    @Test
    public void registreduser() throws InterruptedException,FileNotFoundException,IOException
    {
        initializeDriver();
        registration.registrationPage();
        Thread.sleep(2000);
     //   driver.findElement(By.linkText("sign-in")).click();
        driver.findElement(By.xpath("//a[contains(text(),'sign-in')]")).click();
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(Registration.uname);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(BaseTestMethods.Password());
        driver.findElement(By.xpath("//input[@name='login']")).click();
    }
    @AfterTest
    public void close()
    {
        driver.close();
    }

}
