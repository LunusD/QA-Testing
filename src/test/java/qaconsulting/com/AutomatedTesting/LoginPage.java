package qaconsulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "username")
    WebElement usernameTextField;

    @FindBy(name = "password")
    WebElement passwordTextField;

    @FindBy(name = "FormsButton2")
    WebElement loginButton;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
    WebElement loginMessage;

    public void setUsernameTextField(String username){
        usernameTextField.sendKeys(username);
    }

    public void setPasswordTextField(String password){
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getLoginMessage(){
        String message = loginMessage.getText();
        return message;
    }
}
