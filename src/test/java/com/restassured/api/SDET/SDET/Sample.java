package com.restassured.api.SDET.SDET;

public class Sample {

	static int sum=0;
	static void add(int... a){
		for(int i=0;i<a.length;i++){
		sum=sum+a[i];
		}
		
		System.out.println(sum);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(1,1,1,5);
	}

}
