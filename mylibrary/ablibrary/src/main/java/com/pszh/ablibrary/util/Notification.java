package com.pszh.ablibrary.util;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * 系统通知栏
 * @author 肖蕾
 */
public class Notification
{
	/**
	 * 在系统栏上显示一个点击自动消失的提示信息
	 * @param context	上下文
	 * @param NotuifiID 提示栏的ID
	 * @param IconID	图标ID
	 * @param showmsg	未打开显示滚动的文字
	 * @param title		拖下任务栏 看见的标题
	 * @param content	拖下任务栏 看见的文本
	 * @param intent	点击提示信息将要执行的操作
	 */
	public static void showNotification(Context context,int NotuifiID,int IconID,String showmsg,String title,String content,Intent intent)
	{
		show(context, android.app.Notification.FLAG_AUTO_CANCEL, NotuifiID, IconID, showmsg, title, content, intent);
	}
	/**
	 * 在系统栏上显示一个不会被清理的提示信息
	 * @param context	上下文
	 * @param NotuifiID 提示栏的ID
	 * @param IconID	图标ID
	 * @param showmsg	未打开显示滚动的文字
	 * @param title		拖下任务栏 看见的标题
	 * @param content	拖下任务栏 看见的文本
	 * @param intent	点击提示信息将要执行的操作
	 */
	public static void showNotificationNoClear(Context context,int NotuifiID,int IconID,String showmsg,String title,String content,Intent intent)
	{
		show(context, android.app.Notification.FLAG_NO_CLEAR, NotuifiID, IconID, showmsg, title, content, intent);
	}
	/**
	 * 在系统栏上显示一个一直存在的的提示信息
	 * @param context	上下文
	 * @param NotuifiID 提示栏的ID
	 * @param IconID	图标ID
	 * @param showmsg	未打开显示滚动的文字
	 * @param title		拖下任务栏 看见的标题
	 * @param content	拖下任务栏 看见的文本
	 * @param intent	点击提示信息将要执行的操作
	 */
	public static void showNotificationAlwaysIn(Context context,int NotuifiID,int IconID,String showmsg,String title,String content,Intent intent)
	{
		show(context, android.app.Notification.FLAG_INSISTENT, NotuifiID, IconID, showmsg, title, content, intent);
	}
//	查看http://blog.csdn.net/wwzqj/article/details/44098587
	@SuppressWarnings("deprecation")
	private static void show(Context context,int flags,int NotuifiID,int IconID,String showmsg,String title,String content,Intent intent)
	{
		//获取手机系统里的通知管理器
		NotificationManager NM = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		//实例化一个notification
		android.app.Notification notification = new android.app.Notification(IconID,showmsg,System.currentTimeMillis());
		notification.flags = flags;
		PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);
//		notification.setLatestEventInfo(context, title, content, pIntent);
		NM.notify(NotuifiID, notification);
//		高于API Level 11，低于API Level 16
//		Notification.Builder builder = new Notification.Builder(context)
//				.setAutoCancel(true)
//				.setContentTitle(title)
//				.setContentText(content)
//				.setContentIntent(pIntent)
//				.setSmallIcon(IconID)
//				.setWhen(System.currentTimeMillis())
//				.setOngoing(true);
//		notification=builder.getNotification();
		/*高于API Level 16
		*Notification notification = new Notification.Builder(context)
        *.setAutoCancel(true)
        * .setContentTitle("title")
        * .setContentText("describe")
        * .setContentIntent(pendingIntent)
        * .setSmallIcon(R.drawable.ic_launcher)
        * .setWhen(System.currentTimeMillis())
        * .build();
		*
		*
		*
		*
		* */
	}
}
