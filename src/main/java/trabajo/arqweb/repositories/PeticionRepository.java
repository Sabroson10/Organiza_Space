package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trabajo.arqweb.dtos.HU16;
import trabajo.arqweb.dtos.HU18;
import trabajo.arqweb.entities.Peticion;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeticionRepository extends JpaRepository<Peticion, Long> {
    public List<Peticion> findByClienteIdCliente(Long idCliente);


    @Query("SELECT new trabajo.arqweb.dtos.HU16(d.idDiseñador, CONCAT(d.nombreDiseñador, ' ', d.apellidoDiseñador), COUNT(p)) " +
            "FROM Peticion p JOIN p.diseñador d " +
            "GROUP BY d.idDiseñador, d.nombreDiseñador, d.apellidoDiseñador " +
            "HAVING COUNT(p) > :minProyectos")
    List<HU16> obtenerDiseñadoresConMasDeXProyectos(@Param("minProyectos") Long minProyectos);
    @Query("SELECT new trabajo.arqweb.dtos.HU18(" +
            "d.idDiseñador, " +
            "CONCAT(d.nombreDiseñador, ' ', d.apellidoDiseñador), " +
            "COUNT(p)) " +
            "FROM Peticion p " +
            "JOIN p.diseñador d " +
            "WHERE p.estado = 'ACTIVA' " +  // Ajusta el valor según tu modelo
            "GROUP BY d.idDiseñador, d.nombreDiseñador, d.apellidoDiseñador " +
            "ORDER BY COUNT(p) DESC")
    List<HU18> obtenerDisenadoresConMasPeticionesActivas();

}
