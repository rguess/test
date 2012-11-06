package org.guess.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class FanShe {

	public static void main(String[] args) {
		ArrayList<PageItem> items2 = new ArrayList<PageItem>();
		items2.add(new PageItem("asdfasdf", 123, "showGoodPub"));

		int position = 0;
		// gridView.setOnItemClickListener(new OnItemClickListener() {
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view, int
		// position, long id) {
		items2.get(position).onClick();
		// }}
		// );
	}
}

class PageItem {
	public final String itemText;
	public final int itemImage;
	private final String methodName;

	public PageItem(String itemText, int itemImage, String methodName) {
		this.itemText = itemText;
		this.itemImage = itemImage;
		this.methodName = methodName;
	}

	public void onClick() {
		try {
			Method m1 = UIHelper.class.getDeclaredMethod(methodName,
					Context.class);
			m1.invoke(UIHelper.class, new Context());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}

class UIHelper {
	public static void showGoodPub(Context context) {
		context.startActivity("我炒尼吗");
	}
}

class Context {
	public void startActivity(String intent) {
		System.out.println(intent);
	}
}
