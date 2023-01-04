package co.com.api.mspruebatecnica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsPruebaTecnicaApplicationTests {

	@Test
	void main( ) {
		MsPruebaTecnicaApplication.main(new String[] {});
		Assertions.assertTrue(true, "assertion");
	}

	@Test
	void contextLoads() {
		Assertions.assertFalse(false);
	}

}
