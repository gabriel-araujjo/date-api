package imd0412.DateAPI;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static imd0412.DateAPI.DateUtil.nextDate;

@RunWith(Parameterized.class)
public class DateUtilExceptionsTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Parameters(name = "{0}/{1}/{2}")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {31, 12, 1811, IllegalArgumentException.class},       // TE0 - Year limits
                {1, 1, 2017, IllegalArgumentException.class},         //     - Year limits
                {32, 12, 1812, IllegalArgumentException.class},       // TE1 - Invalid day
                {0, 1, 2016, IllegalArgumentException.class},         //     - Invalid day
                {31, 13, 1812, IllegalArgumentException.class},       // TE2 - Invalid month
                {1, 0, 2016, IllegalArgumentException.class},         //     - Invalid month
                {31, 4, 2016, IllegalStateException.class},           // TE3 - Invalid date
                {30, 2, 2016, IllegalStateException.class},           //     - Invalid date
        });
    }

    @Parameter(/*0*/)
    public int day;

    @Parameter(1)
    public int month;

    @Parameter(2)
    public int year;

    @Parameter(3)
    public Class<? extends Throwable> expected_exception;


    @Test
    public void testDateUtil()
    {
        thrown.expect(expected_exception);
        nextDate(day, month, year);
    }
}
