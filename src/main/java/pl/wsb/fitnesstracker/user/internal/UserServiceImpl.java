package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
class UserServiceImpl implements UserService, UserProvider {

    private final UserRepository userRepository;

    @Override
    public User createUser(final User user) {
        log.info("Creating User {}", user);
        if (user.getId() != null) {
            throw new IllegalArgumentException("User has already DB ID, update is not permitted!");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(final Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> getUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // --- NOWE METODY DODANE DO ZADANIA LAB04 ---

    @Override
    public void deleteUser(final Long userId) {
        log.info("Deleting User with ID {}", userId);
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> searchByEmail(final String emailFragment) {
        log.info("Searching users by email fragment: {}", emailFragment);
        return userRepository.findByEmailContainingIgnoreCase(emailFragment);
    }

    @Override
    public List<User> searchOlderThan(final LocalDate date) {
        log.info("Searching users older than: {}", date);
        return userRepository.findByBirthdateBefore(date);
    }

    @Override
    public User updateUser(final Long id, final User updatedUser) {
        log.info("Updating User with ID {}", id);

        // Szukamy użytkownika po ID, jak jest to go aktualizujemy, jak nie - rzucamy wyjątek
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setBirthdate(updatedUser.getBirthdate());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));
    }
}