package co.com.api.mspruebatecnica.service.cliente;

import co.com.api.mspruebatecnica.entity.Cliente;
import co.com.api.mspruebatecnica.exceptions.BadRequestException;
import co.com.api.mspruebatecnica.exceptions.CallLegacyException;
import co.com.api.mspruebatecnica.repository.IClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClienteService implements IClienteService{

    public static final String ERROR = "Error enviando petición al legado ";

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public List<Cliente> consultarClientes() {
        List<Cliente> listaClientes;
        try {
            listaClientes = clienteRepository.findAll();
            return listaClientes;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cliente consultarCliente(int clienteId) {
        var cliente = new Cliente();
        try {
            cliente = clienteRepository.findByClienteId(clienteId);
            return cliente;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cliente consultarClientePorIdentificacion(String identificacion) {
        var cliente = new Cliente();
        try {
            cliente = clienteRepository.findByIdentificacion(identificacion);
            return cliente;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cliente crearClientes(Cliente cliente) {
        try {
            var clienteDB = clienteRepository.findByClienteId(cliente.getClienteId());
            if(clienteDB != null) {
                throw new BadRequestException("Cliente ya existe");
            }
            clienteDB = clienteRepository.save(cliente);
            return clienteDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        try {
            var clienteDB = clienteRepository.findByClienteId(cliente.getClienteId());
            if(clienteDB == null) {
                throw new BadRequestException("Cliente a actualizar no existe");
            }
            clienteDB = clienteRepository.save(cliente);
            return clienteDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cliente eliminarCliente(int id) {
        try {
            var clienteDB = clienteRepository.findByClienteId(id);
            if(clienteDB == null) {
                throw new BadRequestException("Cliente a eliminar no existe");
            }
            clienteRepository.deleteById(clienteDB.getClienteId());
            return clienteDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }
}
