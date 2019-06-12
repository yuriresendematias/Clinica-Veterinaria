package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static LocalDate parseDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date = LocalDate.parse(data,formatter);
	    
	    return date;
	}
	
	public static String parseDate(LocalDate data) {
		String date = "";
		Integer dia, mes, ano;
		
		dia = data.getDayOfMonth();
		mes = data.getMonthValue();
		ano = data.getYear(); 
		
		if(dia < 10) {
			date = "0";
		}
		date = date + dia.toString() + "/";
		
		if(mes < 10) {
			date = date + "0";
		}
		
		date = date + mes.toString() + "/" + ano.toString();
		
		
		
		return date;
	}
}
