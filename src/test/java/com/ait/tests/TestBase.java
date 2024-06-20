/*
 * created by max$
 */


package com.ait.tests;

import com.ait.fw.ApplicatioManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicatioManager app = new ApplicatioManager(System.getProperty("browser", Browser.CHROME.browserName()));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method){
        logger.info("Start test!  " + method.getName());
    }
    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterMethod(enabled = true)
    public void stoptest(){
        logger.info("Stop test!");
    }
    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
