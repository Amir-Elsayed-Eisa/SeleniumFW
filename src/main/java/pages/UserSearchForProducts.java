package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class UserSearchForProducts extends PageBase{

    public UserSearchForProducts(WebDriver driver) {
        super((WebDriver) driver);
    }
    PageBase PageOBJ;


    @FindBy(id = "small-searchterms")
    WebElement SearchBar;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement SearchButton;
    @FindBy(css = "div.product-name")
    WebElement SearchedProductName;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement SearchedProductResult;
    @FindBy(id = "ui-id-1")
    List<WebElement> ListOfProducts;

    public void UserSearch(String SearchKeyWordsP1) {
        PageOBJ = new PageBase((WebDriver) driver);

        SearchBar.sendKeys(SearchKeyWordsP1);
        SearchButton.click();
        PageOBJ.PageExplore();
        SearchedProductResult.click();
        Assert.assertEquals(SearchedProductName.getText(), "Apple MacBook Pro 13-inch");
        }
    public void AutoCompleteForUserSearch(String SearchKeyWordsP2) {
        SearchBar.sendKeys(SearchKeyWordsP2);
        WebElement ListOfAutoSuggest = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(ListOfProducts.get(0)));
        ListOfProducts.get(0).click();



        Assert.assertTrue(SearchedProductName.getText().equals("Asus N551JK-XO076H Laptop"));
    }

}
