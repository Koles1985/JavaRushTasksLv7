package task_22_calculate;



public class Solution {
	
	public Solution() throws InterruptedException{
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		Counter counter3 = new Counter();
		Counter counter4 = new Counter();
		
		counter1.start();
		counter2.start();
		counter3.start();
		counter4.start();
		
		
		counter1.join();
		counter2.join();
		counter3.join();
		counter4.join();
		
		for(int i = 1; i <=100; i++) {
			System.out.printf("values[%d] = %d\n", i, values[i]);
			if(values[i] != 1) {
				System.out.println("Массив values содержит элементы неравные 1");
				break;
			}
		}
	}
	
	public static Integer count = 0;
	public static int[] values = new int[105];
	static {
		for(int i = 0; i < values.length; i++) {
			values[i] = 0;
		}
	}
	
	public static void incrementCount() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public class Counter extends Thread{
		@Override
		public void run() {
			do {
				synchronized(Counter.class) {
					incrementCount();
					values[getCount()]++;	
				}
				
				try {
					Thread.sleep(1);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}while(getCount() < 100);
		}
	}
}
