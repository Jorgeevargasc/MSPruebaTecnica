package co.com.api.mspruebatecnica.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReporteDto {

    private Date fecha;
    private String cliente;
    private String numCuenta;
    private String tipo;
    private int saldoInicial;
    private boolean estado;
    private int movimiento;
    private int saldoDisponible;

}
