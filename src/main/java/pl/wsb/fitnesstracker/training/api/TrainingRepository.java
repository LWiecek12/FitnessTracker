package pl.wsb.fitnesstracker.training.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrainingRepository extends JpaRepository<Training, Long> {


    // Odwołujemy się bezpośrednio do tabel z bazy danych ('trainings') i kolumn ('distance', 'user_id')
    @Query(
            value = "SELECT SUM(distance) FROM trainings WHERE user_id = :userId",
            nativeQuery = true
    )
    Double calculateTotalDistanceForUser(@Param("userId") Long userId);
}