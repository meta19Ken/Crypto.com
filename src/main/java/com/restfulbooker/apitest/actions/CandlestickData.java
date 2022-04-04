package com.restfulbooker.apitest.actions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandlestickData {
    private long t;
    private double o;
    private double h;
    private double l;
    private double c;
    private double v;
    
      
    public void setT(long t){
    	this.t = t;
    }
    public void setO(double o){
    	this.o = o;
    }
    public void setH(double h){
    	this.h = h;
    }
    public void setL(double l){
    	this.l = l;
    }
    public void setC(double c){
    	this.c = c;
    }
    public void setV(double v){
    	this.v = v;
    }
    
    
    
    public long getT(){
    	return t;
    }
    public double getO(){
    	return o;
    }
    public double getH(){
    	return h;
    }
    public double getL(){
    	return l;
    }
    public double getC(){
    	return c;
    }
    public double getV(){
    	return v;
    }
    
}
