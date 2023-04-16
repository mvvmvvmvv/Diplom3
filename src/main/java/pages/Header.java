package pages;

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

    public void openProfile() {
        basePage.click(profileButtonInHeader);
    }

    public void clickLogo() {
        basePage.click(logoButtonInHeader);
    }

    public void clickConstructor() {
        basePage.click(constructorButtonInHeader);
    }
}

