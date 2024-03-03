package model;

import org.openqa.selenium.WebDriver;

public abstract class APage {
    protected WebDriver driver;

    public APage(WebDriver driver) {
        this.driver = driver;
    }
}
