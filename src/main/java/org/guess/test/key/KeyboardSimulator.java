package org.guess.test.key;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyboardSimulator {
	private static Robot robot = null;
	static {
		try {
			robot = new Robot();
		} catch (AWTException ex) {
			throw new RuntimeException(ex);
			
		}
	}

	private KeyboardSimulator() {
		// 不可实例化
	}

	public static void input(String str) {
		if (str != null) {
			for (char c : str.toCharArray()) {
				pressKey(c);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	}

	/**
	 * 模拟按下按键
	 * 
	 * @param keyvalue
	 */
	 
	private static void pressKey(int keyvalue) {
		robot.keyPress(keyvalue); // 按下按键
		robot.keyRelease(keyvalue); // 释放按键
	}

	public static void main(String[] args) throws IOException {
		
		input("533001198510124839");
//		for(int i = 0;i<100;i++){
//			if(i%2 == 0){
//				robot.mouseMove(200, 200);
//			}else {
//				robot.mouseMove(500, 500);
//			}
//		}
		
	}
	

}
