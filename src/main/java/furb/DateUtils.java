// Luan Raithz Machado
package furb;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static MaskFormatter DATA_MASK;
    public static MaskFormatter HORA_MASK;

    public static DateTimeFormatter DATA_FORMAT =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter HORA_FORMAT =  DateTimeFormatter.ofPattern("H:m");
    static {
        try {
            DATA_MASK = new MaskFormatter("##/##/####");
            HORA_MASK = new MaskFormatter("##:##");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
