package trabajo.arqweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trabajo.arqweb.entities.PeticionProducto;

import java.util.List;

public interface PeticionProductoRepository extends JpaRepository<PeticionProducto, Long> {
    @Query(value = """
        SELECT pr.id_producto AS idProducto,
               p.nombre AS nombreProducto,
               t.nombre_tienda AS nombreTienda,
               p.enlace AS enlace,
               d.nombre_diseñador || ' ' || d.apellido_diseñador AS nombreDiseñador
        FROM peticion_producto pp
        JOIN producto p ON pp.id_producto = p.id_producto
        JOIN tiendas t ON p.id_tienda = t.id_tienda
        JOIN peticion pt ON pt.id_peticion = pp.id_peticion
        JOIN diseñador d ON pt.id_diseñador = d.id_diseñador
        WHERE d.id_diseñador = :idDisenador
        """, nativeQuery = true)
    public List<Object[]> obtenerProductosRecomendadosPorDiseñador(@Param("idDisenador") Long idDisenador);


    @Query(value = """
    SELECT pr.id_producto,
           p.nombre,
           t.nombre_tienda,
           p.enlace,
           pt.fecha
    FROM peticion_producto pr
    JOIN producto p ON p.id_producto = pr.id_producto
    JOIN tiendas t ON p.id_tienda = t.id_tienda
    JOIN peticion pt ON pt.id_peticion = pr.id_peticion
    WHERE t.id_tienda = :idTienda
      AND pt.fecha >= CURRENT_DATE - INTERVAL '30 days'
    """, nativeQuery = true)
    List<Object[]> obtenerProductosRecomendadosUltimos30Dias(@Param("idTienda") Long idTienda);


    @Query(value = """
    SELECT p.categoria,
           SUM(p.precio) AS totalPrecio
    FROM peticion_producto pp
    JOIN producto p ON pp.id_producto = p.id_producto
    JOIN peticion pt ON pp.id_peticion = pt.id_peticion
    WHERE pt.id_diseñador = :idDisenador
    GROUP BY p.categoria
    """, nativeQuery = true)
    List<Object[]> obtenerTotalesPorCategoriaYDisenador(@Param("idDisenador") Long idDisenador);


    @Query(value = """
    SELECT pp.id_peticion,
           c.nombre || ' ' || c.apellido AS nombreCliente,
           COUNT(DISTINCT pr.id_tienda) AS cantidadTiendas
    FROM peticion_producto pp
    JOIN peticion p ON pp.id_peticion = p.id_peticion
    JOIN cliente c ON p.id_cliente = c.id_cliente
    JOIN producto pr ON pr.id_producto = pp.id_producto
    GROUP BY pp.id_peticion, c.nombre, c.apellido
    HAVING COUNT(DISTINCT pr.id_tienda) > 1
    """, nativeQuery = true)
    List<Object[]> obtenerPeticionesConProductosDeMultiplesTiendas();

}
