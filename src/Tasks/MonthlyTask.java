package Tasks;

import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable{

    public MonthlyTask(String title, String description, int year, int month, int day, int hours, int mins) {
        super(title, description, year, month, day, hours, mins);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestDate) {
        return getDate().getDayOfMonth() == (requestDate.getDayOfMonth());
    }
}
