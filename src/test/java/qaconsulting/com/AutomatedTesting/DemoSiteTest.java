package qaconsulting.com.AutomatedTesting;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
//import static qaconsulting.com.AutomatedTesting.ScreenShot.take;

public class DemoSiteTest {

    private static ExtentReports report;
    private String url = "http://www.thedemosite.co.uk";
    private WebDriver webDriver;

    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setup(){
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void destroy(){
        report.flush();
    }

    @Test
    public void demoSiteTest() {
        String currentUrl;
        String expectedUrl;
        ExtentTest test = report.createTest("demosite.co.uk Test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\AutomatedTesting\\chromedriver.exe");

        test.log(Status.INFO, "Test begin. Opening website.");
        test.log(Status.DEBUG, "webDriver opening Chrome with url http://demosite.co.uk/");
        webDriver.navigate().to(url);
        test.log(Status.INFO, "Open.");
        String username = "GoldenGod";
        String password = "password";


        test.log(Status.INFO, "Navigating between home page and the user registration page");
        test.log(Status.DEBUG, "Finding hyperlink element to \"3.Add a User\" on the home page, using the FindElement(By.cssSelector()) method, with the css of" +
                " \"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)\"");
        HomePage homepage = PageFactory.initElements(webDriver, HomePage.class);
        homepage.clickAddUserLink();
        currentUrl = webDriver.getCurrentUrl();
        expectedUrl = "http://www.thedemosite.co.uk/addauser.php";
        try {
            assertEquals("Unexpected URL", expectedUrl, currentUrl);
            test.log(Status.INFO, "Navigation successful.");
        } catch (AssertionError ae) {
            test.log(Status.ERROR, "Unexpected Url. Expected Url was:" + expectedUrl + " | Current Url is: " + currentUrl);

            try {
                String filePath = ScreenShot.take(webDriver, "navigationError");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            throw ae;
        }


        AddUserPage registerPage = PageFactory.initElements(webDriver, AddUserPage.class);

        test.log(Status.INFO, "Entering username and password into the text boxes, then registering the user.");
        test.log(Status.DEBUG, "Entering username: " + username + " and password: " + password + " into their respective text field boxes. The field boxes are found using the" +
                "FindElement(By.name()) method, with the names of \"username\" and \"password\" respectively. Then clicking the add user button found with the FindElement(By.name()) method with the name" +
                "value of \"FormsButton2\"");
        if (username.length() >= 4) {
            registerPage.setUsernameTextfield(username);
            test.log(Status.INFO, "Username entered successfully.");
        } else {
            test.log(Status.FATAL, "Username is invalid (Too short). Please provide a valid username. (Over 4 characters in length)");
            try {
                String filePath = ScreenShot.take(webDriver, "usernameError");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        if (password.length() >= 4) {
            registerPage.setPasswordTextField(password);
            test.log(Status.INFO, "Password entered successfully");
        } else {
            test.log(Status.FATAL, "Password is invalid (Too Short). Please provide a valid password. (Over 4 characters in length)");
            try {
                String filePath = ScreenShot.take(webDriver, "passwordError");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        registerPage.clickSaveUser();
        test.log(Status.INFO, "Navigating to the login page from the register user page");
        test.log(Status.DEBUG, "Finding hyperlink element to \"4. Login\" on the Add User page, using the FindElement(By.cssSelector()) method, with the css of" +
                " \"body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)\"");
        registerPage.clickLoginLink();
        currentUrl = webDriver.getCurrentUrl();
        expectedUrl = "http://www.thedemosite.co.uk/login.php";
        try {
            assertEquals("Unexpected Url", expectedUrl, currentUrl);
            test.log(Status.INFO, "Navigation successful.");
        } catch (AssertionError ae) {
            test.log(Status.ERROR, "Unexpected Url. Expected Url was:" + expectedUrl + " | Current Url is: " + currentUrl);
            try {
                String filePath = ScreenShot.take(webDriver, "navigationError");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            throw ae;
        }

        test.log(Status.INFO, "Entering login details to the website");
        test.log(Status.DEBUG, "Entering username: " + username + " and password: " + password + " into their respective text field boxes. The field boxes are found using the" +
                "FindElement(By.name()) method, with the names of \"username\" and \"password\" respectively. Then clicking the test login found with the FindElement(By.name()) method with the name" +
                "value of \"FormsButton2\"");
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
        if (username.length() >= 4) {
            loginPage.setUsernameTextField(username);
            test.log(Status.INFO, "Username entered successfully");
        } else {
            test.log(Status.FATAL, "Username is invalid (Too Short). Please provide a valid username. (Over 4 characters in length.");
            try {
                String filePath = ScreenShot.take(webDriver, "usernameError");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        if (password.length() >= 4) {
            loginPage.setPasswordTextField(password);
            test.log(Status.INFO, "Password entered successfully");
        } else {
            test.log(Status.FATAL, "Password is invalid (Too Short). Please provide a valid password. (Over 4 characters in length.");
            try {
                String filePath = ScreenShot.take(webDriver, "passwordError");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        loginPage.clickLoginButton();

        String returnedLoginStatus = loginPage.getLoginMessage();
        String expectedMessage = "**Successful Login**";

        try {
            assertEquals("That is not the expected URL", expectedMessage, returnedLoginStatus);
            test.log(Status.PASS, "Test completed. PASS");
            try {
                String filePath = ScreenShot.take(webDriver, "passedTest");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (AssertionError ae) {
            test.log(Status.FAIL, "Test completed. FAIL. Login failed with current username and password");
            try {
                String filePath = ScreenShot.take(webDriver, "failedTest");
                test.addScreenCaptureFromPath(filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            throw ae;
        }
    }
}
