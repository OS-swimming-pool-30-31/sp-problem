package onlyfun;

import java.util.*;

public class Demo {
	
	public static int[] cubicle = new int[10];
	public static int[] basket = new int[15];
	
	
	
	
	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String name;
		int number = 0;
		
		LinkedList<InThread> inThreadList = null;

        while(true) {
        
        	name = scanner.next();
        	System.out.println(name);
        	
        	printInf();
        	
        	if(name.equals("in")) {
        		number++;
        		InThread inThread = new InThread(number);
        		inThread.start();
        	}
        	else {
        		System.out.println("error");
        	}
        }
    }
	
	public static void printInf() {
		
		System.out.println("淋浴間:");
		for(int b:cubicle) {
			System.out.print(b + " ");	
		}
		System.out.println();
		
		System.out.println("籃子:");
		for(int b:basket) {
			System.out.print(b + " ");	
		}
		System.out.println();
	}
}
