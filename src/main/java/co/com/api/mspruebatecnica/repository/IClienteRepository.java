package co.com.api.mspruebatecnica.repository;


import co.com.api.mspruebatecnica.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Integer>{

    Cliente findByClienteId(int clienteId);
    Cliente findByIdentificacion(String identificacion);
}
