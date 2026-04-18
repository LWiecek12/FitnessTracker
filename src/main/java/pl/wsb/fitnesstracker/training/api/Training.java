package pl.wsb.fitnesstracker.training.api;

import jakarta.persistence.*;
import lombok.AccessLevel;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.NoArgsConstructor;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;

@Entity
@Table(name = "Trainings")
@Entity
@Table(name = "trainings")
@Entity
@Table(name = "Trainings")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Wymagane
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Wymagane
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacja ManyToOne (wiele treningów przypisanych do jednego użytkownika)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    // Relacja ManyToOne (wiele treningów przypisanych do jednego użytkownika)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "startTime", nullable = false)
    @Column(name = "start_time", nullable = false)
    @Column(name = "startTime", nullable = false)
    private Date startTime;

    @Column(name = "endTime")
    @Column(name = "end_time", nullable = false)
    @Column(name = "endTime")
    private Date endTime;

    // Zakładam, że ActivityType to Enum. EnumType.STRING zapisze w bazie nazwę (np. "RUNNING"), a nie numerek.
    @Enumerated(EnumType.STRING)
    @Column(name = "activityType", nullable = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type", nullable = false)
    // Zakładam, że ActivityType to Enum. EnumType.STRING zapisze w bazie nazwę (np. "RUNNING"), a nie numerek.
    @Enumerated(EnumType.STRING)
    @Column(name = "activityType", nullable = false)
    private ActivityType activityType;

    @Column(name = "distance")
    @Column(nullable = false)
    @Column(name = "distance")
    private double distance;

    @Column(name = "averageSpeed")
    @Column(name = "average_speed", nullable = false)
    @Column(name = "averageSpeed")
    private double averageSpeed;

    public Training(
            final User user,
            final Date startTime,
            final Date endTime,
            final ActivityType activityType,
            final double distance,
            final double averageSpeed) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }
}
