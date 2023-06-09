package by.vsu.bank.repository;

import by.vsu.bank.model.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll(Pageable pageable);
}
