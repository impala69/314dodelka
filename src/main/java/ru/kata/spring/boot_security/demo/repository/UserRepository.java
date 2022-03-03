package ru.kata.spring.boot_security.demo.repository;



import org.springframework.data.repository.query.Param;
import ru.kata.spring.boot_security.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUserByEmail(@Param("email") String email);
}