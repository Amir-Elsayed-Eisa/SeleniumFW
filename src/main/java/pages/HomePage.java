package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver)
    {
        super((WebDriver) driver);

        Actions action = new Actions(driver);
    }



    @FindBy(linkText = "Register")
    WebElement RegisterPage;
    @FindBy(linkText = "Computers")
    WebElement compMenu;
    @FindBy(linkText = "Electronics ")
    WebElement electMenu;
    @FindBy(linkText = "Apparel")
    WebElement appMenu;
    @FindBy(linkText = "Digital downloads")
    WebElement digMenu;
    @FindBy(linkText = "Books")
    WebElement booksMenu;
    @FindBy(linkText = "Jewelry")
    WebElement jewelryMenu;
    @FindBy(linkText = "Gift Cards")
    WebElement GCMenu;



    public void OpenRegistrationPage()
    {
        RegisterPage.click();
    }


}
