package com.xworkz.icecream.entity;

public class Output {
	
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5};
		int b[]=a;
		int sum=0;
		for (int j = 0; j < 3; ++j) 
			sum+=(a[j]*b[j+1])+(a[j+1]*b[j]);
		System.out.println(sum);
		
	}

}
