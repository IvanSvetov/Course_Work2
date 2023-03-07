package Tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {

    public WeeklyTask(String title, String description, LocalDateTime date) {
        super(title, description, date);
    }

    @Override
    public boolean isTaskactiveAt(LocalDate date) {
        return date.isEqual(getDate().toLocalDate().plusWeeks(1));
    }
}
