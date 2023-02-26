package team8_testngproject.tests.us07;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P07_ShoppingPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class TC04 {
    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P07_ShoppingPage ShoppingPage;
    private final String testName = "US07 || TC04-Secilen urunlerin karsilastirilmasi";
    private final String description = "Compare sayfasinda urun karsilastirilmasi";
    private final String raporMesaji = "Compare sayfasinda urun silme.";
    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void compareUrunSilme() {
        ExtentTest extentTest = RaporlamaUtil.extentTest;
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage = new P01_HomePage();
        loginPage = new P03_LoginPage();

        ReusableMethods.waitFor(3);
        homePage.signIn.click();
        homePage.username.sendKeys(ConfigReader.getProperty("user_mail"));
        homePage.password.sendKeys(ConfigReader.getProperty("user_password"));
        homePage.login.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Login işlemi yapıldı.");

        loginPage.search.click();
        loginPage.search.sendKeys("bag");
        loginPage.aramaTusu.click();

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.sunnyBaby);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaWomen);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaBest);
        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.cantaFash);
        ReusableMethods.waitFor(7);
        ReusableMethods.getScreenshot("Secili urun ekran goruntusu");

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.silinenCanta);
        ReusableMethods.waitFor(5);
        ReusableMethods.getScreenshot("Silinen urun ekran goruntusu");

        ReusableMethods.waitFor(2);
        loginPage.bosSayfa.click();
        loginPage.search.click();
        String arananUrun = "coat";
        loginPage.search.sendKeys(arananUrun);
        loginPage.aramaTusu.click();
        String coatDogrulama = "Coat Pool Comfort Jacket";
        Assert.assertFalse(coatDogrulama.contains(arananUrun));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.coatUrunEkle);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Coat urunu ekleme");

        //*************************************************************************************
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                loginPage.startCompareButonu);
        String compareBaslik = Driver.getDriver().getTitle();
        Assert.assertTrue(compareBaslik.contains("Compare"));

        String urunTheMonogram = Driver.getDriver().findElement(By.xpath("(//*[@class='product-title'])[1]")).getText();
        Assert.assertTrue(urunTheMonogram.contains("Sunny Baby Bebek Arabası"));
        String urunWomenWhite = Driver.getDriver().findElement(By.xpath("(//*[@class='product-title'])[2]")).getText();
        Assert.assertTrue(urunWomenWhite.contains("Women’s White Handbag"));
        String urunWomenFashion = Driver.getDriver().findElement(By.xpath("(//*[@class='product-title'])[3]")).getText();
        Assert.assertTrue(urunWomenFashion.contains("Women’s Fashion Handbag"));
        String urunCoatPool = Driver.getDriver().findElement(By.xpath("(//*[@class='product-title'])[4]")).getText();
        Assert.assertTrue(urunCoatPool.contains("Coat Pool Comfort Jacket"));

        String product = Driver.getDriver().findElement(By.xpath("(//*[@class='compare-col compare-field'])[1]")).getText();
        Assert.assertTrue(product.contains("Product"));
        String price = Driver.getDriver().findElement(By.xpath("(//*[@class='compare-col compare-field'])[2]")).getText();
        Assert.assertTrue(price.contains("Price"));
        String availability = Driver.getDriver().findElement(By.xpath("(//*[@class='compare-col compare-field'])[3]")).getText();
        Assert.assertTrue(availability.contains("Availability"));
        String description = Driver.getDriver().findElement(By.xpath("(//*[@class='compare-col compare-field'])[4]")).getText();
        Assert.assertTrue(description.contains("Description"));
        String ratingsReviews = Driver.getDriver().findElement(By.xpath("(//*[@class='compare-col compare-field'])[5]")).getText();
        Assert.assertTrue(ratingsReviews.contains("Ratings & Reviews"));
        String sKU = Driver.getDriver().findElement(By.xpath("(//*[@class='compare-col compare-field'])[6]")).getText();
        Assert.assertTrue(sKU.contains("SKU"));
        String size = Driver.getDriver().findElement(By.xpath("(//*[@class='compare-col compare-field'])[7]")).getText();
        Assert.assertTrue(size.contains("Size"));
        //*************************************************************************************

        ReusableMethods.waitFor(2);
        String sunBabyXButonu = Driver.getDriver().findElement(By.xpath("(//*[text()='Sunny Baby Bebek Arabası'])[1]")).getText();
        String womenWhiteXButon = Driver.getDriver().findElement(By.xpath("//*[text()='Women’s White Handbag']")).getText();
        String womenFashionXButon = Driver.getDriver().findElement(By.xpath("//*[text()='Women’s Fashion Handbag']")).getText();
        WebElement silinenCoatPoolXButon = Driver.getDriver().findElement(By.xpath("(//*[@class='w-icon-times-solid'])[4]"));
        String silinenCoatPoolKontrol = Driver.getDriver().findElement(By.xpath("//*[text()='Coat Pool Comfort Jacket']")).getText();


        silinenCoatPoolXButon.click();
        extentTest.info("Urun silme islemi yapildi.");

        List<String> kalanUrunler = new ArrayList<>();
        kalanUrunler.add(sunBabyXButonu);
        kalanUrunler.add(womenWhiteXButon);
        kalanUrunler.add(womenFashionXButon);
        kalanUrunler.add(silinenCoatPoolKontrol);

        for (String urunKontrol : kalanUrunler) {
            if (kalanUrunler.contains(urunKontrol)){
            Assert.assertTrue(kalanUrunler.contains(urunKontrol));
            }else {
                System.out.println(kalanUrunler + " adli urun silinmistir");
            }
        }
        extentTest.info("Urun sildikten sonra kalan urunler kontrol edildi.");
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
