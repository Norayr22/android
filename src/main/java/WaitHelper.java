import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public static WaitHelper getWait() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }

    public void waitForElementToBeVisible(By location) {
        new WebDriverWait(DriverHelper.get().getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(location));
    }

    public void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverHelper.get().getDriver(), 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

}