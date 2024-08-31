package data;

import java.util.Calendar;

public class CalculaData {
	
	public CalculaData() {}
	
	public static Calendar obterDataAtual() {       
		Calendar calendar = Calendar.getInstance();
		return calendar;
    }
	
	public static Calendar prazoEstimado (int limiteDiasEmprestimo) {       
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, limiteDiasEmprestimo);
       return calendar;
    }

}
