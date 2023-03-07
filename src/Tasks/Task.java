package Tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task implements Comparable {
    public static List<Task> taskList = new ArrayList<>();
    final private long id;
    private static long count = 1;
    private String title;
    private String description;
    final private LocalDateTime date;

    public Task(String title, String description, LocalDateTime date) {

        this.title = title;
        this.description = description;
        this.date = date;
        this.id = count++;
    }
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public boolean isTaskactiveAt(LocalDate date) {
        return true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


}
