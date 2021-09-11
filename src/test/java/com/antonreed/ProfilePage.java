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
    public void clickArticleLink() {
        articleLink.click();
    }

    public void clickDiaryLink() {
        diary.click();
    }

    public void clickUserMenu() {
        userMenu.click();
    }

    public String getUserName() {
        return userMenu.getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
