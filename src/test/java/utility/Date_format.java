package utility;

import java.util.Date;

public class Date_format {

	public static String date_format() {
		// TODO Auto-generated method stub

		Date d1 = new Date();

		// System.out.println(d1.getTime());

		Date d2 = new Date(d1.getTime());

		// System.out.println(d2);

		String format1 = d2.toString();

		// System.out.println(format1);

		String day = format1.substring(8, 10);

		String month = format1.substring(4, 7);

		String year = format1.substring(format1.length() - 4);

		String hhh = format1.substring(11, 13);

		String mmm = format1.substring(14, 16);

		String sss = format1.substring(17, 19);

		/*
		 * //String year = format1.substring(format1.length()-4);
		 * 
		 * System.out.println(month); System.out.println(year); System.out.println(hhh);
		 * System.out.println(mmm); System.out.println(sss);
		 */
		String current_date = day.concat("_").concat(month).concat("_").concat(year).concat("_").concat(hhh).concat("_")
				.concat(mmm).concat("_").concat(sss);

		return current_date;
	}

}
