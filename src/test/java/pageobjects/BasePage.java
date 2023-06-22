package pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private final static int DURATION_TO_WAIT_DEFAULT = 10;

  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getElement(By by, int waitForSeconds){
    return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
        .until(ExpectedConditions.presenceOfElementLocated(by));
  }

  public WebElement getElement(By by){
    return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
        .until(ExpectedConditions.presenceOfElementLocated(by));
  }

  public List<WebElement> getElements(By by, int waitForSeconds){
    return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
  }

  public List<WebElement> getElements(By by){
    return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
  }

}
