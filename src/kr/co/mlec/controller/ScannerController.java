package kr.co.mlec.controller;

import java.util.Scanner;

public abstract class ScannerController implements Controller{
	public Scanner sc = new Scanner(System.in);
	protected String input(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}
