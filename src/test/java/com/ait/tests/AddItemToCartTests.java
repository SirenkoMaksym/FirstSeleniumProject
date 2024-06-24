
package com.ait.tests;

import com.ait.data.ItemData;
import com.ait.data.UserData;
import com.ait.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Objects;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().pause(1000);
        if (!app.getUser().isAccountPresent()) {
            app.getUser().clickOnLoginLink();
            app.getUser().fillLoginForm(new User()
                    .setEmail(UserData.EMAIL)
                    .setPassword(UserData.PASSWORD));
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void AddItem() {
        app.getItem().pause(1000);
        app.getItem().clickOnAddButton();
        app.getItem().clickOnShoppingCartLink();

        Assert.assertEquals(app.getItem().actualValue(),
                ItemData.NAME_ITEM);
        app.getItem().pause(1000);
    }

    @AfterMethod
    public void postCondition() {
        app.getItem().clickOnRemove();
        app.getItem().clickOnUpdateButton();
    }


}
