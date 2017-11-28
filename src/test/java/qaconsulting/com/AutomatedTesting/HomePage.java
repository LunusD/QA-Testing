package qaconsulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")
    WebElement addUserLink;

    public void clickAddUserLink(){
        addUserLink.click();
    }
}
