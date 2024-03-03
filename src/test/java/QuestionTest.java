import model.EQuestionBy;
import model.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;
import java.util.Collection;

/*
* Параметризированный тест "Вопросы о важном"
*/

@RunWith(Parameterized.class)
public class QuestionTest extends ATest {

    // Тест №1. Ожидаемый вопрос:
    private static final String EXPECTED_HOW_MUCH_QUESTION = "Сколько это стоит? И как оплатить?";
    // Тест №1. Ожидаемый ответ:
    private static final String EXPECTED_HOW_MUCH_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    // Тест №2. Ожидаемый вопрос:
    private static final String EXPECTED_SEVERAL_QUESTION = "Хочу сразу несколько самокатов! Так можно?";
    // Тест №2. Ожидаемый ответ:
    private static final String EXPECTED_SEVERAL_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    // Тест №3. Ожидаемый вопрос:
    private static final String EXPECTED_CALC_RENT_TIME_QUESTION = "Как рассчитывается время аренды?";
    // Тест №3. Ожидаемый ответ:
    private static final String EXPECTED_CALC_RENT_TIME_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    // Тест №4. Ожидаемый вопрос:
    private static final String EXPECTED_ONLY_TODAY_QUESTION = "Можно ли заказать самокат прямо на сегодня?";
    // Тест №4. Ожидаемый ответ:
    private static final String EXPECTED_ONLY_TODAY_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    // Тест №5. Ожидаемый вопрос:
    private static final String EXPECTED_EXTEND_ORDER_QUESTION = "Можно ли продлить заказ или вернуть самокат раньше?";
    // Тест №5. Ожидаемый ответ:
    private static final String EXPECTED_EXTEND_ORDER_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    // Тест №6. Ожидаемый вопрос:
    private static final String EXPECTED_CHARGE_TRANSFER_QUESTION = "Вы привозите зарядку вместе с самокатом?";
    // Тест №6. Ожидаемый ответ:
    private static final String EXPECTED_CHARGE_TRANSFER_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    // Тест №7. Ожидаемый вопрос:
    private static final String EXPECTED_CANCEL_POSSIBLE_QUESTION = "Можно ли отменить заказ?";
    // Тест №7. Ожидаемый ответ:
    private static final String EXPECTED_CANCEL_POSSIBLE_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    // Тест №8. Ожидаемый вопрос:
    private static final String EXPECTED_OUT_OF_MOSCOW_QUESTION = "Я жизу за МКАДом, привезёте?";
    // Тест №8. Ожидаемый ответ:
    private static final String EXPECTED_OUT_OF_MOSCOW_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private MainPage mainPage;
    private EQuestionBy by;
    private String expectedQuestion;
    private String expectedAnswer;

    public QuestionTest(EQuestionBy by, String expectedQuestion, String expectedAnswer) {
        this.by = by;
        this.expectedQuestion = expectedQuestion;
        this.expectedAnswer = expectedAnswer;
    };

    @Parameterized.Parameters
    public static Collection questions() {
        return Arrays.asList( new Object[][] {
                {EQuestionBy.HOW_MUCH, EXPECTED_HOW_MUCH_QUESTION, EXPECTED_HOW_MUCH_ANSWER},
                {EQuestionBy.SEVERAL, EXPECTED_SEVERAL_QUESTION, EXPECTED_SEVERAL_ANSWER},
                {EQuestionBy.CALC_RENT_TIME, EXPECTED_CALC_RENT_TIME_QUESTION, EXPECTED_CALC_RENT_TIME_ANSWER},
                {EQuestionBy.ONLY_TODAY, EXPECTED_ONLY_TODAY_QUESTION, EXPECTED_ONLY_TODAY_ANSWER},
                {EQuestionBy.EXTEND_ORDER, EXPECTED_EXTEND_ORDER_QUESTION, EXPECTED_EXTEND_ORDER_ANSWER},
                {EQuestionBy.CHARGE_TRANSFER, EXPECTED_CHARGE_TRANSFER_QUESTION, EXPECTED_CHARGE_TRANSFER_ANSWER},
                {EQuestionBy.CANCEL_POSSIBLE, EXPECTED_CANCEL_POSSIBLE_QUESTION, EXPECTED_CANCEL_POSSIBLE_ANSWER},
                {EQuestionBy.OUT_OF_MOSCOW, EXPECTED_OUT_OF_MOSCOW_QUESTION, EXPECTED_OUT_OF_MOSCOW_ANSWER},
        });
    }

    @Test
    public void checkQuestionHowMuch() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage
                .open().hideCookieNotify()
                .scrolToElementWithWaiting(by.getByQuestion());
        Assert.assertEquals(expectedQuestion, mainPage.getElementQuestion(by).getText());
        mainPage.getElementQuestion(by).click();
        new WebDriverWait(driver, 10).until(driver -> (mainPage.getElementAnswer(by).isEnabled()));
        Assert.assertEquals(expectedAnswer, mainPage.getElementAnswer(by).getText());
    }
}
