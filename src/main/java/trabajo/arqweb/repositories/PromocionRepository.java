package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trabajo.arqweb.entities.Promocion;

import java.util.List;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {
    public List<Promocion> findByRedimidoFalse();

    @Query(value = """
    SELECT c.id_cliente, 
           c.nombre || ' ' || c.apellido AS nombreCompleto,
           p.nombre_codigo
    FROM promocion p
    JOIN cliente c ON c.id_cliente = p.id_cliente
    WHERE p.redimido = true AND p.id_promocion = :idPromocion
    """, nativeQuery = true)
    public List<Object[]> listarClientesQueUsaronPromocion(@Param("idPromocion") Long idPromocion);
}
