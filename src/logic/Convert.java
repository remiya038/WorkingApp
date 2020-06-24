package logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Convert {

	//Timestamp型→String型("yyyy-MM-dd)
	public String dateStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(timestamp);
		return dateStr;
	}

	//Timestamp型→String型(HH:mm)
	public String timeStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String timeStr = sdf.format(timestamp);
		return timeStr;
	}
	//文字列yyyy-MM-dd HH:mmをtimestamp型に
	public Timestamp strTimestamp(String timeStr){
		Timestamp timestamp = Timestamp.valueOf(timeStr);
		return timestamp;
	}

	//Timestamp型→String型("yyyy-MM-dd HH:mm)
	public String dayStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dayStr = sdf.format(timestamp);
		return dayStr;
	}



}
