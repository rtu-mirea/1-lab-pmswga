package Tasks.Task3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*!
    1. Определите, что строка является корректной датой в русском и американском формате.
    2. Дан текст. Замените все даты в американском формате, датами в русском формате.
 */

public class Task3 {

    private String text;
    private Pattern universalDateFormat; // Consist regexp of RUS and USA date formats
    private Pattern rusDateFormat; // Consist regexp of RUS date format

    public Task3(String text) {
        this.text = text;
        this.universalDateFormat = Pattern.compile("((0[1-9]|1[0-2]))[\\/\\.](0[1-9]|1[0-2])[\\/\\.](\\d{4})");
        this.rusDateFormat = Pattern.compile("((0[1-9]|1[0-2]))[\\/](0[1-9]|1[0-2])[\\/](\\d{4})");
    }

    public ArrayList<String> getValidatedDates() {
        ArrayList<String> dates = new ArrayList<String>();

        Matcher DateMatcher = this.universalDateFormat.matcher(text);
        while (DateMatcher.find()) {
            dates.add(text.substring(DateMatcher.start(), DateMatcher.end()));
        }

        return dates;
    }

    public ArrayList<String> usaDate2rusDate() {
        ArrayList<String> replacedDates = new ArrayList<String>();

        Matcher DateMatcher = rusDateFormat.matcher(text);
        while (DateMatcher.find()) {
            StringBuilder formattedDate = new StringBuilder();
            String []date = text.substring(DateMatcher.start(), DateMatcher.end()).split("/");

            formattedDate.append(date[1]);
            formattedDate.append(".");
            formattedDate.append(date[0]);
            formattedDate.append(".");
            formattedDate.append(date[2]);

            replacedDates.add(formattedDate.toString());
        }

        return replacedDates;
    }

}
