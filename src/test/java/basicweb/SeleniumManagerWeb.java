package basicweb;

import org.openqa.selenium.WebDriver;
import org.test.actions.SingletonDriver;
import org.test.page.BookStorePage;
import org.test.page.LoginPage;

import java.time.Duration;

public class SeleniumManagerWeb {

    public static void main(String[] args) {
        WebDriver driver = SingletonDriver.getDriver();
        //https://www.letskodeit.com/practice
        //https://demoqa.com/books
        driver.get("https://demoqa.com/books");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        try {
            LoginPage loginPage = new LoginPage(driver);
            BookStorePage bookStorePage = new BookStorePage(driver);
            bookStorePage.clickOnLogin();
            loginPage.login("icalegiure","Icalegiure2023$$");
            bookStorePage.searchForABook("Git Pocket Guide");
            bookStorePage.clickOnSpecificBook("Git Pocket Guide");
            driver.quit();
        }catch (Exception e) {
            driver.quit();
        }
        
    }

}
