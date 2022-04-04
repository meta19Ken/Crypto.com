package com.restfulbooker.apitest.businessLogics;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://crypto.com/exchange/markets");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        String title = driver.getTitle();

        // Verify
        System.out.println("*** Ready *** = " + title);
        assertThat(title).contains("Crypto.com");
        //driver.findElement(By.className("className"));
        //driver.findElement(By.cssSelector(".className"));
        //driver.findElement(By.id("universal_pixel_o962s85"));
        //driver.findElement(By.linkText("linkText"));
        //driver.findElement(By.partialLinkText("USDT"));
        //driver.findElement(By.tagName("div"));
        String description = driver.findElement(By.name("description")).getAttribute("content");
        System.out.println("description=" + description);
       
/*
        
        List<WebElement> instrumentNames = driver.findElements(By.className("instrument-name"));

        for (WebElement instrumentName : instrumentNames) {
        	
        	if (instrumentName.getText().startsWith("ZIL")) {
            System.out.println("Find Instrument Name = " + instrumentName.getText());
            System.out.println("Find Instrument Location = " + instrumentName.getLocation().toString());
       
            //instrumentName.click(); // Suppose it will go to ZIL/USDT trade page but failed.
            
        	}
        }
*/        
        
        System.out.println("********");
        List<WebElement> rows = driver.findElements(By.className("tbody__row"));
        for (WebElement row : rows) {
        
        	WebElement instrument = row.findElement(By.className("instrument"));
        	WebElement volume = row.findElement(By.className("volume"));
        	WebElement button = row.findElement(By.tagName("button"));
        	WebElement instrumentName = instrument.findElement(By.className("instrument-name"));
          	if (instrumentName.getText().startsWith("ZIL")) {
          		System.out.println("Instrument Name=" + instrumentName.getText());
          		System.out.println("Volume=" + volume.getText());
          		System.out.println("Volume.Location=" + volume.getLocation().toString());
          		System.out.println("Button=" + button.toString());
          		System.out.println("Button.Location=" + button.getLocation().toString());
          		
          		//button.click(); // Suppose it will go to ZIL/USDT trade page but failed.
          	}
        }
        
        
        //System.out.println("instrument=" + instrument);
        //driver.findElement(By.linkText("USDT"));
        //driver.findElement(By.xpath("xPath"));
        System.out.println("*** End ***");

    }

}