package co.edu.escuelaing.ieti.lvl2api.repository;

import co.edu.escuelaing.ieti.lvl2api.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    List<User> findByNameLikeOrLastNameLike(String cadena,String cadena2);
}
