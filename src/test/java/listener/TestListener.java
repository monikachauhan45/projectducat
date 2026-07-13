package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.Log;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static final ExtentReports extent= ExtentManager.createInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        Log.info("Test Started: "+result.getMethod().getMethodName());
        extent.flush();
    }
    @Override

    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passes");
        Log.info("Test Passed: " + result.getMethod().getMethodName());
        extent.flush();
    }
      @Override
      public void onTestFailure(ITestResult result){
        Object currentClass = result.getInstance();

        WebDriver driver = ((base.BaseTest) currentClass).getDriver();
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
        test.get().log(Status.FAIL, result.getThrowable());
        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();

        }
        Log.error("Test Failed:" + result.getMethod().getMethodName());
        extent.flush();
    }

    @Override
            public void onTestSkipped(ITestResult result){
          if(test.get()!=null)
          {
              test.get().log(Status.SKIP, "Test skipped");
              extent.flush();
          }
//          @Override
//                  public void onFinish(ITestContext context){
//
//        }
    }
    }

