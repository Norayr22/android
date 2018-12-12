import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DataProcess extends BasePage {
    String number;

    @FindBy(name = Constants.USERNAME)
    private WebElement username;
    @FindBy(name = Constants.PASSWORD)
    private WebElement password;
    @FindBy(className = Constants.LOGIN)
    private WebElement login;
    @FindBy(xpath = Constants.TASK_NUMBER)
    private WebElement task_number;
    @FindBy(xpath = Constants.TASKS)
    private List<WebElement> tasks;
    @FindBy(xpath = Constants.DATA)
    private WebElement data;
    @FindBy(xpath = Constants.WALL)
    private WebElement wall;
    @FindBy(xpath = Constants.TASK)
    private WebElement task;
    @FindBy(xpath = Constants.ERROR)
    private WebElement error;
    @FindBy(xpath = Constants.FIND)
    private WebElement find;
    @FindBy(xpath = Constants.PAGEINATION)
    private List<WebElement> pagination;

    public DataProcess() throws MalformedURLException {
        super();
        driver.get(getUrl());
    }

    public String getUrl() {
        return "http://wmmail.ru/";
    }


    public void registerNewUser() throws InterruptedException, MalformedURLException, ParseException {
        type(username, "portugal");
        type(password, "france");
        click(login);
        WaitHelper.getWait().waitForElementToBeVisible(task);
        click(task);
        WaitHelper.getWait().waitForElementToBeVisible(find);
        click(find);
        System.out.println(pagination.size());
        for (int p = pagination.size() / 2 - 1; p > 0; p--) {
            WaitHelper.getWait().waitForElementToBeVisible(pagination.get(p));
            click(pagination.get(p));
            for (int i = 0; i <= tasks.size() - 1; i++) {

                getActions().moveToElement(tasks.get(i)).click().perform();
                ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab.get(1));
                refresh();

                try {
                    if (error.isDisplayed()) {
                        driver.close();
                        driver.switchTo().window(tab.get(0));

                    }
                } catch (Exception e) {
                    WaitHelper.getWait().waitForElementToBeVisible(wall);
                    number = task_number.getText();
                    click(wall);
                    driver.close();

                    driver.switchTo().window(tab.get(0));
                    ArrayList<String> tab1 = new ArrayList<String>(driver.getWindowHandles());
                    driver.switchTo().window(tab1.get(1));
                    if(Helper.getDifference(data.getText())>=4){
                    System.out.println(number);}
                    driver.close();
                    driver.switchTo().window(tab1.get(0));
                }
            }


            Thread.sleep(2000);
        }

    }

}