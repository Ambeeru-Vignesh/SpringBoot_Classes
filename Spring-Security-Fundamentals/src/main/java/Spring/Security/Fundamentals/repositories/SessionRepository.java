package Spring.Security.Fundamentals.repositories;

import Spring.Security.Fundamentals.entities.Session;
import Spring.Security.Fundamentals.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByUser(User user);

    Optional<Session> findByRefreshToken(String refreshToken);
}
