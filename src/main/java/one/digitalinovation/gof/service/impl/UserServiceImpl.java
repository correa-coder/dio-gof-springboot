package one.digitalinovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.gof.model.Address;
import one.digitalinovation.gof.model.AddressRepository;
import one.digitalinovation.gof.model.User;
import one.digitalinovation.gof.model.UserRepository;
import one.digitalinovation.gof.service.UserService;
import one.digitalinovation.gof.service.ViaCepResponseAdapter;

import java.util.Optional;

/**
 * <b>Design patterns:</b>
 * <ul>
 * <li><b>Singleton:</b> Inject components with <code>@Autowired</code></li>
 * <li><b>Strategy:</b> Implements the methods defined in the interface</li>
 * <li><b>Facade:</b> Abstracts integrations with subsystems</li>
 * <li><b>Adapter:</b> Adapts Via CEP API Response to Address object</li>
 * </ul>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepResponseAdapter viaCepService;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User insert(User user) {
        // check if user address already exists
        String postalCode = user.getAddress().getPostalCode();
        Address address = addressRepository.findById(postalCode).orElseGet(() -> {
            // if does not exist, access the Via CEP API to get the address
            Address newAddress = viaCepService.getAdaptedAddress(postalCode);
            return addressRepository.save(newAddress);
        });
        user.setAddress(address);
        return userRepository.save(user);
    }

    @Override
    public void update(Long id, User newUserData) {
        // check if user exists first
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            insert(existingUser.get());
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }
}
