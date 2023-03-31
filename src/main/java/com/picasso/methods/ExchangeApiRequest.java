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
	
	
	public static double getCurrencyRequest( String amount, String from, String to ) {
		
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



