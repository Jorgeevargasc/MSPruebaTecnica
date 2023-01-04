package co.com.api.mspruebatecnica.application.cliente;

import co.com.api.mspruebatecnica.entity.Cliente;
import co.com.api.mspruebatecnica.dto.ResponseDto;
import co.com.api.mspruebatecnica.service.cliente.IClienteService;
import co.com.api.mspruebatecnica.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ClienteApplication implements IClienteApplication{

    @Autowired
    IClienteService clienteService;

    @Autowired
    private ResponseUtil responseUtil;

    ResponseDto responseDto;

    @Override
    public ResponseDto consultarClientes() {
        responseDto = new ResponseDto();
        var clientes = clienteService.consultarClientes();
        if(clientes.isEmpty()) {
            responseDto.setMessage("No existen clientes");
            responseDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            responseDto.setData(null);
            return responseDto;
        }
        responseDto = responseUtil.createResponseDto(clientes);
        return responseDto;
    }

    @Override
    public ResponseDto consultarCliente(int id) {
        responseDto = new ResponseDto();
        var cliente = clienteService.consultarCliente(id);
        if(cliente == null ) {
            responseDto.setMessage("Cliente no existe");
            responseDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            responseDto.setData(null);
            return responseDto;
        }
        responseDto = responseUtil.createResponseDto(cliente);
        return responseDto;
    }

    @Override
    public ResponseDto crearClientes(Cliente cliente) {
        responseDto = new ResponseDto();
        var clienteLegacy = clienteService.crearClientes(cliente);
        responseDto = responseUtil.createResponseDto(clienteLegacy);
        return responseDto;
    }

    @Override
    public ResponseDto actualizarCliente(Cliente cliente) {
        responseDto = new ResponseDto();
        var clienteLegacy = clienteService.actualizarCliente(cliente);
        responseDto = responseUtil.createResponseDto(clienteLegacy);
        return responseDto;
    }

    @Override
    public ResponseDto eliminarCliente(int id) {
        responseDto = new ResponseDto();
        var clienteLegacy= clienteService.eliminarCliente(id);
        responseDto = responseUtil.createResponseDto(clienteLegacy);
        return responseDto;
    }
}
