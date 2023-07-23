package tests;

import org.testng.annotations.Test;
import pages.UserAccount;
import utilities.Data;

public class TC102_UserAccountAndChangePassword extends TestBase{


    Data fake;
    UserAccount MyAccountOBJ;



    @Test()

    public void ChangeUSerPasswordSuccessfully(){
        MyAccountOBJ = new UserAccount(driver);
        fake = new Data();

        MyAccountOBJ.ChangeUSerPassword(fake.password, fake.newPassword);
    }




}
