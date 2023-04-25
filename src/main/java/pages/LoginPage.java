package pages;

import io.qameta.allure.Step;
import lib.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    private By emailField = By.xpath(Constants.INPUT_EMAIL_ON_LOGIN);
    private By passwordField = By.xpath(Constants.INPUT_PASSWORD);
    private By enterButton = By.xpath(Constants.LOG_IN);
    private By registerLink = By.xpath(Constants.REGISTER_LINK);
    private By restorePasswordLink = By.xpath(Constants.RESTORE_PASSWORD_LINK);
    private By enterHeader = By.xpath(Constants.ENTER_HEADER);

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    @Step("Enter user email")
    public void inputEmail(String email) {
        basePage.writeText(emailField, email);
    }

    @Step("Enter user password")
    public void inputPassword(String password) {
        basePage.writeText(passwordField, password);
    }

    @Step("Click enter")
    public void clickEnter() {
        basePage.click(enterButton);
    }

    @Step("Open registration page")
    public void openRegisterPage() {
        basePage.click(registerLink);
    }

    @Step("Open password reset form")
    public void clickRestorePasswordLink() {
        basePage.click(restorePasswordLink);
    }

    @Step("Validate opening login page")
    public void validateOpeningLoginPage() {
        String expectedText = "Вход";
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .textToBePresentInElementLocated(enterHeader, expectedText));
    }
}

