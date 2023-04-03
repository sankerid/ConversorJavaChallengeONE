package com.picasso.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

public class ExchangeApiRequest {
	
	private static final String apiKey = "at4roU8DIOs1C6OQvHHiwS0uxUh7F5Mp";
	
	/**
	 * Sends an HTTP GET request to the API endpoint with the specified type of request and API key,
	 * and returns the response as a StringBuffer.
	 * @param typeOfRequest a String representing the type of request to send to the API endpoint.
	 * @param apiKey a String representing the API key required to access the API endpoint.
	 * @return a StringBuffer representing the response received from the API endpoint, or null if the response is invalid.
	 * @throws IOException if there is an error while sending the HTTP GET request.
	*/
	private static StringBuffer sendHttpGetRequest( String typeOfRequest, String apiKey ) throws IOException {
		
		String URL_GET = "https://api.apilayer.com/exchangerates_data/" + typeOfRequest;
		
		URL url = new URL(URL_GET);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		httpURLConnection.setRequestProperty("apikey", apiKey);
		
		if ( httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK ) {
			
			BufferedReader bReader = new BufferedReader( new InputStreamReader( httpURLConnection.getInputStream() ) );
			String input;
			StringBuffer response = new StringBuffer();
			while ( ( input = bReader.readLine() ) !=null ) {
				
				response.append(input);
				
			}
			
			bReader.close();
			return response;
			
		}
		
		return null;
		
	}
	
	
	
	/**
	 * This static method retrieves the exchange rate for a given currency conversion.
	 * @param from the currency code to convert from.
	 * @param to the currency code to convert to.
	 * @param amount the amount to convert.
	 * @return the converted amount based on the current exchange rate.
	*/
	public static double getCurrencyRequest( String from, String to, double amount ) {
		
		StringBuffer response;
		try {
			response = sendHttpGetRequest( "convert?to=" + to + "&from=" + from + "&amount=" + amount, apiKey);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "IO Exception: " + e.getMessage());
			response = null;
		}
		
		if ( response != null ) {
			try {
				JSONObject responseObj = new JSONObject(response.toString());
				double currency = responseObj.getDouble("result");
				return currency;
			} catch (JSONException j) {
				JOptionPane.showMessageDialog(null, "JSON Exceptio: " + j.getMessage());
			}
		}
		
		return 0.0;
	}
	
	
	
	/**
	 * This method is a static method of the ExchangeApiRequest class that allows obtaining the symbols of the different currencies available through a GET request.
	 * The method uses the sendHttpGetRequest method to connect to the API and retrieve the response.
	 * If the response is not null, the method extracts the symbols and their descriptions, sorts them alphabetically and stores them in a list of string arrays.
	 * @return List<String[]> - A list of string arrays that contains the symbols of the currencies and their descriptions, sorted alphabetically.
	 	* If the response is null, returns null.
	 * @throws IOException - Signals that an I/O exception of some sort has occurred.
	 * @see sendHttpGetRequest.
	*/
	public static List<String[]> getSymbolsRequest(){
		
		StringBuffer response;
		
		try {
			response = sendHttpGetRequest("symbols", apiKey);
		} catch (IOException i) {
			JOptionPane.showInternalMessageDialog(null, "IO Exceptio: " + i.getMessage());
			response = null;
		}
		
		if ( response != null ) {
			
			try {
				
				JSONObject responseObj = new JSONObject( response.toString() );
				JSONObject symbolsObj = responseObj.getJSONObject("symbols");
				
				ArrayList<String> keyList = new ArrayList<>( symbolsObj.keySet() );
				Collections.sort(keyList);
				
				ArrayList<String> descList = new ArrayList<>();
				for (String key : keyList) {
					String list = key + " - " + symbolsObj.getString(key);
					descList.add(list);
				}
				
				String[] symbolsKeys = keyList.toArray( new String[0] );
				String[] descriptionSymbols = descList.toArray( new String[0] );
				List<String[]> symbolDescriptionList = new ArrayList<>();
				symbolDescriptionList.add(symbolsKeys);
				symbolDescriptionList.add(descriptionSymbols);
				return symbolDescriptionList;
				
			} catch (JSONException j) {
				JOptionPane.showMessageDialog(null, "JSON Exception: " + j.getMessage());
			}
		}
		
		return null;
		
	}
	
}