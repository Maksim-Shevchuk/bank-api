package by.vsu.bank.repository;

import by.vsu.bank.model.user.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();
}
