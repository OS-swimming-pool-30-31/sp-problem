package onlyfun;

import java.util.Random;

public class InThread extends Thread  {
	
	private boolean active;
	private int number;
	private int situ;
	private int temp;
	
	public InThread(int num) {
		active = true;
	   	number = num;
	   	situ = 0;
	}
	    
	public void setActive(boolean active) {
	    this.active = active;
	}

	public boolean isActive() {
	    return active;
	}

	public void run () {
	    		
	    while(true) {
	        	
	      	switch(situ) {
	            	
	      		case 0:{
	        		System.out.println(number + "��ж���");
	        		for(int i=0; i<10; i++) {
	        			if(Demo.cubicle[i] == 0) {
	        				Demo.cubicle[i] = number;
	        				temp = i;
	        				situ++;
	        				break;
	        			}
	        			if(i==9)
	        				System.out.println(number + "�䤣��ж�");
	        		}
	        		break;
	        	}
	        	case 1:{
	        		System.out.println(number + "���x�l��");
	        		Demo.cubicle[temp] = 0;
	        		
	        		for(int i=0; i<15; i++) {
	        			if(Demo.basket[i] == 0) {
	        				Demo.basket[i] = number;
	        				temp = i;
	        				situ++;
	        				break;
	        			}
	        			if(i==14)
		        			System.out.println(number + "�䤣���x�l");
	        		}
	 	        	break;
	        	}
	        	case 2:{
	        		System.out.println(number + "��a��");
	        		situ++;
	        		break;
	        	}
	        	case 3:{
	        		System.out.println(number + "��ж��^�a");
	        		for(int i=0; i<10; i++) {
	        			if(Demo.cubicle[i] == 0) {
	        				Demo.basket[temp] = 0;
	        				Demo.cubicle[i] = number;
	        				temp = i;
	        				situ++;
	        				break;
	        			}
	        			if(i==9)
	        				System.out.println(number + "�䤣��ж�");
	        		}
	        		break;
	        	}
	        	case 4:{
	        		System.out.println(number + "�^�a�o");
	        		Demo.cubicle[temp] = 0;
	        		break;
	        	}
	        }
	      	try {
	      		Thread.currentThread().sleep(3000);
            } 
            catch(InterruptedException e) {
                 e.printStackTrace();
            }
	    }
	}
}
