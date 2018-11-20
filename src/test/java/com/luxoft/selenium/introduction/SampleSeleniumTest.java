package com.luxoft.selenium.introduction;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SampleSeleniumTest extends TestBase{


    @Test
    public void justForCheck(){
        Assert.assertTrue(true);
        Assert.assertEquals(1,1);
    }

    @Test
    public void etsyComMainPageTitleTest(){
        Assert.assertTrue(webDriver.getTitle().contains("Etsy"));
    }


    @Test
    public void gdprCanBeAccepted(){
        By gdprPopUpButtonBy = new By.ByXPath("//button[@class='width-full btn btn-outline btn-outline-black']");
        WebElement gdprPoUpButton = webDriver.findElement(gdprPopUpButtonBy);
        gdprPoUpButton.click();

        Assert.assertTrue(new WebDriverWait(webDriver, 10).until(ExpectedConditions.invisibilityOfElementLocated(gdprPopUpButtonBy)));

    }

    @Test
    public void pageTabContainsSearchString(){

       gdprCanBeAccepted();
       By searchBarBy = new By.ByXPath("//input[@id='search-query']");
       WebElement searchBar = webDriver.findElement(searchBarBy);
       searchBar.clear();
       searchBar.sendKeys("Leather");
       searchBar.sendKeys(Keys.RETURN);
       Assert.assertTrue(new WebDriverWait(webDriver, 10).until(ExpectedConditions.titleContains("Leather")));
    }


}
