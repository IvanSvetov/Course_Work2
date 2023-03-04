package Tasks;
import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable{

    public DailyTask(String title, String description, int year, int month, int day, int hours, int mins) {
        super(title, description, year, month, day, hours, mins);
    }

    @Override
    public boolean checkOccurance(LocalDateTime requestDate) {
        return getDate().toLocalDate().equals(requestDate.toLocalDate());
    }
}
