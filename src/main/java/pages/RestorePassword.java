package pages;

import lib.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RestorePassword {
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;
    private By loginLink = By.xpath(Constants.LOGIN_PAGE_LINK);

    public RestorePassword (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    public void clickLoginLink() {
        basePage.click(loginLink);
    }
}

