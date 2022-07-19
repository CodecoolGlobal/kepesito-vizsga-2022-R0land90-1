import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectDayPage extends BasePage{

    final By selectList = By.id("select-demo");
    final By selectResult = By.className("selected-value");
    public SelectDayPage(WebDriver drv) {
        super(drv);
    }
}
