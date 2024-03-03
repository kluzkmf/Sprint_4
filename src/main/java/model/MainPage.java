package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends APage {

    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By cookieBy = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    private final By headerOrderButton = By.className("Button_Button__ra12g");
    private final By lendingOrderButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() { driver.get(PAGE_URL); return this; }

    public MainPage scrolToElementWithWaiting(By by) {
        new Actions(driver)
                .moveToElement(driver.findElement(by))
                .perform();
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(by).isEnabled()));
        return this;
    }

    public MainPage hideCookieNotify() {
        driver.findElement(cookieBy).click();
        return this;
    }

    public WebElement getElementQuestion(EQuestionBy byQuestion) {
        return driver.findElement(byQuestion.getByQuestion());
    }

    public WebElement getElementAnswer(EQuestionBy byAnswer) {
        return driver.findElement(byAnswer.getByAnswer());
    }

    public WebElement getHeaderOrderButton() {
        return driver.findElement(headerOrderButton);
    }

    public WebElement getLendingOrderButton() {
        return driver.findElement(lendingOrderButton);
    }
}
