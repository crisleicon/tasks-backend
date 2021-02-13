package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
	@Test
	public void returnTrueForFutureDates() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
		
	}
	@Test
	public void returnFalseForPastDates() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
		
	}
	@Test
	public void returnTrueForActualDates() {
		LocalDate date = LocalDate.now();
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		
	}
}
