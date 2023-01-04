package co.com.api.mspruebatecnica.controller;

import co.com.api.mspruebatecnica.application.reporte.IReporteApplication;
import co.com.api.mspruebatecnica.dto.ResponseDto;
import co.com.api.mspruebatecnica.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReporteController {

    @Autowired
    IReporteApplication reporteApplication;

    @GetMapping("/reportes")
    public ResponseEntity<ResponseDto> generarReportes(@RequestParam String fechaInicial, @RequestParam String fechaFinal, @RequestParam String identificacion){
        if(fechaInicial == null || fechaFinal == null || identificacion.isEmpty()) {
            throw new BadRequestException("Request no puede estar vacío");
        }
        var response = reporteApplication.generarReporte(fechaInicial, fechaFinal, identificacion);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }
}
