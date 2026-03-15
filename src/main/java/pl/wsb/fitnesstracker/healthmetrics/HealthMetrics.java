package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "healthmetrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private double weight;

    @Column(name = "resting_heart_rate", nullable = false)
    private double restingHeartRate;

    @Column(name = "sleep_hours", nullable = false)
    private double sleepHours;

    @Column(name = "calories_consumed", nullable = false)
    private double caloriesConsumed;
}
