import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tools extends BasePage{

    private WebDriverWait wait;

    public void popUpKiller(){
        driver.findElement(popUpClose).click();
    }


    public void selectList(By listLoc, String data){
        Select select = new Select(driver.findElement(listLoc));
        select.selectByValue(data);
    }

    public void modalWaiter(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public List<String> getName(By namesFields){
        List<String> names = new ArrayList<>();
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(namesFields));
        List<WebElement> namesElements = driver.findElements(namesFields);
        for (WebElement textInElement : namesElements){
            String name = textInElement.getText().replace("Name: ","");
            names.add(name);
        }
        return names;
    }

    public void namesWriterToTxt(String file,By list) throws IOException {
        FileWriter writer = new FileWriter(file, false);
        List<WebElement> nameList = driver.findElements(list);
        for (int i =0; i<nameList.size();i++){
            String name = nameList.get(i).getText();
            writer.write(name + "\n");
        }
        writer.close();
    }

    public int txtLinesCounter(String file) throws IOException {
        int textLen = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null) textLen++;
        reader.close();
        return textLen;
    }


    public Tools(WebDriver drv) {
        super(drv);
    }


}
