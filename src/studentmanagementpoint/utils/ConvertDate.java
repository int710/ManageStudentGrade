
package studentmanagementpoint.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bùi Thanh Quân - int710 - CT070242
 */
public class ConvertDate {
   public static String convertDateFormat(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = inputFormat.parse(dateString);
        String formattedDate = outputFormat.format(date);
        return formattedDate;
    }
    
    public static String formatDobToDB(String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(dob);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    
}
