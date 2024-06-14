/*
 * created by max$
 */


package com.ait.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        //click on Log in link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.id("Email"), "merkel@gmail.com");
        //enter password
        type(By.id("Password"), "Merkel");
        //click on Login button
        click(By.xpath("//input[@class='button-1 login-button']"));
        //assert Sign out button is present
        //driver.findElement(By.xpath("//button[.='Sign Out']"));
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='header-links']//a[@class='account']")));
    }
}
