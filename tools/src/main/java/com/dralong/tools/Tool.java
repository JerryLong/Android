package com.dralong.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class Tool {

	/**
	 * 字符串判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if ("".equals(str.trim()) || str == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 字符串如果为空处理
	 * 
	 * @param str
	 * @return
	 */
	public static String justNull(String str) {
		if ("".equals(str.trim()) || str == null || "null".equals(str)) {
			return "暂无数据";
		} else {
			return str;
		}
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

	/**
	 * 字符串是否有某个符号
	 * 
	 * @param str
	 *            查询的字符串
	 * @param str2
	 *            查找的符号
	 * @return
	 */
	public static boolean isContain(String str, String str2) {

		return str.contains(str2);
	}

	/**
	 * 判断是否为邮箱
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 判断密码是否符合条件（大于6位或者小于16位，或者是否为纯数字,存小写大写、字母等）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPassWord(String str) {
		// 验证是否为存数字表达式
		Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(str);
		// 验证是否为纯字母等
		String passRegex = "(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@*&]+$).{6,20}";
		if ((!"".equals(str.trim()) && str != null)
				&& ((str.trim().length() >= 6) && (str.trim().length() <= 16))) {
			if (str.matches(passRegex)) {
				if (!m.matches()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 验证是否为手机号码
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		Pattern pattern = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = pattern.matcher(mobiles);
		return m.matches();
	}
}
