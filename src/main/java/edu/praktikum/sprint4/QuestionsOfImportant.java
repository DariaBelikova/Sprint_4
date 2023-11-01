package edu.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionsOfImportant {

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver webDriver;
    private final int index;

    public QuestionsOfImportant(WebDriver webDriver, int index) {
        this.webDriver = webDriver;
        this.index = index;
    }

    public void open() {
        webDriver.get(URL);
    }

    private By questionsImportant = By.xpath(".//div[text() = 'Вопросы о важном']");
    //Первый вопрос
    private By firstQButtons =
            By.xpath(".//div[@id = 'accordion__heading-0']");
    //Второй вопрос
    private By secondQButtons =
            By.xpath(".//div[@id = 'accordion__heading-1']");
    //Третий вопрос
    private By thirdQButtons =
            By.xpath(".//div[@id = 'accordion__heading-2']");
    //Четвертый вопрос
    private By fourthtQButtons =
            By.xpath(".//div[@id = 'accordion__heading-3']");
    //Пятый вопрос
    private By fifthtQButtons =
            By.xpath(".//div[@id = 'accordion__heading-4']");
    //Шестой вопрос
    private By sixthQButtons =
            By.xpath(".//div[@id = 'accordion__heading-5']");
    //Седьмой вопрос
    private By seventhQButtons =
            By.xpath(".//div[@id = 'accordion__heading-6']");
    //Восьмой вопрос
    private By eighthDropDownButtons =
            By.xpath(".//div[@id = 'accordion__heading-7']");

    public void clickButton() {
        scrollTo();
        webDriver.findElements(By.cssSelector("div[role=button]")).get(index).click();
    }

    //Ответ
    public String getAnswer() {
        return webDriver.findElements(By.cssSelector("div[role=region]")).get(index).getText();
    }

    //Скрол до элемента
    public void scrollTo() {
        WebElement element = webDriver.findElements(By.cssSelector("div[role=button]")).get(index);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
