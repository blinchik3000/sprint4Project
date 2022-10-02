package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;
import pageObject.OrderPage;

@RunWith(Parameterized.class)
public class MakeOrderTests {

    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String orderDate;
    private final String rentalPeriod;
    private final String colour;
    private final String comment;

    private WebDriver driver;

    public MakeOrderTests(String name,String surname,String address,String subwayStation,String phoneNumber,String orderDate,String rentalPeriod,String colour,String comment){
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.subwayStation=subwayStation;
        this.phoneNumber=phoneNumber;
        this.orderDate=orderDate;
        this.rentalPeriod=rentalPeriod;
        this.colour=colour;
        this.comment=comment;
    }



    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] makingOrderVariations() {
        return new Object[][] {
                { "йцукен", "фывап", "фвфывфв","Братиславская","89991234567","01.10.2022","сутки","black","qweqwewqeeqw"},
                { "Йцук1", "Фыв1", "йц, М.","Бульвар Рокоссовского","11111111111","01.01.2015","двое суток","white","1fwgga?/."},
        };
    }



    @Before
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void checkMakingOrderfromHeader() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickHeaderOrderButton();

        driver.get("https://qa-scooter.praktikum-services.ru/order/");

        OrderPage orderPageObj = new OrderPage(driver);
        orderPageObj.setAllOrderFields(name, surname, address, subwayStation, phoneNumber, orderDate, rentalPeriod, colour, comment);
        orderPageObj.orderSecondPageOrderButtonClick();
        orderPageObj.orderSecondPageModalYesButtonClick();

        Assert.assertTrue(orderPageObj.isOrderSucceed());
    }

    @Test
    public void checkMakingOrderfromHome() {

        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPageObj = new MainPage(driver);

        mainPageObj.clickHomeOrderButton();

        driver.get("https://qa-scooter.praktikum-services.ru/order/");

        OrderPage orderPageObj = new OrderPage(driver);
        orderPageObj.setAllOrderFields(name, surname, address, subwayStation, phoneNumber, orderDate, rentalPeriod, colour, comment);
        orderPageObj.orderSecondPageOrderButtonClick();
        orderPageObj.orderSecondPageModalYesButtonClick();

        Assert.assertTrue(orderPageObj.isOrderSucceed());

    }

    @After
    public void teardown() {
        // Закрываю браузер
        driver.quit();
    }

}
