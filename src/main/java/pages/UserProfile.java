package pages;

import lib.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserProfile {
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;
    private By profileDescriptionMessage = By.xpath(Constants.PROFILE_DESCRIPTION_TEXT);
    private By logOutButton = By.xpath(Constants.LOG_OUT_BUTTON);


    public UserProfile (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    public void clickLogOutButton() {basePage.click(logOutButton);}

    public void validateOpeningProfile() {
        String expectedInfoText = "В этом разделе вы можете изменить свои персональные данные";
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .textToBePresentInElementLocated(profileDescriptionMessage, expectedInfoText));
    }
}

