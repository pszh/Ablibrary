package com.pszh.ablibrary.util;

import android.app.Activity;
import android.content.Intent;

import org.apache.http.message.BasicNameValuePair;

@SuppressWarnings("deprecation")
public class AbIntentUtil {
	public static void startA(Activity activity, Class<?> c,
			BasicNameValuePair... name) {
		Intent intent = new Intent();
		intent.setClass(activity, c);
		for (int i = 0; i < name.length; i++) {
			intent.putExtra(name[i].getName(), name[i].getValue());
		}
		activity.startActivity(intent);
	}

	public static void startAR(Activity activity, Class<?> c, int requestCode,
			BasicNameValuePair... name) {
		Intent intent = new Intent();
		intent.setClass(activity, c);
		for (int i = 0; i < name.length; i++) {
			intent.putExtra(name[i].getName(), name[i].getValue());
		}
		activity.startActivityForResult(intent, requestCode);
	}
}
