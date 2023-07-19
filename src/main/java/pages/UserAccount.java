package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UserAccount extends PageBase{

    public UserAccount(WebDriver driver) {
        super(driver);
    }
   @FindBy(linkText = "My account")
    WebElement MyAccount;
    @FindBy(linkText = "Change password")
    WebElement ChangePasswordLink;
    @FindBy(id = "OldPassword")
    WebElement OldPassword;
    @FindBy(id = "NewPassword")
    WebElement NewPassword;
    @FindBy(id = "ConfirmNewPassword")
    WebElement ConfirmNPassword;
    @FindBy(css = "button.button-1.change-password-button")
    WebElement ChangePasswordButton;
    @FindBy(id = "bar-notification")
    WebElement Notification;
    //Password was changed
    @FindBy(css = "span.close")
    WebElement NotificationCloseButton;
    @FindBy(linkText = "Log out")
    WebElement LogOutLink;

    public void ChangeUSerPassword(String OldPass,String NewPass){
        MyAccount.click();
        ChangePasswordLink.click();
        OldPassword.sendKeys(OldPass);
        NewPassword.sendKeys(NewPass);
        ConfirmNPassword.sendKeys(NewPass);
        ChangePasswordButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(Notification)).isDisplayed();
        Assert.assertEquals(Notification.getText(), "Password was changed");
        NotificationCloseButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(LogOutLink)).click();



    }
}
