/*
 * created by max$
 */


package com.ait.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        //click on Log in link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.id("Email"), "merkel@gmail.com");
        //enter password
        type(By.id("Password"), "Merkel");
        //click on Login button
        click(By.xpath("//input[@class='button-1 login-button']"));
    }

    @Test
    public void AddItem() {
        //click on Add Button
        click(By.xpath("//div[@class='item-box'][2]//input[@value='Add to cart']"));
        //click on Shopping cart link
        click(By.xpath("//span[.='Shopping cart']"));
        //assert 'purchases' is present
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'14.1-inch Laptop')]")));
        pause(1000);
    }

    @AfterMethod
    public void postCondition() {
        //  int sizeBefore = sizeOfContacts();
        //click on Remove
        click(By.xpath("//input[@name='removefromcart']"));
        //click Update
        click(By.xpath("//input[@name='updatecart']"));
        //assert 'purchases' is exist
        // int sizeAfter = sizeOfContacts();
        //  Assert.assertEquals(sizeAfter,sizeBefore-1);

    }

   /* public int sizeOfContacts() {
        if (isElementPresent(By.xpath("//a[@class='product-name']"))) {
            return driver.findElements(By.xpath("//a[@class='product-name']")).size();
        }
        return 0;
    }
    */
}
