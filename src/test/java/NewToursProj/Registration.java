package NewToursProj;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.rowset.internal.Row;
import com.uma.BaseTestMethods;
import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.reporters.XMLReporter.FILE_NAME;

public class Registration extends BaseClass {
    //BaseClass login = new BaseClass();
    public String json;
    public static String uname;
   @Test
    public void registrationPage() {
        try {
            //initializeDriver();
            Thread.sleep(2000);

            JsonParser parser=new JsonParser();
            InputStream inputStream= getClass().getClassLoader().getResourceAsStream("Locators.json");
            Reader reader=new InputStreamReader(inputStream);
            JsonElement rootelement=parser.parse(reader);
            JsonObject rootobject=rootelement.getAsJsonObject();
            JsonElement fname = rootobject.get("firstName");
            JsonElement lname = rootobject.get("lastName");
            //JsonObject pages=rootobject.get("lastName");
            String lnn=lname.toString().replace("\"", "");


            driver.findElement(By.xpath(prop.getProperty("Register_lnk"))).click();

            String fN = BaseTestMethods.generateName();
            String lastName     = BaseTestMethods.generateName();
            String email = BaseTestMethods.generateName().toLowerCase() + "@gmail.com";
            String phone = BaseTestMethods.generatePhone();
            //   Thread.sleep(6000);
            //System.out.println(prop.getProperty("firstName"));
            driver.findElement(By.xpath(fname.toString().replace("\"", ""))).sendKeys(BaseTestMethods.generateName());
            driver.findElement(By.xpath(lnn)).sendKeys(BaseTestMethods.generateName());

            driver.findElement(By.xpath(prop.getProperty("phone"))).sendKeys(phone);
            driver.findElement(By.id(prop.getProperty("Email"))).sendKeys(email);
            driver.findElement(By.xpath("//input[@name='city']")).sendKeys(prop.getProperty("place"));
            //  driver.findElement(By.xpath("//input[@name='state']")).sendKeys(prop.getProperty("Telengana"));
            driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Telengana");
            driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(BaseTestMethods.generateZipcode());
            // driver.findElement(By.xpath("//td[2]/select[@name='country']")).click();
            driver.findElement(By.xpath("//tr[12]/td[2]")).click();
            List<WebElement> options = driver.findElements(By.xpath("//tr[12]/td[2]"));
            List<String> text = new ArrayList<>();
            for (int i = 0; i < options.size(); i++) {
                options.get(i).getText();
                System.out.println(text.add(options.get(i).getText()));
                options.get(i).click();
            }
            driver.findElement(By.id("email")).sendKeys(BaseTestMethods.generateName());
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(BaseTestMethods.Password());
            driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(BaseTestMethods.Password());
            driver.findElement(By.xpath("//input[@name='register']")).click();
            String registration_msg = driver.findElement(By.xpath("//a//b")).getText();
            System.out.println(registration_msg);
            String words[] = registration_msg.split(" ");
            uname = words[5];
            System.out.println(uname);
            Assert.assertTrue(uname, true);


        } catch (Exception e) {
            e.getMessage();
        }
    }
    @Test
    public void login() throws FileNotFoundException,IOException
    {
        try
        {
        FileInputStream file = new FileInputStream(new File("D:\\NewTours\\NewTours.xlsX"));
        XSSFWorkbook workbook =new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int num = sheet.getLastRowNum();
        Iterator<org.apache.poi.ss.usermodel.Row> rowIterator=sheet.iterator();
        while (rowIterator.hasNext())
        {
            org.apache.poi.ss.usermodel.Row row=rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                // Check the cell type and format accordingly
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "t");
                        break;
                }
            }
            System.out.println("");
        }
        file.close();
    }
        catch (Exception e) {
        e.printStackTrace();
    }

        //Row r=sheet.createRow(num);

        driver.findElement(By.linkText("sign-in")).click();
        System.out.println(uname);
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(BaseTestMethods.Password());
        driver.findElement(By.xpath("//input[@name='login']")).click();
    }
}

