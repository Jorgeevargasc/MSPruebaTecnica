package co.com.api.mspruebatecnica.service.movimiento;

import co.com.api.mspruebatecnica.entity.Movimiento;

import java.util.List;

public interface IMovimientoService {

    List<Movimiento> consultarMovimientos();
    Movimiento consultarMovimiento(int id);
    Movimiento crearMovimiento(Movimiento movimiento);
    Movimiento actualizarMovimiento(Movimiento movimiento);
    Movimiento eliminarMovimiento(int id);
}
