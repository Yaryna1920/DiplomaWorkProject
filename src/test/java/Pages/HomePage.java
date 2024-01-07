package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage {

    private By bookSearchLocator = By.xpath("//input[@placeholder=\"Знайти книгу\"]");
    private By selectedBookLocator = By.xpath("//div[contains(text(), \"Анастасія Левкова\")]");
    private By closeBannerLocator = By.xpath("/html/body/div[6]/div/div[1]/img");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closeBanner() {
        webDriverWait.until(elementToBeClickable(driver.findElement(closeBannerLocator)));
        driver.findElement(closeBannerLocator).click();
    }

    public BookPage findRequiredBook(String bookName) {
        webDriverWait.until(elementToBeClickable(driver.findElement(bookSearchLocator)));
        driver.findElement(bookSearchLocator).sendKeys(bookName);
        webDriverWait.until(elementToBeClickable(driver.findElement(selectedBookLocator)));
        driver.findElement(selectedBookLocator).click();
        return new BookPage(driver);
    }
}
