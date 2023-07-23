package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LogInPage extends PageBase {
    public LogInPage(WebDriver driver) {
        super((WebDriver) driver);
    }

    @FindBy(linkText = "Log in")
    WebElement LogInLink;
    @FindBy(id = "Email")
    WebElement EmailField;
    @FindBy(id = "Password")
    WebElement PasswordField;
    @FindBy(id = "RememberMe")
    WebElement RememberMeButton;
    @FindBy(css = "button.button-1.login-button")
    WebElement LogInButton;


    @FindBy(css = "div [class = 'topic-block-title']")
    WebElement WelcomeMessage;
    @FindBy(linkText = "Log out")
    WebElement LogOutLink;





    public void UserLogIn(String UserEmail, String UserPassword){
        LogInLink.click();
        EmailField.sendKeys(UserEmail);
        PasswordField.sendKeys(UserPassword);
        Assert.assertTrue(RememberMeButton.isDisplayed());
        LogInButton.click();

        Assert.assertTrue(WelcomeMessage.isDisplayed());
        Assert.assertTrue(WelcomeMessage.getText().contains("Welcome to our store"));


    }
    public void userLogOut(){
        LogOutLink.click();
    }

}
