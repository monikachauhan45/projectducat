package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void testValidLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");

        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Login failed or wrong page");

    }



}
