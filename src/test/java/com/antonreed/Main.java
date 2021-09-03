package com.antonreed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Main {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static NewArticle newArticle;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5, 100);
        loginPage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("startPage"));
    }

    @Test
    public void login() {
        loginPage.clickLoginLink();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.titleIs(ConfProperties.getProperty("pageAfterLogin")));
        Assert.assertEquals(ConfProperties.getProperty("pageAfterLogin"), driver.getTitle());
    }

    @Test
    public void createNewArticle() {
        profilePage = new ProfilePage(driver);
        newArticle = new NewArticle(driver);

        profilePage.clickArticleLink();
        newArticle.inputHeader("Я знал!");
        newArticle.inputArticle("В общем и целом, сел я такой на работе и думаю: " +
                "а почему бы мне не глянуть материал по теме ДЗ №11 ДО лекции. И не ошибся, " +
                "когда начал усвоенный материал перекладывать на предыдущий опыт(ДЗ №9). " +
                "Теперь пойду на курсы экстрасенсов для становления более сильной ауры провидца :)");

        newArticle.clickPublishButton();
        wait.until(ExpectedConditions.titleIs(ConfProperties.getProperty("pageAfterCreatingArticle")));
        Assert.assertEquals(ConfProperties.getProperty("pageAfterCreatingArticle"), driver.getTitle());
    }

    @AfterClass
    public static void happyEnd() {
        driver.quit();
    }
}