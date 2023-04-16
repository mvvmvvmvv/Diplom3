package tests;

import io.qameta.allure.junit4.DisplayName;
import lib.Constants;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class ConstructorTest {
    private WebDriver driver;

    @Test
    @DisplayName("Check that buns tab enabled (by default)")
    public void testCheckBunsTabEnabled() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(Constants.HOME_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objHomePage.validateBunsSelection();
    }

    @Test
    @DisplayName("Check that sauce tab enabled")
    public void testCheckSauceTabEnabled() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(Constants.HOME_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objHomePage.clickSauce();
        objHomePage.validateSauceSelection();
    }

    @Test
    @DisplayName("Check that fillings tab enabled")
    public void testCheckFillingTabEnabled() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(Constants.HOME_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objHomePage.clickFilling();
        objHomePage.validateFillingSelection();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
