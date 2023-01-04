package co.com.api.mspruebatecnica.controller;

import co.com.api.mspruebatecnica.application.movimiento.IMovimientoApplication;
import co.com.api.mspruebatecnica.entity.Movimiento;
import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private IMovimientoApplication movimientoApplication;

    @GetMapping
    public ResponseEntity<ResponseDto> consultarMovimientos(){
        var response = movimientoApplication.consultarMovimientos();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> consultarMovimiento(@PathVariable("id")int id){
        var response = movimientoApplication.consultarMovimiento(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> crearMovimientos(@RequestBody Movimiento movimiento){
        var response = movimientoApplication.crearMovimientos(movimiento);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @PutMapping
        public ResponseEntity<ResponseDto> actualizarMovimiento(@RequestBody Movimiento movimiento){
        var response = movimientoApplication.actualizarMovimiento(movimiento);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> eliminarMovimiento(@PathVariable("id") int id){
        var response = movimientoApplication.eliminarMovimiento(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }
}
