package osGUI;

import java.util.*;

public class Demo {
	
	public static int[] cubicle = new int[5];
	public static int[] basket = new int[10];
	public static int number;
	public static int basket_num;
	public static LinkedList<InThread> inThreadList;
	
	public Demo(){
		start();
	}
	public static void start() {
		number = 0;
		basket_num = 0;
		inThreadList = null;
    }
	public static void add(){
		if(basket_num > 9){
			GUItest.textField.setText("Waiting : " + ++GUItest.waiting_num);
		}
		while(basket_num > 9){
			staticWait();
		}
		if(GUItest.waiting_num > 0){
			GUItest.textField.setText("Waiting : " + --GUItest.waiting_num);
		}
    	number++;
    	basket_num++;
    	InThread inThread = new InThread(number);
    	inThread.start();
	}
	public static void leave(){
		basket_num--;
		staticNotify();
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
	static private Object obj = new Object();

    public static void staticWait() {
        synchronized (obj) {
            try {
                obj.wait();
            } catch (Exception e) {}
        }    
    }

    public static void staticNotify() {
        synchronized (obj) {
            obj.notify();
        }
    }
}
