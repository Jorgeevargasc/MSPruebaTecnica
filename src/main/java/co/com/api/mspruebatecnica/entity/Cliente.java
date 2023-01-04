package co.com.api.mspruebatecnica.entity;

import co.com.api.mspruebatecnica.dto.PersonaDto;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cliente extends PersonaDto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int clienteId;
    private String contrasenia;
    private boolean estado;


}
