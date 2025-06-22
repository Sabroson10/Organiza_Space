package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabajo.arqweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
