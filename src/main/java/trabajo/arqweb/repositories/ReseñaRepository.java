package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trabajo.arqweb.entities.Reseña;

public interface ReseñaRepository extends JpaRepository<Reseña, Long> {
    public int countByProductoIdProducto(Long idProducto);

}
