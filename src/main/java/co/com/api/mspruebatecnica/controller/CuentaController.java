package co.com.api.mspruebatecnica.controller;

import co.com.api.mspruebatecnica.application.cuenta.ICuentaApplication;
import co.com.api.mspruebatecnica.entity.Cuenta;
import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private ICuentaApplication cuentaApplication;

    @GetMapping
    public ResponseEntity<ResponseDto> consultarCuentas(){
        ResponseDto response = cuentaApplication.consultarCuentas();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> consultarCuenta(@PathVariable("id") int id){
        ResponseDto response = cuentaApplication.consultarCuenta(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> crearCuentas(@RequestBody Cuenta cuenta){
        ResponseDto response = cuentaApplication.crearCuentas(cuenta);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> actualizarCuenta(@RequestBody Cuenta cuenta){
        ResponseDto response = cuentaApplication.actualizarCuenta(cuenta);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> eliminarCuenta(@PathVariable("id") int id){
        ResponseDto response = cuentaApplication.eliminarCuenta(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }
}
