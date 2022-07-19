import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;
    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("−−incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void evidenceKiller(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban két beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    @Epic("Kepesito vizsga 2022 - Balog Crisan Roland")
    @Feature("TestInput")
    @DisplayName("TC01")
    @Severity(SeverityLevel.CRITICAL)
    public void TestInput()
    {
            //PAGEFACTORY
        TestInputPage testInputPage = (TestInputPage) PageFactory.Create("TestInputPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
            //TEST
        String testData1 = "13";
        String testData2 = "15";
        driver.navigate().to("https://demo.seleniumeasy.com/basic-first-form-demo.html");
        tools.popUpKiller();
        driver.findElement(testInputPage.inputBoxA).sendKeys(testData1);
        driver.findElement(testInputPage.inputBoxB).sendKeys(testData2);
        driver.findElement(testInputPage.button2).click();
            //ASSERT
        WebElement result = driver.findElement(testInputPage.result1task);
        Assertions.assertEquals("28",result.getText());
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: zhttps://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    @Epic("Kepesito vizsga 2022 - Balog Crisan Roland")
    @Feature("SelectDayTest")
    @DisplayName("TC02")
    @Severity(SeverityLevel.NORMAL)
    public void SelectDayTest()
    {
            //PAGEFACTORY
        SelectDayPage selectDayPage = (SelectDayPage) PageFactory.Create("SelectDayPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
            //TEST
        String data1 = "Sunday";
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        tools.selectList(selectDayPage.selectList,data1);
            //ASSERT
        String result = driver.findElement(selectDayPage.selectResult).getText().replace("Day selected :- ", "");
        String expected = "Sunday";
        Assertions.assertEquals(expected,result);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    @Epic("Kepesito vizsga 2022 - Balog Crisan Roland")
    @Feature("AlertTest")
    @DisplayName("TC03")
    @Severity(SeverityLevel.TRIVIAL)
    public void AlertTest()
    {
            //PAGEFACTORY
        AlertPage alertPage = (AlertPage) PageFactory.Create("AlertPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
            //TEST
        driver.navigate().to("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
        driver.findElement(alertPage.modalButton).click();
        tools.modalWaiter(alertPage.modalElement);
        String result = driver.findElement(alertPage.modalText).getText();
        driver.findElement(alertPage.modalCloseButton1).click();
            //ASSERT
        String expected = "This is the place where the content for the modal dialog displays";
        Assertions.assertEquals(expected,result);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Test
    @Epic("Kepesito vizsga 2022 - Balog Crisan Roland")
    @Feature("NamecardTest")
    @DisplayName("TC04")
    @Severity(SeverityLevel.CRITICAL)
    public void NamecardTest()
    {
            //PAGEFACTORY
        NamecardPage namecardPage = (NamecardPage) PageFactory.Create("NamecardPage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
            //TEST
        driver.navigate().to("https://demo.seleniumeasy.com/data-list-filter-demo.html");
        List<String> result = tools.getName(namecardPage.cardNamesFields);
        List<String> expect = new ArrayList<>();
        expect.add("Tyreese Burn");
        expect.add("Brenda Tree");
        expect.add("Glenn Pho shizzle");
        expect.add("Brian Hoyies");
        expect.add("Glenn Pho shizzle");
        expect.add("Arman Cheyia");
            //ASSERT
        Assertions.assertEquals(expect,result);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz. Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    @Test
    @Epic("Kepesito vizsga 2022 - Balog Crisan Roland")
    @Feature("TableTest")
    @DisplayName("TC05")
    @Severity(SeverityLevel.NORMAL)
    public void TableTest() throws IOException {
            //PAGEFACTORY
        TablePage tablePage = (TablePage) PageFactory.Create("TablePage",driver);
        Tools tools = (Tools) PageFactory.Create("Tools",driver);
            //TEST
        driver.navigate().to("https://demo.seleniumeasy.com/table-data-download-demo.html");
        tools.namesWriterToTxt("names.txt",tablePage.listNames);
        int result = tools.txtLinesCounter("names.txt");
            //ASSERT
        Assertions.assertEquals(31,result);
    }
}
