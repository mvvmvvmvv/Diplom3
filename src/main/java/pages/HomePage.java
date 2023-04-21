package pages;

import io.qameta.allure.Step;
import lib.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    private By loginButtonOnHomePage = By.xpath(Constants.LOGIN_BUTTON);
    private By constructorBuns = By.xpath(Constants.BUNS);
    private By enabledBunsTab = By.xpath(Constants.BUNS_ENABLED);
    private By constructorSauce = By.xpath(Constants.SAUCE);
    private By enabledSauceTab = By.xpath(Constants.SAUCE_ENABLED);
    private By constructorFilling = By.xpath(Constants.FILLING);
    private By enabledFillingTab = By.xpath(Constants.FILLING_ENABLED);
    private By constructorHeader = By.xpath(Constants.CONSTRUCTOR_HEADER);
    private By makeOrderButton = By.xpath(Constants.MAKE_ORDER_BUTTON);

    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    @Step("Click Log in button")
    public void clickLoginButton() {
        basePage.click(loginButtonOnHomePage);
    }

    @Step("Enable Buns tab")
    public void clickBuns() {
        basePage.click(constructorBuns);
    }

    @Step("Enable Sauces tab")
    public void clickSauce() {
        basePage.click(constructorSauce);
    }

    @Step("Enable Fillings tab")
    public void clickFilling() {
        basePage.click(constructorFilling);
    }

    @Step("Validate Buns tab active")
    public void validateBunsSelection() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .presenceOfElementLocated(enabledBunsTab));
    }

    @Step("Validate Sauces tab active")
    public void validateSauceSelection() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .presenceOfElementLocated(enabledSauceTab));
    }

    @Step("Validate Fillings tab active")
    public void validateFillingSelection() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .presenceOfElementLocated(enabledFillingTab));
    }

    @Step("Validate opening home page")
    public void validateOpeningHomePage() {
        String expectedText = "Оформить заказ";
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .textToBePresentInElementLocated(makeOrderButton, expectedText));
    }
}

