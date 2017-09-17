package imd0412.DateAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Eiji Adachi M. Barbosa
 *
 */
public class DateUtil
{

	private DateUtil() {}

	private static boolean has30(int month)
	{
		return months30.contains(month);
	}

	private static boolean has31(int month)
	{
		return month == DECEMBER || months31.contains(month);
	}

	private static boolean isFebruary(int month)
	{
		return month == 2;
	}

	private static boolean isLeapYear(int year)
	{
		if (year % 4 != 0)
		{
			return false;
		}
		else if (year % 400 == 0)
		{
			return true;
		}
		else if (year % 100 == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static String nextDate(int day, int month, int year)
	{
		if ((day < 1 || day > 31) || (month < 1 || month > 12) || (year < 1812 || year > 2016))
		{
			throw new IllegalArgumentException();
		}

		String result;

		/* day is always greater equals than 1 at this point*/
		if ((/*day >= 1 &&*/ day <= 27)
				|| (has31(month) && day < 31)
				|| (has30(month) && day < 30)
				|| (isFebruary(month) && isLeapYear(year) && day == 28))
		{
			result = String.format(dateFormat, day + 1, month, year);
		}
		else if ((has31(month) && month != DECEMBER && day == 31)
				|| (has30(month) && day == 30)
				|| (isFebruary(month) && isLeapYear(year) && day == 29)
				|| (isFebruary(month) /*&& !isLeapYear(year)*/ && day == 28))
        {                            //         ↑
                                     // year will always be a not leap year
                                     // at this point
			result = String.format(dateFormat, 1, month + 1, year);
		}
		else /*if (month == DECEMBER && day == 31)*/ // Always true
		{
			result = String.format(dateFormat, 1, 1, year + 1);
		}
		// Unreachable
		/*else
		{
			throw new IllegalStateException();
		}*/

		return result;
	}

	private static final Set<Integer> months31;

	private static final Set<Integer> months30;

	private static final Integer DECEMBER = 12;

	static
	{
		months31 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10));

		months30 = new HashSet<>(Arrays.asList(4, 6, 9, 11));
	}

	private static final String dateFormat = "%d/%d/%d";
}
