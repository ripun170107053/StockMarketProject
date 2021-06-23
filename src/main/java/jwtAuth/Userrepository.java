
package jwtAuth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface Userrepository extends JpaRepository<User, Long> {
public interface Userrepository extends JpaRepository<UserJ, Long>{
	
	


	Boolean existsByEmail(String email);
	
}
