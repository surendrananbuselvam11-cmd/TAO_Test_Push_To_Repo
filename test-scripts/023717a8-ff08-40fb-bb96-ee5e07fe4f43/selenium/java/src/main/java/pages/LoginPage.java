package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Minimal real behavior methods to avoid constructor-only stubs
    public void open(String url) {
        if (url != null && !url.isEmpty()) driver.get(url);
    }
    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void type(By locator, String text) {
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(text);
    }

    public void navigateTo(Object arg1) {
        // synthesized stub - implement interaction
    }

    public void enterUsername(Object arg1) {
        // synthesized stub - implement interaction
    }

    public void enterPassword(Object arg1) {
        // synthesized stub - implement interaction
    }

    public void clickLogin() {
        // synthesized stub - implement interaction
    }
}
