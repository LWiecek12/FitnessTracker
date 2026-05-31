package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user The user to be created
     * @return The created user
     */
    User createUser(User user);

    /**
     * Retrieves all users currently existing in the system.
     *
     * @return List of all users
     */
    List<User> findAllUsers();

    /**
     * Retrieves a specific user by their unique ID.
     *
     * @param userId The ID of the user to find
     * @return An Optional containing the user if found, or empty otherwise
     */
    Optional<User> getUser(Long userId);

    /**
     * Deletes a user from the system based on their ID.
     *
     * @param userId The ID of the user to be deleted
     */
    void deleteUser(Long userId);

    /**
     * Searches for users by a fragment of their email address, ignoring case.
     *
     * @param emailFragment The email fragment to search for
     * @return List of matching users
     */
    List<User> searchByEmail(String emailFragment);

    /**
     * Searches for users who were born before the given date (older than).
     *
     * @param date The date to compare against
     * @return List of users older than the specified date
     */
    List<User> searchOlderThan(LocalDate date);

    /**
     * Updates an existing user's details.
     *
     * @param id The ID of the user to update
     * @param updatedUser The object containing new user data
     * @return The updated and saved user
     */
    User updateUser(Long id, User updatedUser);

}