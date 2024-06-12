

package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkTestSelectorCss {
    WebDriver driver;

    //before - setUP
    @BeforeMethod
    public void setUP() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    //tests
    @Test
    public void openGoogle() {
        System.out.println("Shop opened");
    }


    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();//для всего браузера и вкладок
        // driver.close();// только одну вкладку закрывает
    }

    @Test
    public void findElementByCssSelector() {
        //class
        driver.findElement(By.cssSelector(".leftside-3"));
        //tag+class
        driver.findElement(By.cssSelector("h2.product-title"));
        //tag+class
        driver.findElement(By.cssSelector("ul.mob-top-menu"));
        //id
        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        //class+class
        driver.findElement(By.cssSelector(".column.information"));
        //cssSelector
        driver.findElement(By.cssSelector("[title='Close']"));
        //cssSelector
        driver.findElement(By.cssSelector("[type='text/javascript']"));
        //cssSelector
        driver.findElement(By.cssSelector("[action='/search']"));
        //cssSelector
        driver.findElement(By.cssSelector("[aria-live='polite']"));
        //cssSelector
        driver.findElement(By.cssSelector("[rel='shortcut icon']"));



    }
    @Test
    public void findElementByXpath() {
        //class
        driver.findElement(By.xpath("//*[@class='leftside-3']"));
        //tag+class
        driver.findElement(By.xpath("//h2[@class='product-title']"));
        //tag+class
        driver.findElement(By.xpath("//ul[@class='mob-top-menu']"));
        //id
        driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        //class+class
        driver.findElement(By.xpath("//*[contains(@class, 'column') and contains(@class, 'information')]"));
        //xpath
        driver.findElement(By.xpath("//*[@title='Close']"));
        //xpath
        driver.findElement(By.xpath("//*[@type='text/javascript']"));
        //xpath
        driver.findElement(By.xpath("//*[@action='/search']"));
        //xpath
        driver.findElement(By.xpath("//*[@aria-live='polite']"));
        //xpath
        driver.findElement(By.xpath("//*[@rel='shortcut icon']"));

    }

}
