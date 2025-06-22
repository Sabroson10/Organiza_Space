package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trabajo.arqweb.dtos.HU10;
import trabajo.arqweb.entities.Pregunta;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    @Query("SELECT new trabajo.arqweb.dtos.HU10(p.idPregunta, p.pregunta, c.idCliente, CONCAT(c.nombre, ' ', c.apellido)) " +
            "FROM Pregunta p " +
            "JOIN p.peticion pt " +
            "JOIN pt.cliente c " +
            "WHERE c.idCliente = :idCliente")
    public List<HU10> listarPreguntasPorCliente(@Param("idCliente") Long idCliente);
}
