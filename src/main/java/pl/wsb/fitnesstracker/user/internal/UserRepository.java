package pl.wsb.fitnesstracker.user.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {

    // DODANO: Brakująca metoda wymagana przez UserServiceImpl
    Optional<User> findByEmail(String email);

    // Wyszukuje po fragmencie maila, ignorując wielkość liter
    List<User> findByEmailContainingIgnoreCase(String emailFragment);

    // Wyszukuje użytkowników starszych niż podana data (czyli urodzonych przed tą datą)
    List<User> findByBirthdateBefore(LocalDate time);
}