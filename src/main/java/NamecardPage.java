import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NamecardPage extends BasePage{

    final By cardNamesFields = By.xpath("//div[@class=\"row\"]//h4");
    public NamecardPage(WebDriver drv) {
        super(drv);
    }
}
