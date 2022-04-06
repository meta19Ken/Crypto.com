package com.restfulbooker.apitest.businessLogics;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restfulbooker.apitest.actions.ValidatorOperation;
import com.restfulbooker.apitest.baseAPI.*;
import com.restfulbooker.apitest.listeners.ExtentTestManager;
import com.restfulbooker.apitest.actions.CandlestickData;
import com.relevantcodes.extentreports.LogStatus;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;



public class CryptoCandleTest {
	
  String response;
 
  
  @Test
  public void candleTest(Method method) {
	  
	  ExtentTestManager.startTest(method.getName(), "V1.0 (Task 1) Succssful case - get candle stick USDC_USDT with interval 5m - compare closing price with 0.999");
	  Candle response = new Candle();
	  
	  try {	      
	      List<CandlestickData> candleStickDataList = response.getCandlestickDataAsList("USDC_USDT","5m");
	      response.assertIt(200);
	      response.assertIt("result.data",null,ValidatorOperation.NOT_EMPTY);
	      
	      for (CandlestickData candlestickData : candleStickDataList) {
	    	  Assertions.assertEquals(0.999 ,candlestickData.getC(), "Closing Price is equal to value 0.999");
	    	  // Or any other assertion with Mapping of data     	  
	      }

		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting Correct");
		  //response.assertIt("reason","BAD_REQUEST",ValidatorOperation.EQUALS);

	  }
	  catch(AssertionError e){
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
	  }	 
	  
	 }
  
  @Test
  public void candleFailTest(Method method) {
	  
	  ExtentTestManager.startTest(method.getName(), "V1.0 (Task 1) Fail case - get candle stick on ETH_USDT with interval 1m - compare closing price with 3101");
	  Candle response = new Candle();
	  
	  try {	      
	      List<CandlestickData> candleStickDataList = response.getCandlestickDataAsList("ETH_USDT","1m");
	      response.assertIt(200);
	      response.assertIt("result.data",null,ValidatorOperation.NOT_EMPTY);
	      
	      for (CandlestickData candlestickData : candleStickDataList) {
	    	  Assertions.assertEquals(3101 ,candlestickData.getC(), "Closing Price is expect to have a value 3101");
	    	  // Or any other assertion with Mapping of data     	  
	      }

		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting Correct");
		  //response.assertIt("reason","BAD_REQUEST",ValidatorOperation.EQUALS);

	  }
	  catch(AssertionError e){
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
	  }	 
	  
	 }
  
  
  @Test
  public void seleniumTest(Method method) {
	  	  
	  ExtentTestManager.startTest(method.getName(), "V2.2 (Task 1)Description: Testing Selenium and find ZIL/USDT Volume data");
	
	  try {
		  ChromeTest.setupClass();
		  
		  ChromeTest cryptoTest = new ChromeTest();
		  cryptoTest.setupTest();
		  cryptoTest.test();

		  ExtentTestManager.getTest().log(LogStatus.INFO, "Find ZIL/USDT and get the Volume data successfully");
		  cryptoTest.teardown();	
	  
	  }
	  catch(AssertionError e){
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());

	  }    
  }

}
