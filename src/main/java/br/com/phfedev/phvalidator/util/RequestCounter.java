package br.com.phfedev.phvalidator.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    
    public static String getPrice() {
    	String dbValue = Double.toString(addInt.get() * tax);
    	BigDecimal bdValue = new BigDecimal (dbValue);
    	DecimalFormat df = new DecimalFormat();
    	df.applyPattern("#,##0.00");
    	String formattedValue = df.format(bdValue);
    	
    	return "{ \"quantity\": "+addInt.get()+", "
    			+"\n\"value\": "+formattedValue+"\n}";
    	//return "valuetopay: "+formattedValue;
    }
}
