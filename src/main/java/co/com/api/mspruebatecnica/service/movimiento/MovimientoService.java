package co.com.api.mspruebatecnica.service.movimiento;

import co.com.api.mspruebatecnica.entity.Movimiento;
import co.com.api.mspruebatecnica.exceptions.BadRequestException;
import co.com.api.mspruebatecnica.exceptions.CallLegacyException;
import co.com.api.mspruebatecnica.exceptions.PreconditionException;
import co.com.api.mspruebatecnica.repository.ICuentaRepository;
import co.com.api.mspruebatecnica.repository.IMovimientoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovimientoService implements IMovimientoService{

    public static final String ERROR = "Error enviando petición al legado ";

    @Autowired
    IMovimientoRepository movimientoRepository;

    @Autowired
    ICuentaRepository cuentaRepository;

    @Override
    public List<Movimiento> consultarMovimientos() {
        List<Movimiento> listaMovimientos;
        try {
            listaMovimientos = movimientoRepository.findAll();
            return listaMovimientos;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Movimiento consultarMovimiento(int id) {
        var movimiento = new Movimiento();
        try {
            movimiento = movimientoRepository.findById(id);
            return movimiento;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {
        try {
            var cuentaDB = cuentaRepository.findById(movimiento.getCuenta().getId());
            if(movimiento.getValor() <= 0) {
                movimiento.setTipoMovimiento("debito");
                if(cuentaDB.getSaldoInicial() == 0) {
                    throw new PreconditionException("Saldo no disponible");
                }
                movimiento.setSaldo(cuentaDB.getSaldoInicial() + movimiento.getValor());
                return movimientoRepository.save(movimiento);
            }
            movimiento.setTipoMovimiento("credito");
            movimiento.setSaldo(cuentaDB.getSaldoInicial() + movimiento.getValor());
            return movimientoRepository.save(movimiento);
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        try {
            var movimientoDB = movimientoRepository.findById(movimiento.getId());
            if(movimientoDB == null) {
                throw new BadRequestException("Movimiento a actualizar no existe");
            }
            movimientoDB = movimientoRepository.save(movimiento);
            return movimientoDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }

    @Override
    public Movimiento eliminarMovimiento(int id) {
        try {
            var movimientoDB = movimientoRepository.findById(id);
            if(movimientoDB == null) {
                throw new BadRequestException("Movimiento a eliminar no existe");
            }
            cuentaRepository.deleteById(movimientoDB.getId());
            return movimientoDB;
        } catch (Exception e) {
            log.error(ERROR + e);
            throw new CallLegacyException(ERROR + e);
        }
    }
}
