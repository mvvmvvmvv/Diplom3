package tests;

import api.ApiCoreRequests;
import api.DataGenerator;
import api.ApiEndPoints;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import lib.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;
import java.util.Map;

public class LoginTest {

    private WebDriver driver;
    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();
    String email;
    String password;
    String accessToken;

    @Before
    public void createUser() {
        Map<String,String> userData = DataGenerator.getRegistrationData();
        Response createUser = apiCoreRequests.makePostRequest(
                ApiEndPoints.REGISTER,
                userData
        );
        this.accessToken = createUser.path("accessToken");
        this.email = userData.get("email");
        this.password = userData.get("password");
    }

    @Test
    @DisplayName("Open login form from home page")
    public void testLoginFromHomePage() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);

        driver.get(Constants.HOME_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objHomePage.clickLoginButton();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.inputEmail(this.email);
        objLoginPage.inputPassword(this.password);
        objLoginPage.clickEnter();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        objHomePage.validateOpeningHomePage();
    }

    @Test
    @DisplayName("Open login form via profile button")
    public void testLoginFromProfile() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        Header objHeader = new Header(driver);

        driver.get(Constants.HOME_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objHeader.openProfile();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.inputEmail(this.email);
        objLoginPage.inputPassword(this.password);
        objLoginPage.clickEnter();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        objHomePage.validateOpeningHomePage();
    }

    @Test
    @DisplayName("Open login form from registration page")
    public void testLoginFromRegistrationForm() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        driver.get(Constants.REGISTER_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objRegisterPage.clickLoginLink();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.inputEmail(this.email);
        objLoginPage.inputPassword(this.password);
        objLoginPage.clickEnter();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        objHomePage.validateOpeningHomePage();
    }

    @Test
    @DisplayName("Open login form from password restoration page")
    public void testLoginFromRestorePassword() {
        driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RestorePassword objRestorePassword = new RestorePassword(driver);

        driver.get(Constants.RESTORE_PASSWORD_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objRestorePassword.clickLoginLink();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.inputEmail(this.email);
        objLoginPage.inputPassword(this.password);
        objLoginPage.clickEnter();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        objHomePage.validateOpeningHomePage();
    }

    @After
    public void teardown() {
        driver.quit();
        apiCoreRequests.makeDeleteRequest(
                ApiEndPoints.USER,
                this.accessToken
        );
    }
}

