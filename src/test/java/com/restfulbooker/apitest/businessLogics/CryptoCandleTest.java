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
	  
	  ExtentTestManager.startTest(method.getName(), "(Task 1a)Description: Succssful case - get USDC_USDT with interval 5m - compare test data 0.999 (sorry, not by txt or list input)");
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
	  
	  ExtentTestManager.startTest(method.getName(), "(Task 1a)Description: Fail case - get candle stick on ETH_USDT with interval 1m - compare test data 0.999 (sorry, not by txt or list input)");
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
  public void validTest(Method method) {
	  	  
	  ExtentTestManager.startTest(method.getName(), "(Task 3)Description: Testing Browser and find ZIL/USDT to test Selenium");
	
	  try {
		  ChromeTest.setupClass();
		  
		  ChromeTest cryptoTest = new ChromeTest();
		  cryptoTest.setupTest();
		  cryptoTest.test();

		  ExtentTestManager.getTest().log(LogStatus.INFO, "Testing Selenium successfully");
		  cryptoTest.teardown();	
	  
	  }
	  catch(AssertionError e){
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());

	  }    
  }

}
