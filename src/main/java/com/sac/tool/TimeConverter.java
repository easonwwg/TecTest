package com.sac.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {
	// private static Date base2000 = new Date(2000, 1, 1, 0, 0, 0);
	// private static Date base1976 = new Date(1976, 1, 1, 0, 0, 0);

	private static Date base2000 = null;
	private static Date base1970 = null;

	static {
		try {
			base2000 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2000-01-01 00:00:00");
			base1970 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1970-01-01 08:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// 2000的秒数
	public static int getTimeFromBase2000(Date dateTime) {
		return (int) (dateTime.getTime() / 1000 - base2000.getTime() / 1000);
	}

	// 19700的秒数
	public static long getTimeFromBase1970(Date dateTime) {
		return (long) (dateTime.getTime() - base1970.getTime());
	}

	public static Date getDatefrom2000(int seconds) {
		Date dt = new Date(base2000.getTime() + ((long) seconds) * 1000);
		return dt;
	}

	public static Date getDatefrom1970(long miliseconds) {
//		Date dt = new Date(base1970.getTime() + miliseconds);
//		return dt;
		Date dt = new Date(base1970.getTime() + miliseconds);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		calendar.setTime(dt);
		Date tt = calendar.getTime();
		return calendar.getTime();
	}

	public static long from2000To1970(int seconds) {
		return getTimeFromBase1970(getDatefrom2000(seconds));
	}

	public static int from1970To2000(long miliseconds) {
		return getTimeFromBase2000(getDatefrom1970(miliseconds));
	}

	/**
	 * 不要超过一天
	 * 
	 * @param dt
	 * @param baseSecond
	 *            秒值，分钟
	 * @return
	 */
	public static Date adjustDate(Date dt, int baseSecond) {
		long second = dt.getTime() / 1000;
		return new Date((second - second % baseSecond) * 1000);

	}

	public static Date toDayUse1970(long miliseconds) {
		Date dt = new Date(base1970.getTime() + miliseconds);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		calendar.setTime(dt);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	// 获取日期，时分秒为 00:00:00
	// long miliseconds = System.currentTimeMillis();
	public static Date getDate(long miliseconds) {
		long nowdt = miliseconds / (86400 * 1000) * (86400 * 1000) - 8 * 3600 * 1000;
		Date nn = new Date(nowdt);

		return nn;
	}
	
	public static Date strToDate(String format,String date) {
		Date dt=null;
		try {
			dt = new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}

	public static Calendar getCalendar(Date dt) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		calendar.setTime(dt);
		return calendar;
	}

	public static void main(String[] args) throws InterruptedException {
		long mili = System.currentTimeMillis();
		//getDate与toDayUse1970方法作用一样
		Date dt = getDate(mili);
		Date dt2 = toDayUse1970(mili);
		for (int i = 0; i < 100; i++) {
			System.out.println(adjustDate(new Date(), 4));
			Thread.sleep(1000);
		}
	}
}
