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
	        		System.out.println(number + "找房間中");
	        		GUItest.ta.append(number + "找房間中" + "\r\n");
	        		for(int i=0; i<5; i++) {
	        			if(Demo.cubicle[i] == 0) {
	        				Demo.cubicle[i] = number;
	        				temp = i;
	        				situ++;
	        				GUItest.cubicle_change(i, true);
	        				break;
	        			}
	        			if(i==4){
	        				System.out.println(number + "找不到房間");
	        				GUItest.ta.append(number + "找不到房間" + "\r\n");
	        			}
	        		}
	        		break;
	        	}
	        	case 1:{
	        		System.out.println(number + "找籃子中");
	        		GUItest.ta.append(number + "找籃子中" + "\r\n");
	        		for(int i=0; i<10; i++) {
	        			if(Demo.basket[i] == 0) {
	        				Demo.basket[i] = number;
	        				situ++;
	        				GUItest.basket_change(i, true);
	        				break;
	        			}
	        			if(i==9){
		        			System.out.println(number + "找不到籃子");
	        				GUItest.ta.append(number + "找不到籃子" + "\r\n");
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
	        		System.out.println(number + "游泳中");
	        		GUItest.ta.append(number + "游泳中" + "\r\n");
	        		situ++;
	        		
	        		break;
	        	}
	        	case 3:{
	        		System.out.println(number + "找房間回家");
	        		GUItest.ta.append(number + "找房間回家" + "\r\n");
	        		for(int i=0; i<5; i++) {
	        			if(Demo.cubicle[i] == 0) {
	        				Demo.cubicle[i] = number;
	        				temp = i;
	        				situ++;
	        				GUItest.cubicle_change(i, true);
	        				break;
	        			}
	        			if(i==4){
	        				System.out.println(number + "找不到房間回家");
	        				GUItest.ta.append(number + "找不到房間回家" + "\r\n");
	        			}
	        				
	        		}
	        		break;
	        	}
	        	case 4:{
	        		System.out.println(number + "回家囉");
	        		GUItest.ta.append(number + "回家囉" + "\r\n");
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
