// TUDO OK

package date;

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
	
	public static String geraDataFormatada(Calendar data) {
		return String.format("%02d/%02d/%04d", data.get(Calendar.DATE), data.get(Calendar.MONTH) + 1, data.get(Calendar.YEAR)) ;
	}

}
