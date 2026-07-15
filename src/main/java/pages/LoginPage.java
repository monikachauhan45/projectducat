package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class LoginPage {
 private final WebDriver driver;
    @FindBy(name="username")
    WebElement userInput;
    @FindBy(name="password")
    WebElement passwordInput;
    @FindBy(xpath ="//button[normalize-space()='Login']")
    WebElement loginbtn;
    @FindBy(xpath="")
    WebElement link;
//testing2
    public LoginPage(WebDriver driver)
    {

        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
       Log.info("entering the login username");

       userInput.clear();
       userInput.sendKeys(username);

    }
    public void enterPassword(String password)
    {
        Log.info("entering the login password");
        passwordInput.clear();
        passwordInput.sendKeys(password);

    }
    public void clickLogin(){
        Log.info("clicking on login button");
        loginbtn.click();

    }
    public void loginAs(String username, String password)
    {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }




}
