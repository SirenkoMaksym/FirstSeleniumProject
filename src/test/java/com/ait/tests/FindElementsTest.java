/*
 * created by max$
 */


package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://ilcarro.web.app");
        //maximize browser to window size
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//ждем загрузку страницу
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementsByLocator() {
        WebElement city = driver.findElement(By.id("city"));
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());


        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //tag
        driver.findElement(By.cssSelector("h1"));
        //id
        driver.findElement(By.cssSelector("#city"));
        //class
        driver.findElement(By.cssSelector(".telephone"));
        //cssSelector
        WebElement cssSelector = driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        System.out.println(cssSelector.getAttribute("type"));

        //contains ->*

        WebElement elementContain = driver.findElement(By.cssSelector("[ng-reflect-router-link*='car']"));
        System.out.println(elementContain.getText());
        //start -> ^
        driver.findElement(By.cssSelector("[ng-reflect-router-link^='let']"));
        //ent on ->$
        driver.findElement(By.cssSelector("[ng-reflect-router-link$='work']"));

    }
    @Test
    public void findElementByXpath(){
        // //*[@attr='value']
        driver.findElement(By.xpath("//h1"));

        //id
        driver.findElement(By.xpath("//input[@id='city']"));
        //class
        driver.findElement(By.xpath("//*[@class='telephone']"));
        //text()
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));
        //contains -> //tag[contains(.,"text")]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla!')]"));
        //contains class+
        driver.findElement(By.xpath("//input[contains(@class,'target')]"));
        //start -> //tag[starts-with(@attr.'startOfValue')]//input[starts-with(@class,'ng-pristine')]
        driver.findElement(By.xpath("//input[starts-with(@class,'ng-untouched')]"));
    }
}
