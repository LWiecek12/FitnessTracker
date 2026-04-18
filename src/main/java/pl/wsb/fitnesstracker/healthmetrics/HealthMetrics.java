package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.annotation.Nullable;
package pl.wsb.fitnesstracker.healthmetrics; // upewnij się, że pakiet się zgadza

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
@Table(name = "Health_Metrics")
@Table(name = "healthmetrics")
@Table(name = "health_metrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    // DODANO RELACJĘ (Wiele pomiarów -> Jeden użytkownik)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "weight")
    private double weight;

    @Column(nullable = false)
    private double height;
    // DODANO ZGODNIE ZE SCHEMATEM: height
    @Column(name = "height")
    private double height;

    @Column(name = "heart_rate", nullable = false)
    private int heartRate;
    // DODANO ZGODNIE ZE SCHEMATEM: heartRate
    @Column(name = "heartRate")
    private int heartRate;

    public HealthMetrics(User user, LocalDate date, double weight, double height, int heartRate) {
        this.user = user;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }
    // Opcjonalnie: Konstruktor do wygodnego tworzenia obiektów
    public HealthMetrics(User user, LocalDate date, double weight, double height, int heartRate) {
        this.user = user;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }
}