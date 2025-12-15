package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ConsoleReportListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("========================================");
        System.out.println("STARTED TC: " + result.getMethod().getDescription());
        System.out.println("========================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(">> STATUS: PASSED \n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">> STATUS: FAILED \n");
    }
}