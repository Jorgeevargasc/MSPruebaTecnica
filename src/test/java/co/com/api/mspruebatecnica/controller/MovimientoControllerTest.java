package co.com.api.mspruebatecnica.controller;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
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
