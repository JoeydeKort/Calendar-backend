package be.intecbrussel.CalendarBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CalenderTask {
    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String description;
    private Date startDateTime;
    private Date endDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalenderTask that = (CalenderTask) o;
        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(startDateTime, that.startDateTime) && Objects.equals(endDateTime, that.endDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, startDateTime, endDateTime);
    }
}
