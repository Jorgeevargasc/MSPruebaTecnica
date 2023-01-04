package co.com.api.mspruebatecnica.application.movimiento;

import co.com.api.mspruebatecnica.entity.Movimiento;
import co.com.api.mspruebatecnica.dto.ResponseDto;

public interface IMovimientoApplication {

    ResponseDto consultarMovimientos();
    ResponseDto consultarMovimiento(int id);
    ResponseDto crearMovimientos(Movimiento movimiento);
    ResponseDto actualizarMovimiento(Movimiento movimiento);
    ResponseDto eliminarMovimiento(int id);

}
