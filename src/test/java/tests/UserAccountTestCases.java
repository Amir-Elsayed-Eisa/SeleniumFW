package tests;

import org.testng.annotations.Test;
import pages.UserAccount;

public class UserAccountTestCases extends TestBase{



    UserAccount MyAccountOBJ;

    @Test

    public void ChangeUSerPasswordSuccessfully(){
        MyAccountOBJ = new UserAccount(driver);
        MyAccountOBJ.ChangeUSerPassword(password, newPassword);
    }



}
