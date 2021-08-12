package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;

    @After
    public  void tearDown(Scenario scenario){
        try{
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            if(scenario.isFailed()){
                scenario.log("this is my failure message");
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.close();
    }
}
