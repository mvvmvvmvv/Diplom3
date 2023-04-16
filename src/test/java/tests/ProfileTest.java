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

public class ProfileTest {
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
    @DisplayName("Open user profile and then access home page via Constructor button")
    public void testOpenUserProfileAndNavigateToConstructor() {
        driver = new ChromeDriver();
        LoginPage objLoginPage = new LoginPage(driver);
        Header objHeader = new Header(driver);
        UserProfile objUserProfile = new UserProfile(driver);
        HomePage objHomePage = new HomePage(driver);

        driver.get(Constants.LOGIN_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.inputEmail(this.email);
        objLoginPage.inputPassword(this.password);
        objLoginPage.clickEnter();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objHeader.openProfile();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        objUserProfile.validateOpeningProfile();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objHeader.clickConstructor();
        objHomePage.validateOpeningHomePage();
    }

    @Test
    @DisplayName("Open user profile and then access home page via Logo")
    public void testOpenUserProfileAndClickLogo() {
        driver = new ChromeDriver();
        LoginPage objLoginPage = new LoginPage(driver);
        Header objHeader = new Header(driver);
        UserProfile objUserProfile = new UserProfile(driver);
        HomePage objHomePage = new HomePage(driver);

        driver.get(Constants.LOGIN_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.inputEmail(this.email);
        objLoginPage.inputPassword(this.password);
        objLoginPage.clickEnter();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objHeader.openProfile();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        objUserProfile.validateOpeningProfile();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objHeader.clickLogo();
        objHomePage.validateOpeningHomePage();
    }

    @Test
    @DisplayName("Open user profile and then log out")
    public void testOpenUserProfileAndLogOut() {
        driver = new ChromeDriver();
        LoginPage objLoginPage = new LoginPage(driver);
        Header objHeader = new Header(driver);
        UserProfile objUserProfile = new UserProfile(driver);

        driver.get(Constants.LOGIN_PAGE);
        driver.manage().window().maximize();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.inputEmail(this.email);
        objLoginPage.inputPassword(this.password);
        objLoginPage.clickEnter();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objHeader.openProfile();
        objUserProfile.validateOpeningProfile();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        objUserProfile.clickLogOutButton();

        new WebDriverWait(driver, Duration.ofSeconds(3));
        objLoginPage.validateOpeningLoginPage();
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

