package co.com.api.mspruebatecnica.controller;

import co.com.api.mspruebatecnica.application.cliente.IClienteApplication;
import co.com.api.mspruebatecnica.entity.Cliente;
import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private IClienteApplication clienteApplication;

    @GetMapping
    public ResponseEntity<ResponseDto> consultarClientes(){
        ResponseDto response = clienteApplication.consultarClientes();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> consultarCliente(@PathVariable("id") int id){
        ResponseDto response = clienteApplication.consultarCliente(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @PostMapping
    public ResponseEntity<ResponseDto> crearCliente(@RequestBody Cliente cliente){
        ResponseDto response = clienteApplication.crearClientes(cliente);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> actualizarCliente(@RequestBody Cliente cliente){
        ResponseDto response = clienteApplication.actualizarCliente(cliente);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDto> eliminarCliente(@PathVariable("id") int id){
        ResponseDto response = clienteApplication.eliminarCliente(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }
}
