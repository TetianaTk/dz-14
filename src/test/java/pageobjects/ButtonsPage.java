package pageobjects;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsPage extends BasePage{

  public final static String BUTTONS_PAGE_URL = "https://demoqa.com/buttons";

  private final By clickMeButton = By.xpath("//div/button[text()='Click Me']");

  private final By clickMessages = By.xpath("//div/button[text()='Click Me']/../../p");

  public ButtonsPage(WebDriver driver) {
    super(driver);
  }

  @Step("Button 'Click Me' is clicked")
  public ButtonsPage clickMeButtonAction(){
    getElement(clickMeButton).click();
    return this;
  }

  @Step("Getting message list")
  public List<WebElement> getMessages(){
    return driver.findElements(clickMessages);
  }



}
