package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class OrderPayPage extends BasePage {
    public OrderPayPage(WebDriver driver) {
        super(driver);
    }

    private By cardPayLocator = By.xpath("//div[contains(text(), \"Карткою\")]");

    public void validateOrderCheckOut() {
        webDriverWait.until(visibilityOfElementLocated(cardPayLocator));
        Assert.assertTrue(driver.findElement(cardPayLocator).isDisplayed());
    }
}
