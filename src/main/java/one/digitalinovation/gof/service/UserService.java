package one.digitalinovation.gof.service;

import one.digitalinovation.gof.model.User;

import java.util.Optional;

/**
 * Interface that defines the strategy pattern
 */
public interface UserService {
    Iterable<User> findAll();

    Optional<User> findById(Long id);

    User insert(User user);

    void update(Long id, User newUserData);

    boolean delete(Long id);
}
