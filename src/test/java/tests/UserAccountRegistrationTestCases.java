package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.UserRegistrationPage;

public class UserAccountRegistrationTestCases extends TestBase{



    HomePage HomeObject;

    UserRegistrationPage URObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserRegistrationSuccessfully() {
        HomeObject = new HomePage(driver);

        HomeObject.OpenRegistrationPage();
        URObject = new UserRegistrationPage(driver);
        URObject.UserRegistrationSteps(fName, lName, D, M, Y, email, companyName, password);

    }
    @Test(priority = 2)
            public void RegistrationFailedTC(){
        HomeObject.OpenRegistrationPage();
        URObject.userRegistrationFailed(fName, lName, D, M, Y, email, companyName, password);
    }
    LogInPage LogInObject;


    @Test(priority = 3)
    public void UserLoginSuccessfully(){
        LogInObject = new LogInPage(driver);
        LogInObject.UserLogIn(email, password);
    }


}
