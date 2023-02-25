package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P16_VendorStoreManagerPage {
    public P16_VendorStoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }








    // 20.Satır --> Ali





























    // 50.Satır --> Esra





























    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/products/']") public WebElement productButtonGur;
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/products-manage/']") public WebElement productAddNewButtonGur;
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/coupons/']") public WebElement couponsButtonGur;
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/coupons-manage/']") public WebElement couponsAddNewButtonGur;

























    // 140.Satır --> Hüseyin
@FindBy(xpath = "//a[.='Store Manager']") public WebElement storeManagerButtonHus;
@FindBy(xpath = "//h2[.='Store Manager']") public  WebElement storeManagerTextHus;
@FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/products/']") public  WebElement productsButtonHus;





























    // 170.Satır --> Mehmet
    @FindBy(xpath = "//a[.='Store Manager']") public WebElement storeManagerButtonKoz;
    @FindBy(xpath = "//h2[.='Store Manager']") public  WebElement storeManagerTextKoz;
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/products/']") public WebElement productsButtonKoz;
























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/products/']") public WebElement productButtonRs;
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/store-manager/products-manage/']") public WebElement productAddNewButtonRs;


























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa





























}

