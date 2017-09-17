package imd0412.DateAPI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        DateUtilTest.class,
        DateUtilExceptionsTest.class
})
public class DateAPITestSuite {
}
