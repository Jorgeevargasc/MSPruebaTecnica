package co.com.api.mspruebatecnica.service.cliente;

import co.com.api.mspruebatecnica.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> consultarClientes();
    Cliente consultarCliente(int clienteId);
    Cliente consultarClientePorIdentificacion(String identificacion);
    Cliente crearClientes(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    Cliente eliminarCliente(int id);
}
