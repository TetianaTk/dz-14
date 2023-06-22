/*
Використовуючи Selenium WebDriver:

Написати тест, який відкриває сторінку https://demoqa.com/elements, натискає на Buttons,
клікає кнопку Click Me, рахує і виводить в консоль текст повідомлення.

Написати тест, який відкриває сторінку https://demoqa.com/webtables, натискає кнопку ADD,
заповнює форму додавання, перевіряє, що запис додався, редагує запис через функцію редагування.
 */
package webtest;

import io.qameta.allure.Description;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.ButtonsPage;
import pageobjects.ElementsPage;
import pageobjects.WebtablesPage;

public class UITest extends BaseTest{

  @Test
  @Description("Test Click Me Message")
  public void buttonClickMeTest(){
    SoftAssert softAssert = new SoftAssert();
    List<WebElement> messages =
        new ElementsPage(driver)
            .getButtonsPage()
            .clickMeButtonAction()
            .getMessages();

    softAssert.assertEquals(driver.getCurrentUrl(), ButtonsPage.BUTTONS_PAGE_URL,
        "Buttons page isn't accessible");
    softAssert.assertEquals(messages.size(), 1,
        "It was clicked another button before");

    System.out.println(
        messages.stream()
            .map(message -> message.getText())
            .collect(Collectors.joining("\n")));

    softAssert.assertAll();
  }

  @Test(dataProviderClass = UserInfoDataProvider.class, dataProvider = "generate person")
  @Description("Test add/edit user")
  public void userOperationsTest(String firstName, String lastName, String userEmail,
      String age, String salary, String department){
    SoftAssert softAssert = new SoftAssert();
    driver.manage().window().maximize();
    WebtablesPage webtablesPage = new WebtablesPage(driver);
    webtablesPage.getNewUserForm()
        .fillOutUserForm(firstName, lastName, userEmail, age, salary, department)
        .submitUserForm();
    List<WebElement> webElements = webtablesPage.getUserByEmail(userEmail);
    softAssert.assertEquals(webElements.size(), 1, "Cannot add user");
    String editPrefix = "_edited";
    webtablesPage.getUserForEdit(userEmail)
        .fillOutUserForm(editPrefix, editPrefix, "", "", "", "")
        .submitUserForm();
    webElements = webtablesPage.getUserDataByEmail(userEmail);
    softAssert.assertEquals(webElements.get(0).getText(), firstName+editPrefix, "Edit user failure");
    softAssert.assertAll();
  }


  }
