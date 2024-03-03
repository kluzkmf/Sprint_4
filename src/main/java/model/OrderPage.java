package model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends APage {

    // Для кого самокат
    // Поле "Имя"
    private By nameInput = By.xpath("//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private By secondNameInput = By.xpath("//input[@placeholder='* Фамилия']");
    // Поле "Адрес: куда привезти заказ"
    private By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    private By stationInput = By.xpath("//input[@placeholder='* Станция метро']");
    // Поле "Телефон: на него позвонит курьер"
    private By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    // Про аренду
    // Поле "Когда привезти самокат"
    private By DeliveryDateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Поле "Срок аренды"
    private By rentPeriodDropdown = By.xpath("//div[@class='Dropdown-placeholder']");
    // Выбор для выпадающего списка "Срок аренды"
    private By oneDayPeriod = By.xpath(".//div[text()='сутки']");
    private By sevenDaysPeriod = By.xpath(".//div[text()='семеро суток']");

    // Чекбокс "чёрный жемчуг"
    private By blackCheckbox = By.xpath("//input[@id='black']");
    // Чекбокс "серая безысходность"
    private By greyCheckbox = By.xpath("//input[@id='grey']");
    // Поле "Комментарий для курьера"
    private By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private By orderButton = By.cssSelector("div.Order_Buttons__1xGrp > button:nth-child(2)");
    // Хотите оформить заказ?
    // Кнопка "Да"
    private By yesButton = By.xpath(" //button[contains(text(),'Да')]");
    // Кнопка "Нет"
    private By noButton = By.xpath("//button[contains(text(),'Нет')]");

    private By successInfo = By.xpath("//div[contains(text(),'Заказ оформлен')]"); // В Хроме не появляется


    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public OrderPage enterSecondName(String secondName) {
        driver.findElement(secondNameInput).sendKeys(secondName);
        return this;
    }

    public OrderPage enterAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public OrderPage enterStation(String station) {
        driver.findElement(stationInput).sendKeys(station);
        return this;
    }
    public OrderPage sendArrowUpKeyStation() {
        driver.findElement(stationInput).sendKeys(Keys.ARROW_UP);
        return this;
    }

    public OrderPage sendEnterKeyStation() {
        driver.findElement(stationInput).sendKeys(Keys.ENTER);
        return this;
    }

    public OrderPage enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }

    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage enterDeliveryDate(String date) {
        driver.findElement(DeliveryDateInput).sendKeys(date);
        return this;
    }
    public OrderPage sendEnterKeyDeliveryDate() {
        driver.findElement(DeliveryDateInput).sendKeys(Keys.ENTER);
        return this;
    }


    public OrderPage clickRentPeriodDropdown() {
        driver.findElement(rentPeriodDropdown).click();
        return this;
    }

    public OrderPage selectOneDayPeriod() {
        driver.findElement(oneDayPeriod).click();
        return this;
    }

    public OrderPage selectSevenDaysPeriod() {
        driver.findElement(sevenDaysPeriod).click();
        return this;
    }

    public OrderPage markBlackCheckbox() {
        driver.findElement(blackCheckbox).click();
        return this;
    }

    public OrderPage markGreyCheckbox() {
        driver.findElement(greyCheckbox).click();
        return this;
    }

    public OrderPage enterComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public OrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderPage clickYesButton() {
        driver.findElement(yesButton).click();
        return this;
    }

    public OrderPage clickNoButton() {
        driver.findElement(noButton).click();
        return this;
    }

    public boolean isDisplayedSuccess() {
        return driver.findElement(successInfo).isDisplayed();
    }

}
