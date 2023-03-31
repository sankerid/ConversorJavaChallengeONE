package com.picasso.methods;

import javax.swing.JOptionPane;

public class TemperatureConverter {
	
	private static String[] tempUnits = {"C°", "F°", "K°"};
	
	
	
	public static double temperatureConverter( String cbFrom, String cbTo, double temp ) {
		
		switch( cbFrom ) {
		
		case "C°":
			if (cbTo.equals("F°")) {
				return ( temp*1.8 ) + 32;
			} else if( cbTo.equals("K°")) {
				return temp + 273.15;
			}
			break;
		case "F°":
			if (cbTo.equals("C°")) {
				 return (temp - 32) / 1.8;
			} else if( cbTo.equals("K°")) {
				 return (temp - 32) / 1.8 + 273.15;
			}
			break;
		case "K°":
			if (cbTo.equals("C°")) {
				return temp - 273.15;
			} else if( cbTo.equals("F°")) {
				return (temp - 273.15) * 1.8 + 32;
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Syntax ERROR");
			break;
		}
		return temp;
	}
	
	
	
	public static String[] getTempUnits() {
		return tempUnits;
	}

}
