package by.vsu.bank.service.impl;

import by.vsu.bank.exception.ResourceNotFoundException;
import by.vsu.bank.model.user.User;
import by.vsu.bank.repository.UserRepository;
import by.vsu.bank.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if(!userRepository.existsById(user.getId())) {
            throw new ResourceNotFoundException(UserServiceImpl.class.getSimpleName(), user.getId());
        }
    return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new ResourceNotFoundException(UserService.class.getSimpleName(), id);
        }
        return optionalUser.get();
    }

    @Override
    public List<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteUserById(long id) {
        if(!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(UserService.class.getSimpleName(), id);
        }
        userRepository.deleteById(id);
    }
}
