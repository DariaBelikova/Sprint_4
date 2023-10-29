package edu.praktikum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

  //1
public class AnswersTest {

    private WebDriver webDriver;


    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

@Test
    public void checkFirstButton(){
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 0);
        baseButtonBlock.clickButton();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", baseButtonBlock.getAnswer());
    }

    @Test
    public void checkSecondButton(){
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 1);
        baseButtonBlock.clickButton();
        assertEquals("Пока что у нас так: один заказ — один самокат." +
                " Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", baseButtonBlock.getAnswer());
    }

    @Test
    public void checkThirdButton(){
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 2);
        baseButtonBlock.clickButton();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
                " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", baseButtonBlock.getAnswer());
    }

    @Test
    public void checkFourthButton(){

        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 3);
        baseButtonBlock.clickButton();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", baseButtonBlock.getAnswer());
    }


    @Test
    public void checkFifthButton(){

        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 4);
        baseButtonBlock.clickButton();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", baseButtonBlock.getAnswer());
    }

    @Test
    public void checkSixthButton(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 5);
        baseButtonBlock.clickButton();
        assertEquals("Самокат приезжает к вам с полной зарядкой." +
                " Этого хватает на восемь суток — даже если будете кататься без передышек и во сне." +
                " Зарядка не понадобится.", baseButtonBlock.getAnswer());
    }

    @Test
    public void checkSevenButton(){
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 6);
        baseButtonBlock.clickButton();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", baseButtonBlock.getAnswer());
    }

    @Test
    public void checkEigthButton(){
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        QuestionsOfImportant baseButtonBlock = new QuestionsOfImportant(webDriver, 7);
        baseButtonBlock.clickButton();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",baseButtonBlock.getAnswer());
    }

    @After

    public void tearDown() {
        webDriver.quit();
    }
}

