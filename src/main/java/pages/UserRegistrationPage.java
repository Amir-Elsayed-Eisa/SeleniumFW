package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UserRegistrationPage extends PageBase {


    public UserRegistrationPage(WebDriver driver) {
        super((WebDriver) driver);

    }

    @FindBy(id = "gender-male")
    WebElement Gender;

    @FindBy(id = "FirstName")
    WebElement FirstName;

    @FindBy(id = "LastName")
    WebElement LastName;

    @FindBy(name = "DateOfBirthDay")
    WebElement DOBDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement DOBMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement DOBYear;
    @FindBy(id = "Email")
    WebElement Email;

    @FindBy(id = "Newsletter")
    WebElement NewsButton;

    @FindBy(id = "Password")
    WebElement Password;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPassword;

    @FindBy(id = "Company")
    WebElement Company;

    @FindBy(id = "register-button")
    WebElement RegisterButton;

    @FindBy(css = "div [class='result']")
    WebElement SuccessfullyRegistered;
    @FindBy(css = "div [class='buttons']")
    WebElement ContinueToLogin;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li")
    WebElement errorMessage;
    public void UserRegistrationSteps(String FUserName,String LUserNAme,String D, String M, String Y, String USerEmail,String CompanyName, String UserPassword)  {

        Gender.click();
        FirstName.sendKeys(FUserName);
        LastName.sendKeys(LUserNAme);

        Select Day = new Select(DOBDay);
        Day.selectByValue(D);
        Select Month = new Select(DOBMonth);
        Month.selectByValue(M);
        Select Year = new Select(DOBYear);
        Year.selectByValue(Y);

        Email.sendKeys(USerEmail);
        Company.sendKeys(CompanyName);

        if (NewsButton.isSelected()) {
            NewsButton.click();
        }
        else {
            System.out.println("You will not receive the news automatically");
        }

        Password.sendKeys(UserPassword);
        ConfirmPassword.sendKeys(UserPassword);
        RegisterButton.click();
        Assert.assertTrue(SuccessfullyRegistered.getText().contains("Your registration completed"));
        ContinueToLogin.click();





    }
    public void userRegistrationFailed(String FUserName, String LUserNAme, String D, String M, String Y, String UserEmail, String CompanyName, String UserPassword ){
        Gender.click();
        FirstName.sendKeys(FUserName);
        LastName.sendKeys(LUserNAme);

        Select Day = new Select(DOBDay);
        Day.selectByValue(D);
        Select Month = new Select(DOBMonth);
        Month.selectByValue(M);
        Select Year = new Select(DOBYear);
        Year.selectByValue(Y);

        Email.sendKeys(UserEmail);
        Company.sendKeys(CompanyName);

        if (NewsButton.isSelected()) {
            NewsButton.click();
        }
        else {
            System.out.println("You will not receive the news automatically");
        }

        Password.sendKeys(UserPassword);
        ConfirmPassword.sendKeys(UserPassword);
        RegisterButton.click();
        Assert.assertEquals(errorMessage.getText(), "The specified email already exists");
    }

}
