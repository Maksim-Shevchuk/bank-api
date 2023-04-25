package by.vsu.bank.service;

import by.vsu.bank.model.user.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    User findById(long id);

    List<User> findAll(Pageable pageable);

    void deleteUserById(long id);
}
