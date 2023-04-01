package com.picasso.methods;

import java.text.DecimalFormat;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JOptionPane;

public class TemperatureConverter {
	
	private static String[] tempUnits = {"C°", "F°", "K°"};
	
	
	public static String convertTemperature( String cbFrom, String cbTo, double temp ) {
		DecimalFormat df = new DecimalFormat("#0.00");
		
		switch( cbFrom ) {
		
		case "C°":
			if (cbTo.equals("F°")) {
				return df.format((temp * 1.8) + 32);
			} else if( cbTo.equals("K°")) {
				return df.format(temp + 273.15);
			}
			break;
		case "F°":
			if (cbTo.equals("C°")) {
				return df.format((temp - 32) / 1.8);
			} else if( cbTo.equals("K°")) {
				return df.format((temp - 32) / 1.8 + 273.15);
			}
			break;
		case "K°":
			if (cbTo.equals("C°")) {
				return df.format(temp - 273.15);
			} else if( cbTo.equals("F°")) {
				return df.format((temp - 273.15) * 1.8 + 32);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Syntax ERROR", "Syntax ERROR", ERROR_MESSAGE);
			break;
		}
		return String.valueOf(temp);
	}
	
	
	
	public static String[] getTempUnits() {
		return tempUnits;
	}

}
