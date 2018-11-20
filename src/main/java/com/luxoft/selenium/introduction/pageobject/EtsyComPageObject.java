package com.luxoft.selenium.introduction.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EtsyComPageObject extends BasePageObject{

    public static final String ACCEPT_GDPR_BUTTON = "//button[@class='width-full btn btn-outline btn-outline-black']";
    public static final String SEARCH_INPUT_FIELD = "//input[@id='search-query']";
    public static final String SHIP_TO_SELECT = "ship_to_select";

    public EtsyComPageObject(WebDriver webDriver){
        super(webDriver);
    }

    public EtsyComPageObject goToMainPage(){
        webDriver.get("http://www.etsy.com");
        return this;
    }

    public EtsyComPageObject acceptGDPRPolicy(){
        By gdprPopUpButtonBy = new By.ByXPath(ACCEPT_GDPR_BUTTON);
        WebElement gdprPoUpButton = webDriver.findElement(gdprPopUpButtonBy);
        try {
            captureElementScreenshot(gdprPoUpButton);
        } catch (IOException e) {
            e.printStackTrace();
        }
        gdprPoUpButton.click();

        Assert.assertTrue(new WebDriverWait(webDriver, 10).until(ExpectedConditions.invisibilityOfElementLocated(gdprPopUpButtonBy)));
        return this;
    }

    public EtsyComPageObject searchFor(String criteria) {

        By searchBarBy = new By.ByXPath(SEARCH_INPUT_FIELD);
        WebElement searchBar = webDriver.findElement(searchBarBy);
        searchBar.clear();
        searchBar.sendKeys(criteria);
        searchBar.sendKeys(Keys.RETURN);
        return this;
    }

    public EtsyComPageObject selectShippingOption(String shippingOption) {

        findElementWithWait(By.linkText(shippingOption)).click();
        captureScreenShot();
        return this;
    }


    public EtsyComPageObject selectShippingDestination(String shippingDestination) {
        new Select(findElementWithWait(By.id(SHIP_TO_SELECT))).selectByVisibleText(shippingDestination);
        captureScreenShot();
        return this;
    }

    public List<String> getSearchResultAppliedFilters() {
        captureScreenShot();
        return findEllementsWithWait(By.className("tag")).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
