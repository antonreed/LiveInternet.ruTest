package com.antonreed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Journal {
    private WebDriver driver;

    public Journal(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name = \"deletepost\"]")
    private WebElement deleteCheckBox;

    @FindBy(xpath = "//input[@name = \"deletepost\"]/..//input[@type = \"submit\"]")
    private WebElement submitButton;

    public void enterTheArticle(String id) {
        WebElement article = driver.findElement(By
                .xpath("//*[@id = '" + id + "']//a[contains(text(), \"редактировать\")]"));
        article.click();
    }

    public Journal clickDeleteCheckBox() {
        deleteCheckBox.click();
        return this;
    }

    public Journal clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
