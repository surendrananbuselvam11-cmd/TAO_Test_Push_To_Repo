package utils;

import org.openqa.selenium.*;

public class ElementUtils {
    public static void type(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    public static void click(WebElement el) {
        el.click();
    }
}
