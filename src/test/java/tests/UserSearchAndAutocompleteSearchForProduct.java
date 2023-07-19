package tests;


import org.testng.annotations.Test;
import pages.UserSearchForProducts;

public class UserSearchAndAutocompleteSearchForProduct extends TestBase{

    UserSearchForProducts SearchObJ;

    @Test
    public void UserProductSearch()  {

        SearchObJ = new UserSearchForProducts(driver);
        SearchObJ.UserSearch("Apple MacBook Pro 13-inch");
        SearchObJ.AutoCompleteForUserSearch("asus");



    }
}
