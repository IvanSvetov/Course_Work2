package Tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {

    public YearlyTask(String title, String description, LocalDateTime date) {
        super(title, description, date);
    }

    @Override
    public boolean isTaskactiveAt(LocalDate date) {
        return date.isEqual(getDate().toLocalDate().withYear(date.getYear()));
    }
}
