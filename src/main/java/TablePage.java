import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage extends BasePage{

    final By listNames = By.xpath("//*[@id='example']//td[1]");
    public TablePage(WebDriver drv) {
        super(drv);
    }
}
