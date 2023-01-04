package co.com.api.mspruebatecnica.application.cuenta;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import co.com.api.mspruebatecnica.entity.Cuenta;

public interface ICuentaApplication {

    ResponseDto consultarCuentas();
    ResponseDto consultarCuenta(int id);
    ResponseDto crearCuentas(Cuenta cuenta);
    ResponseDto actualizarCuenta(Cuenta cuenta);
    ResponseDto eliminarCuenta(int id);

}
