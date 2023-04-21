package pages;

import io.qameta.allure.Step;
import lib.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Header {
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    private By profileButtonInHeader = By.xpath(Constants.PROFILE_BUTTON);
    private By logoButtonInHeader = By.xpath(Constants.LOGO_LINK);
    private By constructorButtonInHeader = By.xpath(Constants.CONSTRUCTOR);

    public Header (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    @Step("Open user profile")
    public void openProfile() {
        basePage.click(profileButtonInHeader);
    }

    @Step("Click logo in the header")
    public void clickLogo() {
        basePage.click(logoButtonInHeader);
    }

    @Step("Open constructor from the header")
    public void clickConstructor() {
        basePage.click(constructorButtonInHeader);
    }
}

