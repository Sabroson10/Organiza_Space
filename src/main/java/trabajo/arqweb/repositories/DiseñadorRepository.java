package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trabajo.arqweb.dtos.HU15;
import trabajo.arqweb.entities.Diseñador;

import java.util.List;

public interface DiseñadorRepository extends JpaRepository<Diseñador, Long> {

    @Query("SELECT new trabajo.arqweb.dtos.HU15(d.idDiseñador, CONCAT(d.nombreDiseñador, ' ', d.apellidoDiseñador), d.telefono, d.correo) " +
            "FROM Diseñador d WHERE d.disponible = true")
    List<HU15> obtenerDiseñadoresDisponibles();
}
