package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePage{

  public final static String ELEMENTS_PAGE_URL = "https://demoqa.com/elements";

  private final By buttonsButton = By.cssSelector("#item-4");

  public ElementsPage(WebDriver driver) {
    super(driver);
    driver.get(ELEMENTS_PAGE_URL);
  }

  @Step("Element Buttons is clicked")
  public ButtonsPage getButtonsPage(){
    getElement(buttonsButton).click();
    return new ButtonsPage(driver);
  }

}
