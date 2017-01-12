package osGUI;

public class Demo {
	
	public static int[] cubicle = new int[5];
	public static int[] basket = new int[10];
	public static int basket_num;
	public int number;
	
	public Demo(){
		start();
	}
	public void start() {
		number = 0;
		basket_num = 0;
    }
	public void add(){
		number++;
    	InThread inThread = new InThread(number);
    	inThread.start();
	}
}
