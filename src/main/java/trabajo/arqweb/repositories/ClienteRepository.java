package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trabajo.arqweb.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);


    @Query(value = """
    SELECT c.id_cliente, c.nombre || ' ' || c.apellido AS nombreCompleto, c.correo
    FROM cliente c
    WHERE c.id_cliente NOT IN (
        SELECT p.id_cliente
        FROM promocion p
        WHERE p.redimido = true
    )
    """, nativeQuery = true)
    List<Object[]> listarClientesSinPromocionesUsadas();

}
