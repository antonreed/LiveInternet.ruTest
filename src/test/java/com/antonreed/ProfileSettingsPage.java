package com.antonreed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileSettingsPage {
    private WebDriver driver;

    public ProfileSettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@title = \"Настройки\"]/a")
    private WebElement settigsButton;

    @FindBy(xpath = "//*[@id = \"shared\"]//input[@name = \"title\"]")
    private WebElement diaryTitle;

    @FindBy(xpath = "//input[@value = \"Внести изменения\"]")
    private WebElement submitButton;

    public ProfileSettingsPage clickSettingsButton() {
        settigsButton.click();
        return this;
    }

    public ProfileSettingsPage inputDiaryTitle(String title) {
        diaryTitle.clear();
        diaryTitle.sendKeys(title);
        return this;
    }

    public ProfileSettingsPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
