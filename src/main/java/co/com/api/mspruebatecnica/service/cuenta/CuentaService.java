package co.com.api.mspruebatecnica.service.cuenta;

import co.com.api.mspruebatecnica.entity.Cliente;
import co.com.api.mspruebatecnica.entity.Cuenta;
import co.com.api.mspruebatecnica.exceptions.BadRequestException;
import co.com.api.mspruebatecnica.exceptions.CallLegacyException;
import co.com.api.mspruebatecnica.repository.ICuentaRepository;
import co.com.api.mspruebatecnica.service.cliente.IClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CuentaService implements ICuentaService{

    public static final String ERROR = "Error enviando petición al legado ";

    @Autowired
    ICuentaRepository cuentaRepository;

    @Autowired
    IClienteService clienteService;

    @Override
    public List<Cuenta> consultarCuentas() {
        List<Cuenta> listaCuentas;
        try {
            listaCuentas = cuentaRepository.findAll();
            return listaCuentas;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cuenta consultarCuenta(int id) {
        var cuenta = new Cuenta();
        try {
            cuenta = cuentaRepository.findById(id);
            return cuenta;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public List<Cuenta> consultarCuentaPorCliente(Cliente cliente) {
        List<Cuenta> listaCuentas;
        try {
            listaCuentas = cuentaRepository.findByCliente(cliente);
            return listaCuentas;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        try {
            var cuentaDB = cuentaRepository.findById(cuenta.getId());
            if(cuentaDB != null) {
                throw new BadRequestException("Cuenta ya existe");
            }
            cuentaDB = cuentaRepository.save(cuenta);
            return cuentaDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        try {
            var cuentaDB = cuentaRepository.findById(cuenta.getId());
            if(cuentaDB == null) {
                throw new BadRequestException("Cuenta a actualizar no existe");
            }
            cuentaDB = cuentaRepository.save(cuenta);
            return cuentaDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Cuenta eliminarCuenta(int id) {
        try {
            var cuentaDB = cuentaRepository.findById(id);
            if(cuentaDB == null) {
                throw new BadRequestException("Cuenta a eliminar no existe");
            }
            cuentaRepository.deleteById(cuentaDB.getId());
            return cuentaDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }
}
