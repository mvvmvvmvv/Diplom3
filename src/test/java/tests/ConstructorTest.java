package tests;

import io.qameta.allure.junit4.DisplayName;
import lib.Constants;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class ConstructorTest {
    private WebDriver driver;

    @Test
    @DisplayName("Check that buns tab enabled (by default)")
    public void testCheckBunsTabEnabled() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(Constants.HOME_PAGE);
        driver.manage().window().maximize();

        objHomePage.validateBunsSelection();
    }

    @Test
    @DisplayName("Check that sauce tab enabled")
    public void testCheckSauceTabEnabled() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(Constants.HOME_PAGE);
        driver.manage().window().maximize();

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

        objHomePage.clickFilling();
        objHomePage.validateFillingSelection();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
