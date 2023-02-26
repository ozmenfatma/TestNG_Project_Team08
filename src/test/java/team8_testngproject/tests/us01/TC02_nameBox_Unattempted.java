package team8_testngproject.tests.us01;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

import static team8_testngproject.utilities.ReusableMethods.waitFor;

public class TC02_nameBox_Unattempted {
 private final String testName = "US01 || TC02-Username girmediginde ";
 private final String description = "Username girilmediginde kayid islemi olmamali";
 private final String raporMesaji = "Kullanıcı kayıd olamamalı";

 @Test  (testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
 public void RegistrationUnsuccessful_NameUnspecified()  {
  ExtentTest extentTest = RaporlamaUtil.extentTest;
  Driver.getDriver().get(ConfigReader.getProperty("URL"));
  Faker faker = new Faker();
  P01_HomePage homePage = new P01_HomePage();
  homePage.userRegisterButton.click();
  extentTest.info("Home page'den Register sayfasina gidildi.");

  P02_RegisterPage registerPage = new P02_RegisterPage();
  registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
  registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword"));
  registerPage.policyAgreementBox.click();
  registerPage.userSignUpButton.click();
  extentTest.info("Isim alani bos birakildiginda, SignUp işlemi yapılmamali.");

 Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());
 waitFor(3);
Driver.closeDriver();
  RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
}
}







