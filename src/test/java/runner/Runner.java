package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//features",
                plugin = {"pretty","html:tagert/report.html"},
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                glue = {"steps"},
                tags = "not @ignore",
                dryRun = false)

public class Runner {

    @BeforeClass
    public static void resetBanco(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("mi@m");
        driver.findElement(By.id("senha")).sendKeys("mi");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
