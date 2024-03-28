import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports createInstance(String file){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(file);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
