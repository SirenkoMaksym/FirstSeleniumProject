/*
 * created by max$
 */


package com.ait.tests;

import com.ait.data.UserData;
import com.ait.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePreciondition(){
        if(app.getUser().isAccountPresent()){
            app.getUser().click(By.xpath("//a[.='Log out']"));
        }
    }
    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAccountPresent());
    }

    @Test
    public void loginNegativeTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(!app.getUser().isAccountPresent());
    }


}
