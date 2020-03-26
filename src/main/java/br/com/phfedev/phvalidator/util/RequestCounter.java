package br.com.phfedev.phvalidator.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class RequestCounter {
	private static double tax = 0.10;
	private final static AtomicLong addInt = new AtomicLong();

	public static long getQuantity() {
		return addInt.get();
	}

	public static long add() {
		return addInt.incrementAndGet();
	}

	public static String getPrice(Integer counter) {
		if (counter == null) {
			return "{ info: \"No requests registered yet\"}";
		} else {
			Locale locale = new Locale("pt", "BR");
			String doubleValue = Double.toString(counter * tax);
			BigDecimal bigDeciamlValue = new BigDecimal(doubleValue);
			DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
			decimalFormat.applyPattern("#,##0.00");
			String formattedValue = decimalFormat.format(bigDeciamlValue);

			return "{ \"quantity\": \"" + counter + "\", " + "\n\"value\": \"" + formattedValue + "\"\n}";
		}
	}
}
