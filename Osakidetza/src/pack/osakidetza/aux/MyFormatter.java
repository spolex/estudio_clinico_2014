package pack.osakidetza.aux;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class MyFormatter 
{
	public static Date parseSQLDate(final String fecha) {
		try 
		{
			java.sql.Date pFecha = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(fecha).getTime());
			return pFecha;
		} 
		catch (ParseException e1) 
		{
			JOptionPane.showMessageDialog(null, "Incompatibilidad en el formato de fechas", "Control Estudios patológicos", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
