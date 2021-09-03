package com.antonreed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticle {
    private WebDriver driver;

    public NewArticle(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"headerofpost\"]")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"cke_contents_LiNewPostForm\"]/iframe")
    private WebElement iFrame;

    private WebElement article;

    @FindBy(xpath = "//*[@id=\"sendB1\"]")
    private WebElement publishButton;

    public void inputHeader(String header) {
        this.header.sendKeys(header);
    }

    public void inputArticle(String article) {
        this.article = driver.switchTo().frame(iFrame).findElement(By.tagName("body"));
        this.article.sendKeys(article);
        driver.switchTo().parentFrame();
    }

    public void clickPublishButton() {
        publishButton.click();
    }
}
