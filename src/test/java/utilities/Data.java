package utilities;

import com.github.javafaker.Faker;


public class Data {

    Faker fake = new Faker();
    public String fName = String.valueOf(fake.name());
    public String lName = String.valueOf(fake.name());
    public String D = "1";
    public String M = "2";
    public String Y = "2000";
    public String email = String.valueOf(fake.internet().emailAddress());
    public String companyName = "I'm a student";
    public String password = "111111";
    //Excel File Reader
    public String newPassword = "222222";

}
