import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        int fails = 0;
        try {
            Result result = JUnitCore.runClasses(NumberGuessingTest.class);
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
                fails++;
            }

            if (fails > 0) {
                throw new Exception("Tests failed.");
            }

            System.exit(0); // success
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            System.exit(1); // failure
        }
    }
}
