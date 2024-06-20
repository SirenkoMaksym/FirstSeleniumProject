/*
 * created by max$
 */


package com.ait.tests;

import com.ait.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().pause(1000);
        if (!app.getUser().isAccountPresent()) {
            app.getUser().clickOnLoginLink();
            app.getUser().fillLoginForm(new User()
                    .setEmail("merkel@gmail.com")
                    .setPassword("Merkel"));
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void AddItem() {
        app.getItem().clickOnAddButton();
        app.getItem().clickOnShoppingCartLink();
        //assert 'purchases' is present
        Assert.assertEquals(app.getItem().actualValue(),
                "14.1-inch Laptop");
        app.getItem().pause(1000);
    }

    @AfterMethod
    public void postCondition() {
        app.getItem().clickOnRemove();
        app.getItem().clickOnUpdateButton();
    }

}
