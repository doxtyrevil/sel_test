package com.luxoft.selenium.introduction.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class PageObjectTestBase {

    protected WebDriver webDriver;

    @BeforeClass
    public void setUpForAll(){

    }

    @BeforeMethod
    public void setUp(){
        webDriver = DriverManager.getChromeDriver(false);

    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
