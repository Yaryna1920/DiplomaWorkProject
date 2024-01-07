package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPage extends BasePage {
    public BookPage(WebDriver driver) {
        super(driver);
    }

    private By buyNowButtonLocator = By.xpath("//div[@class=\"base-product__buying\"]/button[contains(text(), \"Купити зараз\")]");
    private By foundBookLocator = By.xpath("//img[@alt=\"Паперова книга «За Перекопом є земля», автор Анастасія Левкова - фото №1\"]");
 public void verifyUserisAtBookPage() {
     Assert.assertTrue(driver.findElement(foundBookLocator).isDisplayed());
 }
    public CartPage navigateToCart() {
        WebElement element = driver.findElement(buyNowButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new CartPage(driver);

    }
}