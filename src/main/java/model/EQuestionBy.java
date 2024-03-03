package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum EQuestionBy {

    // Локаторы для элементов - Вопросы о важном
    // Вопрос: "Сколько это стоит? И как оплатить?";
    // Ответ: "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
    HOW_MUCH("accordion__heading-0", "accordion__panel-0"),
    // Вопрос: "Хочу сразу несколько самокатов! Так можно?";
    // Ответ: "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
    SEVERAL("accordion__heading-1", "accordion__panel-1"),
    // Вопрос: "Как рассчитывается время аренды?";
    // Ответ: "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
    CALC_RENT_TIME("accordion__heading-2", "accordion__panel-2"),
    // Вопрос: "Можно ли заказать самокат прямо на сегодня?";
    // Ответ: "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
    ONLY_TODAY("accordion__heading-3", "accordion__panel-3"),
    // Вопрос: "Можно ли продлить заказ или вернуть самокат раньше?";
    // Ответ: "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
    EXTEND_ORDER("accordion__heading-4", "accordion__panel-4"),
    // Вопрос: "Вы привозите зарядку вместе с самокатом?";
    // Ответ: "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
    CHARGE_TRANSFER("accordion__heading-5", "accordion__panel-5"),
    // Вопрос: "Можно ли отменить заказ?";
    // Ответ: "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
    CANCEL_POSSIBLE("accordion__heading-6", "accordion__panel-6"),
    // Вопрос: "Я жизу за МКАДом, привезёте?";
    // Ответ: "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    OUT_OF_MOSCOW("accordion__heading-7", "accordion__panel-7");

    private By byQuestion;
    private By byAnswer;
    private String id_question;
    private String id_answer;

    private WebDriver driver;

    EQuestionBy(String id_question, String id_answer){
        this.byQuestion = By.id(id_question);
        this.byAnswer = By.id(id_answer);
    };

    public By getByQuestion() {
        return byQuestion;
    }

    public By getByAnswer() {
        return byAnswer;
    }

}
