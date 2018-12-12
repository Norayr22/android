
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected WebDriver driver;

    public BasePage() throws MalformedURLException {

        this.driver = DriverHelper.get().getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        if (!driver.getCurrentUrl().equals(getUrl())) {
            throw new Error (getUrl() +" is not loaded");
        }
    }

    public abstract String getUrl();

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(By location, String text) {
        type(find(location), text);
    }

    public void type(String cssSelector, String text) {
        type(By.cssSelector(cssSelector), text);
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }

    public List<WebElement> findElemetns(By location) {
        return driver.findElements(location);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(By location) {
        click(find(location));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Actions getActions() {
        return new Actions(driver);
    }

    public void refresh() {
        if (driver.getTitle().equals("502 Bad Gateway")) {
            driver.navigate().refresh();
        }
    }
}