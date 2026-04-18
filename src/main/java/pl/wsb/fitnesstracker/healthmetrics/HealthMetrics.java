package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
@Table(name = "health_metrics") // Zostawiamy jedną, poprawną nazwę z podkreślnikiem
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacja: Wiele pomiarów należy do jednego użytkownika
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "heart_rate", nullable = false)
    private int heartRate;

    // Jeden czysty konstruktor do tworzenia obiektów
    public HealthMetrics(User user, LocalDate date, double weight, double height, int heartRate) {
        this.user = user;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }
}