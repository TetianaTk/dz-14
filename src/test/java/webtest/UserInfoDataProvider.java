package webtest;

import org.testng.annotations.DataProvider;

public class UserInfoDataProvider {

  @DataProvider(name = "generate person")
  public Object[][] generatePerson(){
    return new Object[][] {
        { "Robert", "Plant", "Robert.Plant@zeppelin.led", "70", "1000000", "vocal"},
    };
  }

}
