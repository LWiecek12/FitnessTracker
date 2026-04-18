package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.training.api.Training;
import java.time.LocalDateTime;

@Entity
@Table(name = "workout_session")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Zmienione z trainingId na relację do obiektu Training
    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    // Zmienione ze String na LocalDateTime
    @Column(nullable = false)
    private LocalDateTime timestamp;

    private String startGps;
    private String endGps;
    private Double altitude;

    public WorkoutSession(Training training, LocalDateTime timestamp, String startGps, String endGps, Double altitude) {
        this.training = training;
        this.timestamp = timestamp;
        this.startGps = startGps;
        this.endGps = endGps;
        this.altitude = altitude;
    }
}