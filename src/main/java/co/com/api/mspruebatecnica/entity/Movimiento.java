package co.com.api.mspruebatecnica.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Movimiento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    private String tipoMovimiento;
    private int valor;
    private int saldo;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name ="cuentaid", nullable = false)
    private Cuenta cuenta;
}
