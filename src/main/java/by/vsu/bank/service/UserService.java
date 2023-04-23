package by.vsu.bank.service;

import by.vsu.bank.exception.ResourceNotFoundException;
import by.vsu.bank.model.user.User;
import by.vsu.bank.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


// todo update user?

//    public User updateUser(User user) {
//        return userRepository.
//    }

    public User findUserById(long id) {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if(optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("UserService", id);
        }
        return optionalUser.get();
    }

    public List<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
