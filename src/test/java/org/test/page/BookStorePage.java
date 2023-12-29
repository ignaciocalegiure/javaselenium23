package org.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage {
    private WebDriver driver;
    @FindBy(id = "login")
    private WebElement loginButton;
    @FindBy(id = "submit")
    private WebElement logoutButton;
    @FindBy(id = "searchBox")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@role='rowgroup']")
    private WebElement listOfBooks;

    public BookStorePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnLogin(){
        loginButton.click();
    }

    public void clickOnLogOut(){
        logoutButton.click();
    }

    public void searchForABook(String text) {
        searchInput.sendKeys(text);
    }

    public void clickOnSpecificBook(String book){
        listOfBooks.findElement(By.xpath("//a[text()='"+book+"']")).click();
    }

}
