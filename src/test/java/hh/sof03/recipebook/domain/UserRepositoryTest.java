package hh.sof03.recipebook.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUserName() {
		List<User> users = userRepository.findUserByUsername("user");
		
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getId()).isEqualTo(1);
	}
	
	@Test
	public void createNewUser() {
		User user = new User("Jouni", "$2a$10$cm3MY3erVp08U8WjkTHb4e9qJc.onDW2EkrpruPCs5hbxyD1.p0b6", "USER");
		userRepository.save(user);
		
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteAllUsers() {
		userRepository.deleteAll();
		
		assertThat(userRepository.count()).isEqualTo(0);
	}
	
}
