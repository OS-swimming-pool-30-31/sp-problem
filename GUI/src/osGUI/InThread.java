package osGUI;

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
	    		
	    while(situ<5) {
	        	
	      	switch(situ) {
	            	
	      		case 0:{
	        		System.out.println(number + "��ж���");
	        		GUItest.ta.append(number + "��ж���" + "\r\n");
	        		for(int i=0; i<5; i++) {
	        			if(Demo.cubicle[i] == 0) {
	        				Demo.cubicle[i] = number;
	        				temp = i;
	        				situ++;
	        				GUItest.cubicle_change(i, true);
	        				break;
	        			}
	        			if(i==4){
	        				System.out.println(number + "�䤣��ж�");
	        				GUItest.ta.append(number + "�䤣��ж�" + "\r\n");
	        			}
	        		}
	        		break;
	        	}
	        	case 1:{
	        		System.out.println(number + "���x�l��");
	        		GUItest.ta.append(number + "���x�l��" + "\r\n");
	        		for(int i=0; i<10; i++) {
	        			if(Demo.basket[i] == 0) {
	        				Demo.basket[i] = number;
	        				situ++;
	        				GUItest.basket_change(i, true);
	        				break;
	        			}
	        			if(i==9){
		        			System.out.println(number + "�䤣���x�l");
	        				GUItest.ta.append(number + "�䤣���x�l" + "\r\n");
	        			}
	        		}
	 	        	break;
	        	}
	        	case 2:{
	        		for(int i=0; i<5; i++) {
	        			if(Demo.cubicle[i] == number) {
	        				Demo.cubicle[i] = 0;
	        				GUItest.cubicle_change(i, false);
	        			}
	        		}
	        		System.out.println(number + "��a��");
	        		GUItest.ta.append(number + "��a��" + "\r\n");
	        		situ++;
	        		
	        		break;
	        	}
	        	case 3:{
	        		System.out.println(number + "��ж��^�a");
	        		GUItest.ta.append(number + "��ж��^�a" + "\r\n");
	        		for(int i=0; i<5; i++) {
	        			if(Demo.cubicle[i] == 0) {
	        				Demo.cubicle[i] = number;
	        				temp = i;
	        				situ++;
	        				GUItest.cubicle_change(i, true);
	        				break;
	        			}
	        			if(i==4){
	        				System.out.println(number + "�䤣��ж��^�a");
	        				GUItest.ta.append(number + "�䤣��ж��^�a" + "\r\n");
	        			}
	        				
	        		}
	        		break;
	        	}
	        	case 4:{
	        		System.out.println(number + "�^�a�o");
	        		GUItest.ta.append(number + "�^�a�o" + "\r\n");
	        		for(int i=0; i<10; i++) {
	        			if(Demo.basket[i] == number) {
	        				Demo.basket[i] = 0;
	        				GUItest.basket_change(i, false);
	        				Demo.cubicle[temp] = 0;
	    	        		GUItest.cubicle_change(temp, false);
	        				Demo.leave();
	        			}
	        		}
	        		situ++;
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
