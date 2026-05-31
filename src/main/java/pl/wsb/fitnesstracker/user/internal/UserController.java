package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserEmailDto;
import pl.wsb.fitnesstracker.user.api.UserSimpleDto;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller for managing User entities through REST API.
 */
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    /**
     * Zwraca wszystkich użytkowników (pełne dane).
     */
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthdate(), user.getEmail()))
                .toList();
    }

    /**
     * Zwraca wszystkich użytkowników (tylko podstawowe informacje).
     */
    @GetMapping("/simple")
    public List<UserSimpleDto> getSimpleUsers() {
        return userService.findAllUsers()
                .stream()
                .map(user -> new UserSimpleDto(user.getId(), user.getFirstName(), user.getLastName()))
                .toList();
    }

    /**
     * Zwraca szczegóły użytkownika na podstawie ID.
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUser(id)
                .map(user -> new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthdate(), user.getEmail()))
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    /**
     * Wyszukuje użytkowników po adresie e-mail.
     */
    @GetMapping("/email")
    public List<UserEmailDto> getUserByEmail(@RequestParam String email) {
        return userService.searchByEmail(email)
                .stream()
                .map(user -> new UserEmailDto(user.getId(), user.getEmail()))
                .toList();
    }

    /**
     * Zwraca użytkowników starszych niż podana data.
     */
    @GetMapping("/older/{time}")
    public List<UserDto> getOlderThan(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate time) {
        return userService.searchOlderThan(time)
                .stream()
                .map(user -> new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthdate(), user.getEmail()))
                .toList();
    }

    /**
     * Dodaje nowego użytkownika.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Oczekiwane przez test shouldPersistUser
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = new User(userDto.firstName(), userDto.lastName(), userDto.birthdate(), userDto.email());
        User savedUser = userService.createUser(user);
        return new UserDto(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getBirthdate(), savedUser.getEmail());
    }

    /**
     * Aktualizuje dane istniejącego użytkownika.
     */
    @PutMapping("/{userId}")
    public UserDto updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        User userToUpdate = new User(userDto.firstName(), userDto.lastName(), userDto.birthdate(), userDto.email());
        User updatedUser = userService.updateUser(userId, userToUpdate);
        return new UserDto(updatedUser.getId(), updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getBirthdate(), updatedUser.getEmail());
    }

    /**
     * Usuwa użytkownika z systemu.
     */
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Oczekiwane przez test shouldRemoveUserFromRepository
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}