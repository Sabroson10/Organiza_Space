package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU1;
import trabajo.arqweb.dtos.HU5;
import trabajo.arqweb.dtos.ProductoDto;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Producto;

import java.util.List;

public interface ProductoService {
    public Producto insertarProducto(Producto pregunta);
    public List<Producto> mostrarProducto();
    public Producto actualizarProducto(Long id, Producto productoActualizado);
    public void elimnarProducto(Long id);
    public List<HU1> obtenerProductosPorTienda(Long idTienda);
    public List<HU5> obtenerProductosPorPrecioMayorA(Double precio);

}
