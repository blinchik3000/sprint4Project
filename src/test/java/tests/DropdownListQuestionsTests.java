package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;

public class DropdownListQuestionsTests {
    private WebDriver driver;

    @Before
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void checkHowMuchDropdownAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickHowMuchDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", mainPageObj.getHowMuchDropdownListAnswer());
    }

    @Test
    public void checkCanSeveralScootersDropdownListAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickCanSeveralScootersDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", mainPageObj.getCanSeveralScootersDropdownListAnswer());
    }

    @Test
    public void checkWhatRentalTimeDropdownListAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickWhatRentalTimeDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", mainPageObj.getWhatRentalTimeDropdownListAnswer());
    }

    @Test
    public void checkCanOrderTodayDropdownListAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickCanOrderTodayDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", mainPageObj.getCanOrderTodayDropdownListAnswer());
    }

    @Test
    public void checkCanProlongRentalTimeDropdownListAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickCanProlongRentalTimeDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", mainPageObj.getCanProlongRentalTimeDropdownListAnswer());
    }

    @Test
    public void checkIsChargingAddedDropdownListAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickIsChargingAddedDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", mainPageObj.getIsChargingAddedDropdownListAnswer());
    }

    @Test
    public void checkCanCancelOrderDropdownListAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickCanCancelOrderDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", mainPageObj.getCanCancelOrderDropdownListAnswer());
    }

    @Test
    public void checkCanMakeOrderOutsideMoscowDropdownListAnswer() {
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickCanMakeOrderOutsideMoscowDropdownList();
        Assert.assertEquals("Проверяем текст ответа",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области.", mainPageObj.getCanMakeOrderOutsideMoscowDropdownListAnswer());
    }

    @After
    public void teardown() {
        // Закрываю браузер
        driver.quit();
    }
}
