package co.com.api.mspruebatecnica.controller;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(properties = {"spring.datasource.url=jdbc:mysql://localhost:3306/sistema_transaccional?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"})
class MovimientoControllerTest {

    @Autowired
    MovimientoController controller;

    @Test
    void consultarMovimientosTest() throws Exception{
        ResponseEntity<ResponseDto> controllerResponse = controller.consultarMovimientos();
        assertNotNull(controllerResponse);
        assertNotNull(controllerResponse.getBody().getData());
        assertNotNull(controllerResponse.getBody().getMessage());
        Assertions.assertNotEquals(0, controllerResponse.getBody().getResponseCode());
    }

    @Test
    void consultarMovimientoTest() throws Exception{
        ResponseEntity<ResponseDto> controllerResponse = controller.consultarMovimiento(1);
        assertNotNull(controllerResponse);
        assertNotNull(controllerResponse.getBody().getData());
        assertNotNull(controllerResponse.getBody().getMessage());
        Assertions.assertNotEquals(0, controllerResponse.getBody().getResponseCode());
    }
}
