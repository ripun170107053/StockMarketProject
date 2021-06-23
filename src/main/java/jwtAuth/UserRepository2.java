package jwtAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository2 extends CrudRepository<UserJ, Integer> {
    UserJ findByname(String username);
}