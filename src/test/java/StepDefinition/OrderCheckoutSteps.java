package StepDefinition;

import Pages.BookPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.OrderPayPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrderCheckoutSteps {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\iryna.antonian\\IdeaProjects\\TestFramework\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User is at Home page")
    public void user_is_at_home_page() {
        driver.get("https://www.yakaboo.ua");
    }

    @When("User searches for \"За перекопом є земля\" book")
    public void user_searches_for_book() {
        HomePage homePage = new HomePage(driver);
        homePage.closeBanner();
        homePage.findRequiredBook("За перекопом є земля");
    }

    @And("User is redirected to Book page")
    public void user_is_redirected_to_book_page() {
        BookPage bookPage = new BookPage(driver);
        bookPage.verifyUserisAtBookPage();
    }

    @And("And User adds \"За перекопом є земля\" book to cart")
    public void and_user_adds_book_to_cart() {
        BookPage bookPage = new BookPage(driver);
        bookPage.navigateToCart();

    }

    @And("User is redirected to Cart page")
    public void user_is_redirected_to_cart_page() {
        CartPage cartPage = new CartPage(driver);
        cartPage.validateUserIsAtCartPage();
    }

    @And("User fills out required fields")
    public void user_fills_out_required_fields() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        cartPage.enterUserData
                ("Test name", "Test surname", "0666666666", "test@test.com", "Луцьк");
    }

    @And("User checks the delivery method")
    public void user_checks_the_delivery_method() {
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyDeliveryMethod("Відділення Нова Пошта (безкоштовно від 800 грн)\n" +
                "60 грн");
    }

    @And("User selects the delivery unit")
    public void user_selects_the_delivery_unit() {
        CartPage cartPage = new CartPage(driver);
        cartPage.selectDeliveryUnit();
    }

    @And("User clicks on Pay order button")
    public void user_clicks_on_button() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOrderPaymentButton();
    }

    @Then("User is redirected to Order Payment page")
    public void user_is_redirected_to_order_payment_page() {
        OrderPayPage orderPayPage = new OrderPayPage(driver);
        orderPayPage.validateOrderCheckOut();
    }
}