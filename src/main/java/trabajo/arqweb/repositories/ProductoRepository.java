package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trabajo.arqweb.dtos.HU1;
import trabajo.arqweb.dtos.ProductoDto;
import trabajo.arqweb.entities.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    public List<Producto> findByTiendasIdTienda(Long idTienda);

    @Query(value = "SELECT p.id_producto AS idProducto, p.nombre, p.precio " +
            "FROM producto p WHERE p.precio > :precio", nativeQuery = true)
    public List<Object[]> obtenerProductosPorPrecioMayorA(@Param("precio") Double precio);
}
