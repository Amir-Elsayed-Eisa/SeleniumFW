package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.UserRegistrationPage;
import utilities.Data;
public class TC101_RegistrationAndLogin extends TestBase{


    Data fake;
    HomePage HomeObject;

    UserRegistrationPage URObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserRegistrationSuccessfully() {
        HomeObject = new HomePage(driver);

        HomeObject.OpenRegistrationPage();
        URObject = new UserRegistrationPage(driver);
        fake = new Data();
        URObject.UserRegistrationSteps(fake.fName, fake.lName, fake.D, fake.M, fake.Y, fake.email, fake.companyName, fake.password);

    }
    @Test(priority = 2)
            public void RegistrationFailedTC(){
        HomeObject.OpenRegistrationPage();
        URObject.userRegistrationFailed(fake.fName, fake.lName, fake.D, fake.M, fake.Y, fake.email, fake.companyName, fake.password);
    }
    LogInPage LogInObject;


    @Test(priority = 3)
    public void UserLoginSuccessfully(){
        LogInObject = new LogInPage(driver);
        LogInObject.UserLogIn(fake.email, fake.password);
    }



}
