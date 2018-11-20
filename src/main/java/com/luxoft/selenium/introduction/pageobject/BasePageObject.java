package com.luxoft.selenium.introduction.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasePageObject {

    protected WebDriver webDriver;

    private final int MAX_WAIT_TIME = 30;

    public BasePageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement findElementWithWait(By locator){
        return new WebDriverWait(webDriver, MAX_WAIT_TIME)
                .until(
                        webDriver1 -> webDriver1.findElement(locator)
                );
    }

    public List<WebElement> findEllementsWithWait(By locator){
        return new WebDriverWait(webDriver, MAX_WAIT_TIME)
                .until(
                        webDriver1 -> webDriver1.findElements(locator)
                );
    }

    protected void captureScreenShot(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.SSS");
        String time = LocalDateTime.now().format(dtf);
        File screenshot1 = new File ("target/screenshot"+time+".png");
        File outfile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(outfile.toPath(), screenshot1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void captureElementScreenshot(WebElement webElement) throws IOException {
        File screenshot = ((TakesScreenshot)webDriver)
                .getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point elementLocation = webElement.getLocation();
        int webElHeight = webElement.getSize().getHeight();
        int webElWidth = webElement.getSize().getWidth();
        BufferedImage elementScreenShotImage = fullImg.getSubimage(
                elementLocation.getX(), elementLocation.getY(),
                webElWidth, webElHeight
        );
        ImageIO.write(elementScreenShotImage, "png",screenshot);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.SSS");
        String time = LocalDateTime.now().format(dtf);
        File elementScreenshot = new File("target/screenshot"+
                time +".png");
        Files.copy(screenshot.toPath(), elementScreenshot.toPath());
    }
}
