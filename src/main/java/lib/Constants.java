package lib;

public class Constants {

    // ***** URL's *****
    public static String HOME_PAGE = "https://stellarburgers.nomoreparties.site/";
    public static String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    public static String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    public static String RESTORE_PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";

    // ***** XPATH*****

    // HOME PAGE
    public static String CONSTRUCTOR_HEADER = ".//section/h1[text()='Соберите бургер']";
    public static String LOGIN_BUTTON = ".//button[text()='Войти в аккаунт']";
    public static String BUNS = ".//span[text()='Булки']";
    public static String BUNS_ENABLED =
            ".//main/section[1]/div[1]/div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']";
    public static String SAUCE = ".//span[text()='Соусы']";
    public static String SAUCE_ENABLED =
            ".//main/section[1]/div[1]/div[2][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']";
    public static String FILLING = ".//span[text()='Начинки']";
    public static String FILLING_ENABLED =
            ".//main/section[1]/div[1]/div[3][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']";
    public static String MAKE_ORDER_BUTTON = ".//button[text()='Оформить заказ']";

    // HEADER
    public static String PROFILE_BUTTON = ".//p[text()='Личный Кабинет']";
    public static String LOGO_LINK = ".//div[@class='AppHeader_header__logo__2D0X2']";
    public static String CONSTRUCTOR = ".//p[text()='Конструктор']";

    // LOGIN, REGISTER, RESTORE PASSWORD PAGES
    public static String ENTER_HEADER = ".//div/h2[text()='Вход']";
    public static String INPUT_NAME = ".//input[@name='name']";
    public static String INPUT_EMAIL = ".//fieldset[2]/div/div/input";
    public static String INPUT_EMAIL_ON_LOGIN = ".//input[@name='name']";
    public static String INPUT_PASSWORD = ".//input[@name='Пароль']";
    public static String LOG_IN = ".//button[text()='Войти']";
    public static String REGISTER_LINK = ".//a[text()='Зарегистрироваться']";
    public static String RESTORE_PASSWORD_LINK = ".//a[text()='Восстановить пароль']";
    public static String REGISTER_BUTTON = ".//button[text()='Зарегистрироваться']";
    public static String INVALID_PASSWORD_WARNING = ".//p[text()='Некорректный пароль']";
    public static String LOGIN_PAGE_LINK = ".//a[text()='Войти']";

    // USER PROFILE
    public static String PROFILE_DESCRIPTION_TEXT = ".//p[@class='Account_text__fZAIn text text_type_main-default']";
    public static String LOG_OUT_BUTTON = ".//button[text()='Выход']";
}

