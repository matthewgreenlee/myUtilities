package com.goldenpond.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.goldenpond.utils.Print;

public class MessageUtil {

	private static Locale locale = Locale.SIMPLIFIED_CHINESE;

	private static final String DEFAULT_KEY = "default.key";

	public static String getMessage(String code) {
		return getText(code, null);
	}

	public static String getMessage(String code, String arg) {
		return getText(code, new String[]{arg});
	}

	public static String getMessage(String code, String arg1, String arg2) {
		return getText(code, new String[]{arg1, arg2});
	}

	public static String getText(String code, String[] args) {
		
		ResourceBundle results = ResourceBundle.getBundle("com.goldenpond.i18n.Message", locale, new UTF8Control());
		String val = null;
		try {
			val = results.getString(code);
		}
		catch (MissingResourceException e) {
			val = results.getString(DEFAULT_KEY);
		}
		return MessageFormat.format(val, (Object[])args);
	}

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("com.goldenpond.i18n.Message", new UTF8Control());
		Print.ln(rb.getString("key1"));
		Print.ln(rb.getString("key2"));
		Print.ln(rb.getString("key3"));
		
		ResourceBundle.clearCache();
		ResourceBundle rb2 = ResourceBundle.getBundle("com.goldenpond.i18n.Message", new UTF8Control());
		Print.ln(rb2.getString("key1"));
		Print.ln(rb2.getString("key2"));
		Print.ln(rb2.getString("key3"));
	}
}
