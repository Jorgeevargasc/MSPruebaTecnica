package co.com.api.mspruebatecnica.repository;

import co.com.api.mspruebatecnica.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Integer> {

    Movimiento findById(int id);
    @Query(value = "Select * from movimiento t where t.fecha BETWEEN :fechaInicial AND :fechaFinal AND t.cuentaid = :cuentaId",
            nativeQuery = true)
    List<Movimiento> listarMovimientos(@Param("fechaInicial") Date fechaInicial, @Param("fechaFinal") Date fechaFinal, @Param("cuentaId") int cuentaId);
}
