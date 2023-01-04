package co.com.api.mspruebatecnica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"spring.datasource.url=jdbc:mysql://localhost:3306/sistema_transaccional?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"})
class MsPruebaTecnicaApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertFalse(false);
	}

}
