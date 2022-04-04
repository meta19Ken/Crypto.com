package com.restfulbooker.apitest.baseAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.restfulbooker.apitest.actions.CandlestickData;
import com.restfulbooker.apitest.actions.HttpOperation;
import com.restfulbooker.apitest.restassuredFuntions.API;
import com.restfulbooker.apitest.restassuredFuntions.RestActions;
import com.restfulbooker.apitest.utilities.Constants;

import io.restassured.response.Response;

public class Candle extends API{
	
    public Candle(){}
    private final String ENDPOINT = "/get-candlestick";  
    
    /**
     * Creates a new get Candle
     * 
     * */
    private void getResponse(String instrumentName, String interval) {
		initBase("base.url");
		init(ENDPOINT + "?instrument_name=" + instrumentName + "&timeframe=" + interval, HttpOperation.GET);
		//setHeader("Content-Type","application/json");
		//setBody("{ \"instrument_name\" : \""+instrumentName+"\", \"timeframe\" : \""+interval+"\"}");
	}
	

	public String getCandleStick(String instrumentName, String interval) {
		getResponse(instrumentName, interval);
		String response = callIt();
		System.out.println("****" + response);
		return response;
	}
	

    public List<CandlestickData> getCandlestickDataAsList(String instrumentName, String interval) {
        //RestActions.initialize();
    	getResponse(instrumentName, interval);
        List<?> candlestickDataList = callDataAsList(CandlestickData.class);
	    
        for (CandlestickData candlestickData : (List<CandlestickData>) candlestickDataList) {
	    	  
	    	  System.out.print("t = " + candlestickData.getT() );
	    	  System.out.print(" o = " + candlestickData.getO() );
	    	  System.out.print(" h = " + candlestickData.getH() );
	    	  System.out.print(" l = " + candlestickData.getL() );
	    	  System.out.print(" c = " + candlestickData.getC() );
	          System.out.print(" v = " + candlestickData.getV() );
	          System.out.println();
	        }
        return (List<CandlestickData>) candlestickDataList;
    }
    

    
}
