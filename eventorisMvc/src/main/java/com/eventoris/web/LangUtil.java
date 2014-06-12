package com.eventoris.web;

public class LangUtil {

	public static String getRoMonthName(int monthNumber) {
		if (monthNumber > 12 || monthNumber < 1) {
			return "Ianuarie";
		}
		String lunileAnului[] = new String[] { "Ianuarie", "Februarie",
				"Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August",
				"Septembrie", "Octombrie", "Noiembrie", "Decembrie" };
		return lunileAnului[monthNumber - 1];
	}
}
