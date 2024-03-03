import model.MainPage;
import model.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class OrderTest {

    // Набор тестовых данных для теста №1
    private static final String NAME_1 = "Венедикт";
    private static final String SECOND_NAME_1 = "Борщёвский";
    private static final String ADDRESS_1 = "г. Пушкино, ул. Пушкинское поле, д. 2";
    private static final String STATION_1 = "Те";
    private static final String PHONE_1 = "+79955544332";
    private static final String DELIVERY_DATE_1 = "19.02.2024";
    private static final String COMMIT_1 = "И печеньки";

    // Набор тестовых данных для теста №2
    private static final String NAME_2 = "Поряшек";
    private static final String SECOND_NAME_2 = "Висконсин";
    private static final String ADDRESS_2 = "г. Новороссийск, ул. Ленина, д. 14";
    private static final String STATION_2 = "Университет";
    private static final String PHONE_2 = "+18086000138";
    private static final String DELIVERY_DATE_2 = "01.01.2025";
    private static final String COMMIT_2 = "Хорошее настроение";

    public WebDriver driver;
    @After
    public void tearDown() {
        driver.quit();
    }

    // Тест №1
    @Test
    public void checkOrder_headerButton() {
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .hideCookieNotify();
        mainPage.getHeaderOrderButton().click();
        // Задержка открытия страницы
        OrderPage orderPage = new OrderPage(driver);

        // Заполняем форму "Для кого самокат"
        orderPage
                .enterName(NAME_1)
                .enterSecondName(SECOND_NAME_1)
                .enterAddress(ADDRESS_1)
                .enterStation(STATION_1).sendArrowUpKeyStation().sendEnterKeyStation()
                .enterPhone(PHONE_1)
                .clickNextButton();
        // Заполняем форму "Про аренду"
        orderPage
                .enterDeliveryDate(DELIVERY_DATE_1)
                .sendEnterKeyDeliveryDate()
                .clickRentPeriodDropdown()
                .selectOneDayPeriod()
                .markGreyCheckbox()
                .enterComment(COMMIT_1)
                .clickOrderButton()
                .clickYesButton();

        Assert.assertTrue(orderPage.isDisplayedSuccess());
    }

    // Тест №2
    @Test
    public void checkOrder_lendingButton() {
        driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .hideCookieNotify();
        mainPage.getHeaderOrderButton().click();
        // Задержка открытия страницы
        OrderPage orderPage = new OrderPage(driver);

        // Заполняем форму "Для кого самокат"
        orderPage
                .enterName(NAME_2)
                .enterSecondName(SECOND_NAME_2)
                .enterAddress(ADDRESS_2)
                .enterStation(STATION_2).sendArrowUpKeyStation().sendEnterKeyStation()
                .enterPhone(PHONE_2)
                .clickNextButton();
        // Заполняем форму "Про аренду"
        orderPage
                .enterDeliveryDate(DELIVERY_DATE_2)
                .sendEnterKeyDeliveryDate()
                .clickRentPeriodDropdown()
                .selectSevenDaysPeriod()
                .markBlackCheckbox()
                .enterComment(COMMIT_2)
                .clickOrderButton()
                .clickYesButton();

        Assert.assertTrue(orderPage.isDisplayedSuccess());
    }

}
