package webtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected WebDriver driver;

  @BeforeClass
  public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  //@AfterClass
  public void close(){
    driver.close();
    driver.quit();
  }


}
