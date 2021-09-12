package com.antonreed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@id = \"_li-serv_blog\" or contains(text(), \"В дневник\")]")
    private WebElement loginLink;

    @FindBy(xpath = "//form[@id = \"blog_login_form\"]//*[@name = \"blog_username\"]")
    private WebElement loginField;

    @FindBy(xpath = "//form[@id = \"blog_login_form\"]//*[@name = \"blog_password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//form[@id = \"blog_login_form\"]//*[@value = \"Войти\"]")
    private WebElement loginButton;

    public LoginPage inputLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginLink() {
        loginLink.click();
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
