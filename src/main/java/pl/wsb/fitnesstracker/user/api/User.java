package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "Users") // Poprawiona nazwa tabeli (jedno 's')
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    // DODANE: firstName (
    @Column(name = "firstName", nullable = false)
    private String firstName;

    // DODANE: lastName
    @Column(name = "lastName", nullable = false)
    private String lastName;

    // POPRAWIONE: birthday
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false, unique = true)
    private String email;

    public User(
            final String firstName,
            final String lastName,
            final LocalDate birthday, // zmienione na birthday
            final String email) {

        this.firstName = firstName; // dodane
        this.lastName = lastName;   // dodane
        this.birthday = birthday;   // zmienione na birthday
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
    }

}

