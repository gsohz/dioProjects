package edu.gsohz.santander_dw23.domain.repository;

import edu.gsohz.santander_dw23.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
