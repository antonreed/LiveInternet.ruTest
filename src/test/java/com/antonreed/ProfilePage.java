package com.antonreed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id = \"_li-panel\"]//*[@class = \"username\"]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@id = \"_li-panel\"]//a[contains(text(), \"Написать\")]")
    private WebElement articleLink;

    @FindBy(xpath = "//*[@id = \"_li-panel\"]//a[contains(text(), \"Мой дневник\")]")
    private WebElement diary;

    @FindBy(xpath = "//*[@id = \"_li-panel\"]//a[contains(text(), \"Выйти\")]")
    private WebElement logoutButton;

    public ProfilePage clickArticleLink() {
        articleLink.click();
        return this;
    }

    public ProfilePage clickDiaryLink() {
        diary.click();
        return this;
    }

    public ProfilePage clickUserMenu() {
        userMenu.click();
        return this;
    }

    public String getUserName() {
        return userMenu.getText();
    }
}
