package imd0412.DateAPI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        DateUtilCasesTest.class,
        DateUtilExceptionsTest.class,
        DateAPIInstanceTest.class
})
public class DateAPITestSuite {
}
