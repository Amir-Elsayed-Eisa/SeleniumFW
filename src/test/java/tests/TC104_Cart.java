package tests;

import org.testng.annotations.Test;
import pages.CartPage;

public class TC104_Cart extends TestBase{
    CartPage CPOBJ;
    @Test
    public void shoppingCartTC(){
        CPOBJ = new CartPage(driver);
        CPOBJ.addProductsAndUpdateCart();
    }
}
