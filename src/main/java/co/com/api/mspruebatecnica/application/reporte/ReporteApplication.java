package co.com.api.mspruebatecnica.application.reporte;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import co.com.api.mspruebatecnica.service.reporte.IReporteService;
import co.com.api.mspruebatecnica.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ReporteApplication implements IReporteApplication{

    @Autowired
    private IReporteService reporteService;

    @Autowired
    private ResponseUtil responseUtil;

    @Override
    public ResponseDto generarReporte(String fechaInicial, String fechaFinal, String identificacion) {
        var responseDto = new ResponseDto();
        try {
            var reportes = reporteService.generarReporte(convertirFecha(fechaInicial), convertirFecha(fechaFinal), identificacion);
            if(reportes.isEmpty()) {
                responseDto.setMessage("No existen movimientos con los criterios de búsqueda");
                responseDto.setResponseCode(HttpStatus.NOT_FOUND.value());
                responseDto.setData(null);
                return responseDto;
            }
            responseDto = responseUtil.createResponseDto(reportes);
        } catch (Exception e) {
            responseDto.setMessage("Error " + e);
            responseDto.setResponseCode(HttpStatus.CONFLICT.value());
            responseDto.setData(null);
        }
        return responseDto;
    }

    public Date convertirFecha(String fecha) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
    }
}
