package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    protected WebDriver driver;
    public JavascriptExecutor SD;
    public Actions actions;
    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void PageExplore() {
        JavascriptExecutor SD = (JavascriptExecutor) driver;
        SD.executeScript("scrollBy(0,1500)");
        SD.executeScript("scrollBy(1500, 0)");
    }
}
