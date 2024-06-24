/*
 * created by max$
 */


package com.ait.tests;

import com.ait.fw.ApplicatioManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicatioManager app = new ApplicatioManager(System.getProperty("browser", Browser.CHROME.browserName()));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method, Object[] par){
        logger.info("Start test!  " + method.getName()+ "with data: " + Arrays.asList(par));
    }
    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void stoptest(ITestResult result){
        if(result.isSuccess()){
            logger.info(("PASSES: "+ result.getMethod().getMethodName()));
        } else {
            logger.error("FAILED: "+ result.getMethod().getMethodName()+"Screenshot: "+ app.getUser().takeScreenshot());
        }
        logger.info("Stop test!");
        logger.info("****************************************");
    }
    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
