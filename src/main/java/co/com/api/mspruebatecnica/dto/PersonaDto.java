package co.com.api.mspruebatecnica.dto;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class PersonaDto {

    private String nombre;
    private String genero;
    private String edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
