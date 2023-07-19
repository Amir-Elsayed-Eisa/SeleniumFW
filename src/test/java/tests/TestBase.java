package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.Helper;

public class TestBase{
    Faker fake = new Faker();
    String fName = String.valueOf(fake.name());
    String lName = String.valueOf(fake.name());
    String D = "1";
    String M = "2";
    String Y = "2000";
    String email = String.valueOf(fake.internet().emailAddress());
    String companyName = "I'm a student";
    String password = "111111";
    String newPassword = "222222";
    public static WebDriver driver;

    @BeforeSuite
    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @AfterSuite
    public void QuitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed");
            System.out.println("Taking a screenshot");
            Helper.captureScreenshot(driver, result.getName());
        }else {
            System.out.println("Test is good you are safe");
        }
    }

}
