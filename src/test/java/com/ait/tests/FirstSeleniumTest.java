/*
 * created by Max$
 */


package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUP
    @BeforeMethod
    public void setUP() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");// открывает с инета ссылку без истории

        /*
        driver.navigate().to("https://www.google.com"); открывает с истории
        driver.navigate().back(); назад
        driver.navigate().forward(); вперед
        driver.navigate().refresh(); обновляет страницу
        */
    }


    //tests
    @Test
    public void openGoogle() {
        System.out.println("Google opened");
    }

    //after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();//для всего браузера и вкладок
        // driver.close();// только одну вкладку закрывает
    }
}
