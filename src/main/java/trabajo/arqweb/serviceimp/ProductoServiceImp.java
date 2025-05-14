package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU1;
import trabajo.arqweb.dtos.HU5;
import trabajo.arqweb.dtos.ProductoDto;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Producto;
import trabajo.arqweb.repositories.ProductoRepository;
import trabajo.arqweb.services.ProductoService;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto insertarProducto(Producto pregunta) {
        return productoRepository.save(pregunta);
    }

    @Override
    public List<Producto> mostrarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setNombre(productoActualizado.getNombre());
            return productoRepository.save(producto);
        }
        return null;
    }

    @Override
    public void elimnarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<HU1> obtenerProductosPorTienda(Long idTienda) {
        List<Producto> productos = productoRepository.findByTiendasIdTienda(idTienda);

        return productos.stream()
                .map(p -> new HU1(
                        p.getIdProducto(),
                        p.getNombre(),
                        p.getPrecio(),
                        p.getEnlace(),
                        p.getTiendas().getNombreTienda()
                ))
                .toList();
    }
    @Override
    public List<HU5> obtenerProductosPorPrecioMayorA(Double precio) {
        List<Object[]> resultados = productoRepository.obtenerProductosPorPrecioMayorA(precio);

        return resultados.stream()
                .map(obj -> new HU5(
                        ((Number) obj[0]).longValue(), // idProducto
                        (String) obj[1],               // nombre
                        ((Number) obj[2]).doubleValue() // precio
                ))
                .toList();
    }

}
