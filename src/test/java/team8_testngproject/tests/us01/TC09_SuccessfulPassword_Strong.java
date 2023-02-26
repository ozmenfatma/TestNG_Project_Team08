package team8_testngproject.tests.us01;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

import static team8_testngproject.utilities.Driver.driver;
import static team8_testngproject.utilities.ReusableMethods.waitFor;

public class TC09_SuccessfulPassword_Strong {
    private final String testName = "US01 || TC09-Strong Password Messaji ";
    private final String description = "Strong mesaji alininca kayid islemi basarilidir";
    private final String raporMesaji = "Kullanıcı password alani altinda 'Strong' mesaji'ni gorur,  ve kayid islami basarilidir";

    @Test (testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void successfulRegistration_StrongPassward() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
    Driver.getDriver().get("https://hubcomfy.com/my-account-2/");
        Faker faker = new Faker();

     P01_HomePage homePage = new P01_HomePage();
    ReusableMethods.jsClick(homePage.myAccountButton);
        extentTest.info("Home page sayfasindan My Account sayfasina gidilir");

    P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
    myAccountPage.myAccountSiginUpOnPopup.click();
    myAccountPage.myAccountUserNameReg.sendKeys(faker.name().username());
    myAccountPage.myAccountUserEmailReg.sendKeys(faker.internet().emailAddress());
    myAccountPage.myAccountPasswordReg.sendKeys(ConfigReader.getProperty("generatedPassword5"));
    myAccountPage.myAccountPolicyCheckReg.click();
    extentTest.info("Kullanici password alani altinda 'Strong' mesajini gormustur ve  kayit isleminde basarmistir");

    Assert.assertTrue(myAccountPage.notification_Strong.isDisplayed());

   Actions actions = new Actions(driver);
    actions.doubleClick(myAccountPage.myAccountSiginUpOnPopup);

    waitFor(3);
    Driver.closeDriver();
    RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}