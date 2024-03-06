import model.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class OrderTest extends BaseTest {

    // Набор тестовых данных для теста заказа в шапке
    private static final String NAME_HEADER_BUTTON_CHECK = "Венедикт";
    private static final String SECOND_NAME_HEADER_BUTTON_CHECK = "Борщёвский";
    private static final String ADDRESS_HEADER_BUTTON_CHECK = "г. Пушкино, ул. Пушкинское поле, д. 2";
    private static final String STATION_HEADER_BUTTON_CHECK = "Те";
    private static final String PHONE_HEADER_BUTTON_CHECK = "+79955544332";
    private static final String DELIVERY_DATE_HEADER_BUTTON_CHECK = "19.02.2024";
    private static final String COMMIT_HEADER_BUTTON_CHECK = "И печеньки";

    // Набор тестовых данных для теста заказа в лендинге
    private static final String NAME_LENDING_BUTTON_CHECK = "Поряшек";
    private static final String SECOND_NAME_LENDING_BUTTON_CHECK = "Висконсин";
    private static final String ADDRESS_LENDING_BUTTON_CHECK = "г. Новороссийск, ул. Ленина, д. 14";
    private static final String STATION_LENDING_BUTTON_CHECK = "Университет";
    private static final String PHONE_LENDING_BUTTON_CHECK = "+18086000138";
    private static final String DELIVERY_DATE_LENDING_BUTTON_CHECK = "01.01.2025";
    private static final String COMMIT_LENDING_BUTTON_CHECK = "Хорошее настроение";

    //Метод для заполнения формы заказа
    private boolean makeOrder(EOrderButtonBy orderButtonBy,
                           String name,
                           String secondName,
                           String address,
                           String station,
                           Keys arrowKey,
                           String phone,
                           String deliveryDate,
                           EDaysPeriodBy daysPeriodBy,
                           EColorCheckBoxBy colorCheckBoxBy,
                           String comment
                           ) {
        MainPage mainPage = new MainPage(driver);
        mainPage
                .open()
                .hideCookieNotify();
        //Нажимаем на кнопку "Заказать"
        mainPage.getOrderButton(orderButtonBy).click();
        OrderPage orderPage = new OrderPage(driver);

        // Заполняем форму "Для кого самокат"
        orderPage
                .enterName(name)
                .enterSecondName(secondName)
                .enterAddress(address)
                .enterStation(station).sendStationInputKeyStation(arrowKey).sendEnterKeyStation()
                .enterPhone(phone)
                .clickNextButton();

        // Заполняем форму "Про аренду"
        orderPage
                .enterDeliveryDate(deliveryDate)
                .sendEnterKeyDeliveryDate()
                .clickRentPeriodDropdown()
                .selectDaysPeriod(daysPeriodBy)
                .markColorCheckbox(colorCheckBoxBy)
                .enterComment(comment)
                .clickOrderButton()
                .clickYesButton();

        return orderPage.isDisplayedSuccess();
    }

    // Тест заказа из шапки
    @Test
    public void checkOrderHeaderButton() {

        boolean checkVisibleSuccess = makeOrder(
                EOrderButtonBy.HEADER,
                NAME_HEADER_BUTTON_CHECK,
                SECOND_NAME_HEADER_BUTTON_CHECK,
                ADDRESS_HEADER_BUTTON_CHECK,
                STATION_HEADER_BUTTON_CHECK,
                Keys.ARROW_DOWN,
                PHONE_HEADER_BUTTON_CHECK,
                DELIVERY_DATE_HEADER_BUTTON_CHECK,
                EDaysPeriodBy.ONE,
                EColorCheckBoxBy.GREY,
                COMMIT_HEADER_BUTTON_CHECK
                );

        Assert.assertTrue(checkVisibleSuccess);
    }

    // Тест заказа из лендинга
    @Test
    public void checkOrderLendingButton() {

        boolean checkVisibleSuccess = makeOrder(
                EOrderButtonBy.LENDING,
                NAME_LENDING_BUTTON_CHECK,
                SECOND_NAME_LENDING_BUTTON_CHECK,
                ADDRESS_LENDING_BUTTON_CHECK,
                STATION_LENDING_BUTTON_CHECK,
                Keys.ARROW_UP,
                PHONE_LENDING_BUTTON_CHECK,
                DELIVERY_DATE_LENDING_BUTTON_CHECK,
                EDaysPeriodBy.SEVEN,
                EColorCheckBoxBy.BLACK,
                COMMIT_LENDING_BUTTON_CHECK
        );

        Assert.assertTrue(checkVisibleSuccess);
    }

}
