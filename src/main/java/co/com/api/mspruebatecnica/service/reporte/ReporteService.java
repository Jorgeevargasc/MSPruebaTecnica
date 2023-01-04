package co.com.api.mspruebatecnica.service.reporte;

import co.com.api.mspruebatecnica.entity.Cuenta;
import co.com.api.mspruebatecnica.entity.Movimiento;
import co.com.api.mspruebatecnica.dto.ReporteDto;
import co.com.api.mspruebatecnica.exceptions.CallLegacyException;
import co.com.api.mspruebatecnica.repository.IMovimientoRepository;
import co.com.api.mspruebatecnica.service.cliente.IClienteService;
import co.com.api.mspruebatecnica.service.cuenta.ICuentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ReporteService implements IReporteService{

    @Autowired
    IClienteService clienteService;

    @Autowired
    ICuentaService cuentaService;

    @Autowired
    IMovimientoRepository movimientoRepository;

    @Override
    public List<ReporteDto> generarReporte(Date fechaInicial, Date fechaFinal, String identificacion) {
        ReporteDto reporteDto = new ReporteDto();
        Cuenta cuenta1;
        Cuenta cuenta2;
        List<ReporteDto> listaReportes = new ArrayList<>();
        try {
            var clienteDB = clienteService.consultarClientePorIdentificacion(identificacion);
            reporteDto.setCliente(clienteDB.getNombre());
            var listaCuentas = cuentaService.consultarCuentaPorCliente(clienteDB);
            cuenta1 = listaCuentas.get(0);
            reporteDto.setNumCuenta(cuenta1.getNumCuenta());
            reporteDto.setTipo(cuenta1.getTipoCuenta());
            reporteDto.setSaldoInicial(cuenta1.getSaldoInicial());
            reporteDto.setEstado(cuenta1.isEstado());
            var movimientos = movimientoRepository.listarMovimientos(fechaInicial, fechaFinal, cuenta1.getId());
            for (Movimiento movimiento: movimientos) {
                reporteDto.setFecha(movimiento.getFecha());
                reporteDto.setMovimiento(movimiento.getValor());
                reporteDto.setSaldoDisponible(movimiento.getSaldo());
                listaReportes.add(reporteDto);
            }
            if(listaCuentas.size() > 1) {
                cuenta2 = listaCuentas.get(1);
                reporteDto.setNumCuenta(cuenta2.getNumCuenta());
                reporteDto.setTipo(cuenta2.getTipoCuenta());
                reporteDto.setSaldoInicial(cuenta2.getSaldoInicial());
                reporteDto.setEstado(cuenta2.isEstado());
                var movimientos2 = movimientoRepository.listarMovimientos(fechaInicial, fechaFinal, cuenta2.getId());
                for (Movimiento movimiento: movimientos2) {
                    reporteDto.setFecha(movimiento.getFecha());
                    reporteDto.setMovimiento(movimiento.getValor());
                    reporteDto.setSaldoDisponible(movimiento.getSaldo());
                    listaReportes.add(reporteDto);
                }
            }
            return  listaReportes;
        } catch (Exception e) {
            log.error("Error enviando petición al legado" + e);
            throw new CallLegacyException("Error enviando petición al legado" + e);
        }
    }
}
