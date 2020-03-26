package br.com.phfedev.phvalidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DataJpaTest
public class UserRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

}
