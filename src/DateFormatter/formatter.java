package DateFormatter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class formatter {

	public static String fechaDevolucion(int dias) {
		// Primero coge el tiempo actual
		Date currentDate = new Date();

		// Damos el formato que queremos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		// Necesitamos el Calendar para poder avanzar el tiempo
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, dias);

		// Lo volvemos a convertir en un Date
		Date fecha_devolucion = c.getTime();

		// Finalmente lo pasamos a un Timestamp
		Timestamp timestamp = new Timestamp(fecha_devolucion.getTime());

		// Devolvemos la fecha con el formato indicado
		return dateFormat.format(timestamp);
	}
}
