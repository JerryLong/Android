package com.dralong.tools;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 软键盘相关工具类
 * 
 * @author Jim
 *
 */
public class KeyBoardUtils {

	/**
	 * 打开软键盘
	 * 
	 * @param editText
	 *            输入框
	 * @param editText
	 *            上下文
	 */
	public static void openKeybord(Context context, EditText editText) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
				InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

	/**
	 * 关闭软键盘
	 * 
	 * @param editText
	 *            输入框
	 * @param editText
	 *            上下文
	 */
	public static void closeKeybord(Context context, EditText editText) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);

		imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
	}

	/**
	 * 隐藏或显示软键盘
	 * 
	 * 如果当前为显示则隐藏，反之则显示
	 * 
	 * @param context
	 */
	public static void showOrHideIMM(Context context) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

}
