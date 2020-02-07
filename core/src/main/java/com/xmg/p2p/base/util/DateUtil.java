package com.xmg.p2p.base.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DateUtil {

	/**
	 * 得到一天的最后一秒钟
	 * 
	 * @param d
	 * @return
	 */
	public static Date endOfDay(Date d) {
		return DateUtils.addSeconds(
				DateUtils.addDays(DateUtils.truncate(d, Calendar.DATE), 1), -1);
	}

	/**
	 * 两个时间的间隔秒
	 * 
	 * @return
	 */
	public static long secondsBetween(Date d1, Date d2) {
		return Math.abs((d1.getTime() - d2.getTime()) / 1000);
	}
}