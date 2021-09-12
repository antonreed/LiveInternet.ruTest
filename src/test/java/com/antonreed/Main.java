package com.antonreed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(OrderAnnotation.class)
public class Main {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static ProfileSettingsPage profileSettingsPage;
    public static NewArticle newArticle;
    public static Journal journal;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5, 100);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("startPage"));
    }

    @Test
    @Order(1)
    public void login() {
        new LoginPage(driver)
                .clickLoginLink()
                .inputLogin(ConfProperties.getProperty("login"))
                .inputPassword(ConfProperties.getProperty("password"))
                .clickLoginButton();

        wait.until(ExpectedConditions.titleIs(ConfProperties.getProperty("pageAfterLogin")));
        Assertions.assertEquals(ConfProperties.getProperty("pageAfterLogin"), driver.getTitle());
    }

    @Test
    @Order(2)
    public void createNewArticle() {
        new ProfilePage(driver)
                .clickArticleLink();
        new NewArticle(driver)
                .inputHeader("Удаление статьи")
                .inputArticle("Старую статью удаляем с помощью ID статьи методом deleteArticle(), " +
                        "теперь эта статья будет тут красоваться")
                .clickPublishButton();

        wait.until(ExpectedConditions.titleIs(ConfProperties.getProperty("pageAfterCreatingArticle")));
        Assertions.assertEquals(ConfProperties.getProperty("pageAfterCreatingArticle"), driver.getTitle());
    }

    @Test
    @Order(3)
    /*
    Для удаления статьи, естественно, обязательно существование этой статьи,
    иначе тест провален.
    */
    public void deleteArticle() {
        new ProfilePage(driver).clickDiaryLink();

        journal = new Journal(driver);
        journal.enterTheArticle(ConfProperties.getProperty("postId"));
        Assertions.assertEquals(ConfProperties.getProperty("editPostPageTitle"), driver.getTitle());
        journal
                .clickDeleteCheckBox()
                .clickSubmitButton();
    }

    @Test
    @Order(4)
    public void changeDiaryName() {
        driver.get(ConfProperties.getProperty("startPage"));

        new ProfilePage(driver)
                .clickUserMenu();
        new ProfileSettingsPage(driver)
                .clickSettingsButton()
                .inputDiaryTitle(ConfProperties.getProperty("diaryTitle"))
                .clickSubmitButton();
    }

    @AfterAll
    public static void happyEnd() {
        driver.quit();
    }
}