import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.text.ParseException;


public class GetData {


    @Test()
    public void startRegisterTest() throws InterruptedException, MalformedURLException, ParseException {
        DataProcess register = new DataProcess();
        register.registerNewUser();

    }

}