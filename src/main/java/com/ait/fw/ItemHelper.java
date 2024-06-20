/*
 * created by $
 */


package com.ait.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnShoppingCartLink() {
        click(By.xpath("//span[.='Shopping cart']"));
    }

    public void clickOnAddButton() {
        click(By.xpath("//div[@class='item-box'][2]//input[@value='Add to cart']"));
    }

    public String actualValue() {
        return driver.findElement(By.xpath("//a[@class='product-name' and contains(.,'14.1-inch Laptop')]")).getText();
    }

    public void clickOnUpdateButton() {
        click(By.xpath("//input[@name='updatecart']"));
    }

    public void clickOnRemove() {
        click(By.xpath("//input[@name='removefromcart']"));
    }
}
