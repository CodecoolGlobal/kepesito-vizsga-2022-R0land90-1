import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static BasePage Create(String name, WebDriver driver){
        switch (name){
            case "Tools":
                return new Tools(driver);
            case "TestInputPage":
                return new TestInputPage(driver);
            case "SelectDayPage":
                return new SelectDayPage(driver);
            case "AlertPage":
                return new AlertPage(driver);
            case "NamecardPage":
                return new NamecardPage(driver);
            case "TablePage":
                return new TablePage(driver);
            default:
                return null;
        }
    }
}
