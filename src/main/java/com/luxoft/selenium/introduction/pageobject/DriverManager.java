package com.luxoft.selenium.introduction.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static WebDriver getChromeDriver (boolean isHeadLess){
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(isHeadLess);
        return new ChromeDriver(opts);
    }
}
