import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTracking implements ITestListener {

    private static final ExtentReports extent = ExtentManager.createInstance("report.html");
    private static ThreadLocal<ExtentTest> methodTest = new ThreadLocal<>();

    private ExtentTest getTest(ITestResult result){
        return methodTest.get();
    }

    public synchronized void onTestStart(ITestResult result){
        String methodName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(methodName);
        methodTest.set(test);
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH-mm-ss");
        Date date = new Date();
        String name = dateFormat.format(date);
        File file = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("src/screenshot/" + name + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getTest(result).fail(result.getThrowable());
    }

    public synchronized void onFinish(ITestContext context){
        extent.flush();
    }

}
