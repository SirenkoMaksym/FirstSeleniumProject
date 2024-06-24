/*
 * created by max$
 */


package com.ait.tests;

import com.ait.data.AccountData;
import com.ait.models.UserRegistred;
import com.ait.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
                .setFirstname(AccountData.NAME)
                .setLastName(AccountData.LAST_NAME)
                .setEmail(AccountData.EMAIL)
                .setPassword(AccountData.PASSWORD)
                .setConfirmPasswor(AccountData.CONFITM_PASSWORD));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAccountPresent());
    }
    @Test(enabled = true)
    public void createAccountNegativeTests() {

        app.getUser().clickOnRegistratioLink();
        app.getUser().fillRegistredForm(new UserRegistred()
                .setFirstname(AccountData.NAME)
                .setLastName(AccountData.LAST_NAME)
                .setEmail(AccountData.EMAIL)
                .setPassword(AccountData.PASSWORD)
                .setConfirmPasswor(AccountData.CONFITM_PASSWORD));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAccountExist());
    }


    @Test(dataProvider = "AddNewAccount", dataProviderClass = DataProviders.class)
    public void addAccountPositiveTestFromDataProvider(String name, String lastName, String email,
                                                       String password, String confirmPassword) {

        app.getUser().clickOnRegistratioLink();
        app.getUser().fillRegistredForm(new UserRegistred()
                .setFirstname(name)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPasswor(confirmPassword));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAccountPresent());
    }


    @Test(dataProvider = "AddNewAccountFromCsv", dataProviderClass = DataProviders.class)
    public void addAccountPositiveTestFromDataProviderWithCsv(UserRegistred userRegistred) {

        app.getUser().clickOnRegistratioLink();
        app.getUser().fillRegistredForm(userRegistred);
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAccountPresent());
    }
}
