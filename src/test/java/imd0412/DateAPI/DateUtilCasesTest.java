package imd0412.DateAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static imd0412.DateAPI.DateUtil.nextDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DateUtilCasesTest
{

    @Parameters(name = "{0}/{1}/{2}")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1812, "2/1/1812"},       // TC0 - Limits
                {31, 12, 2016, "1/1/2017"},     // TC0 - Limits
                {1, 1, 2016, "2/1/2016"},       // TC1 - day in [1, 27]
                {27, 11, 2016, "28/11/2016"},   //     - day in [1, 27]
                {30, 10, 2016, "31/10/2016"},   // TC2 - day <=30 in month with 31 days
                {31, 10, 2016, "1/11/2016"},    // TC3 - day = 31 in month with 31 days
                {29, 4, 2016, "30/4/2016"},     // TC4 - day <=29 in month with 30 days
                {30, 4, 2016, "1/5/2016"},      // TC5 - day = 30 in month with 30 days
                {28, 2, 1900, "1/3/1900"},      // TC6 - Feb 28 in a not leap year divisible by 100
                {28, 2, 2000, "29/2/2000"},     // TC7 - Feb 28 in a leap year divisible by 400
                {28, 2, 2004, "29/2/2004"},     // TC8 - Feb 28 in a leap year divisible by 4
                {28, 2, 2003, "1/3/2003"},      // TC9 - Feb 28 in a common not leap year
                {31, 12, 2003, "1/1/2004"},     // TC10 - Dec 31
                {29, 2, 2004, "1/3/2004"},      // TC11 - Feb 29 in a leap year

        });
    }

    @Parameter(/*0*/)
    public int day;

    @Parameter(1)
    public int month;

    @Parameter(2)
    public int year;

    @Parameter(3)
    public String expected;


    @Test
	public void testDateUtil()
    {
        assertThat( nextDate(day, month, year), is(expected));
    }
}
