import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage{

    final By modalButton = By.xpath("//a[@href='#myModal0']");
    final By modalText = By.xpath("//*[@id=\"myModal0\"]//div[3]");
    final By modalElement = By.xpath("//*[@class='modal fade in']");
    final By modalCloseButton1 = By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[1]");
    public AlertPage(WebDriver drv) {
        super(drv);
    }
}
