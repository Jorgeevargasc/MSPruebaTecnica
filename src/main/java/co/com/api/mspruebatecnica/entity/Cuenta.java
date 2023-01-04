package co.com.api.mspruebatecnica.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cuenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String numCuenta;
    private String tipoCuenta;
    private int saldoInicial;
    private boolean estado;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name ="clienteid", nullable = false)
    private Cliente cliente;
}
