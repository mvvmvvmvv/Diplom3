package pages;

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

    public void clickLoginButton() {
        basePage.click(loginButtonOnHomePage);
    }

    public void clickBuns() {
        basePage.click(constructorBuns);
    }

    public void clickSauce() {
        basePage.click(constructorSauce);
    }

    public void clickFilling() {
        basePage.click(constructorFilling);
    }

    public void validateBunsSelection() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .presenceOfElementLocated(enabledBunsTab));
    }

    public void validateSauceSelection() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .presenceOfElementLocated(enabledSauceTab));
    }

    public void validateFillingSelection() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .presenceOfElementLocated(enabledFillingTab));
    }

    public void validateOpeningHomePage() {
        String expectedText = "Оформить заказ";
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .textToBePresentInElementLocated(makeOrderButton, expectedText));
    }
}

