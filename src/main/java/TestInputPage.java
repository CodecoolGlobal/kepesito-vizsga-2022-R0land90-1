import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestInputPage extends BasePage{

    final By inputBoxA = By.id("sum1");
    final By inputBoxB = By.id("sum2");
    final By button2 = By.xpath("//*[@id=\"gettotal\"]/button");
    final By result1task = By.id("displayvalue");

    public TestInputPage(WebDriver drv) {
        super(drv);
    }
}
