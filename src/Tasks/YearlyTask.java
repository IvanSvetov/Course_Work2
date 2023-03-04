package Tasks;

import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeatable {

    public YearlyTask(String title, String description, int year, int month, int day, int hours, int mins) {
        super(title, description, year, month, day, hours, mins);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestDate) {
        return getDate().getDayOfYear() == (requestDate.getDayOfYear());
    }
}
