package pl.wsb.fitnesstracker.event;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // TO JEST TO POLE, KTÓREGO BRAKOWAŁO:
    @Column(name = "start_date")
    private LocalDate startDate;

    public Event(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
}