package com.example;

import java.util.Random;

public class MainAct {

	public static void main(String[] args) {
		
		MyInterface mrg = () -> new Random().nextInt(10);
		
		System.out.println(mrg.produce());
		
	}

}
