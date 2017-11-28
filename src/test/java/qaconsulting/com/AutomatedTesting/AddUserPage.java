package qaconsulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {

    @FindBy(name = "username")
    WebElement usernameTextField;

    @FindBy(name = "password")
    WebElement passwordTextField;

    @FindBy(name = "FormsButton2")
    WebElement saveUser;

    @FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
    WebElement loginLink;

    public void setUsernameTextfield(String username){
        usernameTextField.sendKeys(username);
    }

    public void setPasswordTextField(String password){
        passwordTextField.sendKeys(password);
    }

    public void clickSaveUser(){
        saveUser.click();
    }

    public void clickLoginLink(){
        loginLink.click();
    }
}
