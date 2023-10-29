package edu.praktikum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class Order {


    private WebDriver webDriver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void doOrder_1() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        mainPage.clickOrder();
        mainPage.inputFirstName("Гермиона");
        mainPage.inputLastName("Гренджер");
        mainPage.inputAddress("Тисовая улица 2");
        mainPage.selectMetroStation();
        mainPage.inputPhone("98765432198");
        mainPage.clicknextButton();

        mainPage.inputDateOrder("30.10.2023");
        mainPage.inputOrderDuration("трое суток");
        mainPage.inputColorOrederBlack();
        mainPage.inputComments("Комментарий");

        mainPage.clickOrderButton();
        assertTrue("Нет перехода на страницу с информацией об успешно сделаном заказе.", mainPage.successfulOrder().checkOrderMassage());

    }

    @Test
    public void doOrder_2() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();
        mainPage.clickOrderSecBut();
        mainPage.inputFirstName("Гарри");
        mainPage.inputLastName("Поттер");
        mainPage.inputAddress("Тисовая улица, 2");
        mainPage.selectMetroStation();
        mainPage.inputPhone("98765432198");
        mainPage.clicknextButton();

        mainPage.inputDateOrder("01.11.2023");
        mainPage.inputOrderDuration("двое суток");
        mainPage.inputColorOrederGrey();

        mainPage.clickOrderButton();
        assertTrue("Нет перехода на страницу с информацией об успешно сделаном заказе.", mainPage.successfulOrder().checkOrderMassage());

    }

    @After

    public void tearDown() {
        webDriver.quit();
    }



}
