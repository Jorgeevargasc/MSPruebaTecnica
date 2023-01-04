package co.com.api.mspruebatecnica.application.cliente;

import co.com.api.mspruebatecnica.entity.Cliente;
import co.com.api.mspruebatecnica.dto.ResponseDto;

public interface IClienteApplication {

    ResponseDto consultarClientes();
    ResponseDto consultarCliente(int id);
    ResponseDto crearClientes(Cliente cliente);
    ResponseDto actualizarCliente(Cliente cliente);
    ResponseDto eliminarCliente(int id);

}
