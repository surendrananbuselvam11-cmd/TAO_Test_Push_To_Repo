package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoPage {

    private WebDriver driver;

    @FindBy(xpath="//*[@role='button' or @type='button']")
    private WebElement el1;
    @FindBy(xpath="//*[@id='username' or @name='username' or @type='email']")
    private WebElement el2;

    public AutoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
