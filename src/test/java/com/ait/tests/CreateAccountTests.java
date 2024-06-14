/*
 * created by max$
 */


package com.ait.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @Test(enabled = false)
    public void createAccountPositiveTests() {
        //click on Login link
        click(By.cssSelector("[href='/register']"));
        //enter First name:
        type(By.id("FirstName"), "Merkel");
        //enter Last name:
        type(By.id("LastName"), "Smit");
        //enter Email::
        type(By.id("Email"), "merkel@gmail.com");
        //enter Password::
        type(By.id("Password"), "Merkel");
        //enter Confirm password::
        type(By.id("ConfirmPassword"), "Merkel");
        //click on Registration button
        click(By.id("register-button"));
        //assert Sign out button is present
        //driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='header-links']//a[@class='account']")));
    }
}
