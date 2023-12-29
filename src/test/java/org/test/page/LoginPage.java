package org.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    @FindBy(id = "userName")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void typeUsername(String text){
        usernameInput.sendKeys(text);
    }

    public void typePassword(String text){
        passwordInput.sendKeys(text);
    }

    public void clickOnLogin(){
        loginButton.click();
    }

    public void login(String username, String password){
        typeUsername(username);
        typePassword(password);
        clickOnLogin();
    }
}
