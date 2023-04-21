package tests;

import api.ApiCoreRequests;
import api.DataGenerator;
import api.ApiEndPoints;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import lib.Constants;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.HashMap;
import java.util.Map;

public class RegisterTest {

    private WebDriver driver;
    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();
    String name;
    String email;
    String password;
    String accessToken;

    @Test
    @DisplayName("User registration happy path")
    public void testRegisterUserPositive() {
        Map<String,String> userData = DataGenerator.getRegistrationData();
        this.name = userData.get("name");
        this.email = userData.get("email");
        this.password = userData.get("password");

        driver = new ChromeDriver();
        RegisterPage objRegisterPage = new RegisterPage(driver);

        driver.get(Constants.REGISTER_PAGE);
        driver.manage().window().maximize();

        objRegisterPage.inputName(this.name);
        objRegisterPage.inputEmail(this.email);
        objRegisterPage.inputPassword(this.password);
        objRegisterPage.clickRegister();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.validateOpeningLoginPage();

        Map<String,String> loginData = new HashMap<>();
        loginData.put("email", this.email);
        loginData.put("password", this.password);
        Response responseCheckLogin = apiCoreRequests.makePostRequest(
                ApiEndPoints.LOGIN,
                loginData
        );
        this.accessToken = responseCheckLogin.path("accessToken");
        responseCheckLogin.then().assertThat().statusCode(200);
        apiCoreRequests.makeDeleteRequest(
                ApiEndPoints.USER,
                this.accessToken
        );
    }

    @Test
    @DisplayName("User registration attempt with short invalid password")
    public void testRegisterUserNegative() {
        Map<String,String> userData = DataGenerator.getRegistrationData();
        this.name = userData.get("name");
        this.email = userData.get("email");
        this.password = "123";

        driver = new ChromeDriver();
        RegisterPage objRegisterPage = new RegisterPage(driver);

        driver.get(Constants.REGISTER_PAGE);
        driver.manage().window().maximize();

        objRegisterPage.inputName(this.name);
        objRegisterPage.inputEmail(this.email);
        objRegisterPage.inputPassword(this.password);
        objRegisterPage.clickRegister();
        objRegisterPage.validatePasswordWarning();

        Map<String,String> loginData = new HashMap<>();
        loginData.put("email", this.email);
        loginData.put("password", this.password);
        Response responseCheckLogin = apiCoreRequests.makePostRequest(
                ApiEndPoints.LOGIN,
                loginData
        );

        if (responseCheckLogin.statusCode() == 200) {
            this.accessToken = responseCheckLogin.path("accessToken");
            apiCoreRequests.makeDeleteRequest(
                    ApiEndPoints.USER,
                    this.accessToken
            );
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

