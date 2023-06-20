package pageobjects;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebtablesPage extends BasePage{

  public final static String WEBTABLES_PAGE_URL = "https://demoqa.com/webtables";

  private final By addButton = By.id("addNewRecordButton");
  private final By firstNameInput = By.id("firstName");
  private final By lastNameInput = By.id("lastName");
  private final By userEmailInput = By.id("userEmail");
  private final By ageInput = By.id("age");
  private final By salaryInput = By.id("salary");
  private final By departmentInput = By.id("department");
  private final By submitInput = By.id("submit");
  private final By divRows = By.xpath("//div[@class='rt-table']/div[@class='rt-tbody']/div[@role='rowgroup']/div[@role='row']");
  private final String divEmailCells =
      "//div[@class='rt-table']/div[@class='rt-tbody']/div[@role='rowgroup']/div[@role='row']/div[@role='gridcell'][4][text()='%s']/..";
  private final String editButton = "//span[@title='Edit']";
  private final String divText = "/div[text()]";
  //

  public WebtablesPage(WebDriver driver) {
    super(driver);
    driver.get(WEBTABLES_PAGE_URL);
  }

  @Step("Click Add button")
  public WebtablesPage getNewUserForm(){
    getElement(addButton).click();
    return this;
  }

  @Step("Fill out user form [{0}, {1}, {2}, {3}, {4}, {5}]")
  public WebtablesPage fillOutUserForm(String firstName, String lastName, String userEmail,
      String age, String salary, String department){
    getElement(firstNameInput).sendKeys(firstName);
    getElement(lastNameInput).sendKeys(lastName);
    getElement(userEmailInput).sendKeys(userEmail);
    getElement(ageInput).sendKeys(age);
    getElement(salaryInput).sendKeys(salary);
    getElement(departmentInput).sendKeys(department);
    return this;
  }

  @Step("Click Add button")
  public WebtablesPage submitUserForm(){
    getElement(submitInput).click();
    return this;
  }

  @Step("Get all users")
  public List<WebElement> getUsers(){
    return getElements(divRows);
  }

  @Step("Get user by email: {userEmail}")
  public List<WebElement> getUserByEmail(String userEmail){
    return driver.findElements(By.xpath(String.format(divEmailCells,userEmail)));
  }

  @Step("Click Edit user button")
  public WebtablesPage getUserForEdit(String userEmail){
    getElement(By.xpath(String.format(divEmailCells + editButton,userEmail))).click();
    return this;
  }

  @Step("Get user data by email: {userEmail}")
  public List<WebElement> getUserDataByEmail(String userEmail){
    return getElements(By.xpath(String.format(divEmailCells + divText,userEmail)));
  }


}
