package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By orderCheckOutTitleLocator = By.xpath("//h2[contains(text(), \"Оформлення замовлення\")]");
    private By namePlaceholderLocator = By.xpath("//input[@placeholder=\"Введіть ваше ім'я\"]");
    private By surnamePlaceholsderLocator = By.xpath("//input[@placeholder=\"Введіть ваше прізвище\"]");
    private By phonePlaceholderLocator = By.xpath("//input[@type=\"tel\"]");
    private By emailPlaceholderLocator = By.xpath("//input[@placeholder=\"Введіть ваш email\"]");
    private By cityPlaceholderLocator = By.xpath("//input[@placeholder=\"Введіть назву міста...\"]");
    private By selectedCityLocator = By.xpath("//*[@id=\"viewport\"]/div[8]/div/div[1]/section[2]/div[1]/div[2]/div/div[2]/div[2]/div/div/ul/li[1]");
    private By deliveryMethodPlaceholderLocator = By.xpath("//div[@class=\"delivery-method selected\"]/div[@class=\"with-slot\"]");
    private By unitAddressLocator = By.xpath("//input[@placeholder=\"Адреса відділення\"]");
    private By selectedDeliveryUnit = By.xpath("//div[contains(text(), \"Відділення №24 (до 30 кг): просп. Грушевського Президента, 3\")]");
    private By payOrderButtonLocator = By.xpath("//*[@id=\"viewport\"]/div[8]/div/div[1]/section[4]/div/div[6]/button");

    public void validateUserIsAtCartPage() {
        Assert.assertTrue(driver.findElement(orderCheckOutTitleLocator).isDisplayed());
    }

    public void enterUserData(String name, String surname, String phone, String email, String city) throws InterruptedException {
        driver.findElement(namePlaceholderLocator).sendKeys(name);
        driver.findElement(surnamePlaceholsderLocator).sendKeys(surname);
        driver.findElement(phonePlaceholderLocator).sendKeys(phone);
        driver.findElement(emailPlaceholderLocator).sendKeys(email);
        driver.findElement(cityPlaceholderLocator).click();
        driver.findElement(cityPlaceholderLocator).sendKeys(city);
        Thread.sleep(1000);
        webDriverWait.until(visibilityOfElementLocated(selectedCityLocator));
        WebElement element = driver.findElement(selectedCityLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void verifyDeliveryMethod(String expectedValue) {
        webDriverWait.until(visibilityOfElementLocated(deliveryMethodPlaceholderLocator));
        Assert.assertEquals(expectedValue, driver.findElement(deliveryMethodPlaceholderLocator).getText());
    }

    public void selectDeliveryUnit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        driver.findElement(unitAddressLocator).click();
        webDriverWait.until(visibilityOfElementLocated(selectedDeliveryUnit));
        WebElement element = driver.findElement(selectedDeliveryUnit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public OrderPayPage clickOrderPaymentButton() {
        WebElement element = driver.findElement(payOrderButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new OrderPayPage(driver);
    }
}
