package co.com.api.mspruebatecnica.repository;

import co.com.api.mspruebatecnica.entity.Cliente;
import co.com.api.mspruebatecnica.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Integer> {

    Cuenta findById(int id);
    List<Cuenta> findByCliente(Cliente cliente);
}
