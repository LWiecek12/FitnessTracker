package pl.wsb.fitnesstracker.statistics.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.user.api.User; // import Usera
import pl.wsb.fitnesstracker.user.api.User;

@Entity
@Table(name = "statistics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    // DODANO RELACJĘ ( OneToOne)
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // DODANO @Column dla pewności mapowania
    @Column(name = "totalTrainings", nullable = false)
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "total_trainings", nullable = false)
    private int totalTrainings;

    @Column(name = "totalDistance")
    @Column(name = "total_distance", nullable = false)
    private double totalDistance;

    @Column(name = "totalCaloriesBurned")
    @Column(name = "total_calories_burned", nullable = false)
    private int totalCaloriesBurned;

    // POPRAWIONO KONSTRUKTOR: Musi przyjmować też Usera
    public Statistics(User user, int totalTrainings, double totalDistance, int totalCaloriesBurned) {
        this.user = user;
    public Statistics(User user, int totalTrainings, double totalDistance, int totalCaloriesBurned) {
        this.user = user;
        this.totalTrainings = totalTrainings;
        this.totalDistance = totalDistance;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }
}
