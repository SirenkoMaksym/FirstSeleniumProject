/*
 * created by max$
 */


package com.ait.tests;

import com.ait.models.UserRegistred;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePreciondition(){
        if(app.getUser().isAccountPresent()){
            app.getUser().clickOnOutButton();
        }
    }


    @Test(enabled = false)
    public void createAccountPositiveTests() {

        app.getUser().clickOnRegistratioLink();
        app.getUser().fillRegistredForm(new UserRegistred()
                .setFirstname("Merkel")
                .setLastName("Smit")
                .setEmail("merkel@gmail.com")
                .setPassword("Merkel")
                .setConfirmPasswor("Merkel"));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAccountPresent());
    }

}
