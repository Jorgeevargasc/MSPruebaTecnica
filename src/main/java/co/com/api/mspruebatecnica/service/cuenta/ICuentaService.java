package co.com.api.mspruebatecnica.service.cuenta;

import co.com.api.mspruebatecnica.entity.Cliente;
import co.com.api.mspruebatecnica.entity.Cuenta;

import java.util.List;

public interface ICuentaService {

    List<Cuenta> consultarCuentas();
    Cuenta consultarCuenta(int id);
    List<Cuenta> consultarCuentaPorCliente(Cliente cliente);
    Cuenta crearCuenta(Cuenta cuenta);
    Cuenta actualizarCuenta(Cuenta cuenta);
    Cuenta eliminarCuenta(int id);
}
