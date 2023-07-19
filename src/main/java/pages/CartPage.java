package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends HomePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "add-to-cart-button-5")
    WebElement addToCartButton;
    @FindBy(id = "bar-notification")
    WebElement barNotification;
    //The product has been added to your
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartLink;
    @FindBy(css = "div.page-title")
    WebElement pageTitleContent;
    //Shopping cart
    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    WebElement addedProduct;
    @FindBy(css = "button.remove-btn")
    WebElement removeProductButton;
    @FindBy(css = "div.no-data")
    WebElement emptyCartContent;
    //Your Shopping Cart is empty!
    @FindBy(id = "updatecart")
    WebElement updateCartButton;
    @FindBy(css = "button.button-2.continue-shopping-button")
    WebElement continueShoppingButton;
    @FindBy(linkText = "Shopping cart")
    WebElement shoppingCartLabel;
    public void addProductsAndUpdateCart(){
        addToCartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(barNotification));
        Assert.assertTrue(barNotification.isDisplayed());
        Assert.assertEquals(barNotification.getText(), "The product has been added to your shopping cart");
        shoppingCartLink.click();
        Assert.assertEquals(pageTitleContent.getText(), "Shopping cart");
        Assert.assertEquals(addedProduct.getText(), "Asus N551JK-XO076H Laptop");
        Assert.assertTrue(updateCartButton.isDisplayed());
        continueShoppingButton.click();
        shoppingCartLabel.click();
        removeProductButton.click();
        Assert.assertEquals(emptyCartContent.getText(), "Your Shopping Cart is empty!");
    }


}
