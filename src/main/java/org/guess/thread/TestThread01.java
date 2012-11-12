package org.guess.thread;

public class TestThread01 {
	
	public static void main(String[] args) {
		
		new TestThread01().begin();
		for(int i = 0;i<100;i++){
			System.out.println("22222");
		}
	}
	
	private void begin() {

		MyThread mt = new MyThread();
		mt.start();
	}
	
	class MyThread extends Thread{
		@Override
		public void run() {
			for(int i = 0;i<100;i++){
				System.out.println("111111");
			}
		}
	}
	
}
