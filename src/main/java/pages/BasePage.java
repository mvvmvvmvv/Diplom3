package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;

    //*****Конструктор*****
    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    //Кликнуть
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Написать текст
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
}


