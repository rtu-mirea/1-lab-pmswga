package tasks.Task3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private String text;

    public Task3(String text) {
        this.text = text;
    }

    public ArrayList<String> getValidatedDates() {
        ArrayList<String> dates = new ArrayList<String>();

        Pattern dateFormat = Pattern.compile("((0[1-9]|1[0-2]))[\\/\\.](0[1-9]|1[0-2])[\\/\\.](\\d{4})");

        Matcher DateMatcher = dateFormat.matcher(text);
        while (DateMatcher.find()) {
            dates.add(text.substring(DateMatcher.start(), DateMatcher.end()));
        }

        return dates;
    }

    public ArrayList<String> usaDate2rusDate() {
        ArrayList<String> replacedDates = new ArrayList<String>();

        Pattern dateFormat = Pattern.compile("((0[1-9]|1[0-2]))[\\/](0[1-9]|1[0-2])[\\/](\\d{4})");

        Matcher DateMatcher = dateFormat.matcher(text);
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
