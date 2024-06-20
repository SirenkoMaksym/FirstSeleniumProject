/*
 * created by $
 */


package com.ait.fw;

import com.ait.models.User;
import com.ait.models.UserRegistred;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountPresent() {
        return isElementPresent(By.xpath("//div[@class='header-links']//a[@class='account']"));
    }
    public boolean isAccountExist() {
        return isElementPresent(By.xpath("//li[.='The specified email already exists']"));
    }


    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public void fillRegistredForm(UserRegistred userRegistred) {
        type(By.id("FirstName"), userRegistred.getFirstname());
        //enter Last name:
        type(By.id("LastName"), userRegistred.getLastName());
        //enter Email::
        fillLoginForm(new User()
                .setEmail(userRegistred.getEmail())
                .setPassword(userRegistred.getPassword()));
        //enter Confirm password::
        type(By.id("ConfirmPassword"), userRegistred.getConfirmPasswor());
        //click on Registration button
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@class='button-1 login-button']"));
    }

    public void clickOnRegistratioLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }
    public void clickOnOutButton(){
        click(By.xpath("//a[.='Log out']"));
    }
}


