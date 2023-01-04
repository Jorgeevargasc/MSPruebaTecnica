package co.com.api.mspruebatecnica.service.reporte;

import co.com.api.mspruebatecnica.dto.ReporteDto;

import java.util.Date;
import java.util.List;

public interface IReporteService {

    List<ReporteDto> generarReporte(Date fechaInicial, Date fechaFinal, String numCuenta);
}
