package com.luxoft.selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

   protected WebDriver webDriver;

    @BeforeClass
    public void setUp(){

    }

    @BeforeMethod
    public void testSetUp(){
        System.out.println("Web driver will be opened");
        webDriver = new ChromeDriver();
        System.out.println("Web driver is opened");
        System.out.println("Page will be opened");
        webDriver.get("http://www.etsy.com");
        System.out.println("Page is opened");
    }


    @AfterMethod
    public void testCleanUp(){
        webDriver.quit();
    }

    @AfterClass
    public void cleanUp(){

    }
}
