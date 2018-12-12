import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class test {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setPlatform(Platform.WINDOWS);

        URL url = new URL("http://localhost:4441/wd/hub");

        WebDriver driver = new RemoteWebDriver(url, caps);

        driver.get("http://learn-automation.com");
        String title = driver.getTitle();
        System.out.println(title);

        //start node

        // java -jar C:\Users\norayr.sargsyan\Downloads\selenium-server-standalone-2.53.0.jar -role node -hub http://10.18.3.125:4441/grid/register/
        // -Dwebdriver.chrome.driver=C:\Users\norayr.sargsyan\Downloads\chromedriver_win32\chromedriver.exe

        //start grid

//        java -jar C:\Users\norayr.sargsyan\Downloads\selenium-server-standalone-2.53.0.jar -role hub -port 4441
    }
    @Test
    public void test1() throws MalformedURLException {

//        WebDriver driver = new HtmlUnitDriver();



}
}