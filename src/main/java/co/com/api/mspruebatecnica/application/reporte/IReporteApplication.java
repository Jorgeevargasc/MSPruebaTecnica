package co.com.api.mspruebatecnica.application.reporte;

import co.com.api.mspruebatecnica.dto.ResponseDto;

public interface IReporteApplication {

    ResponseDto generarReporte(String fechaInicial, String fechaFinal, String identificacion);
}
