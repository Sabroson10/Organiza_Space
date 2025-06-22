package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU3;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Producto;
import trabajo.arqweb.entities.Reseña;

import java.util.List;

public interface ReseñaService {
    public Reseña insetarReseña(Reseña reseña);
    public List<Reseña> mostrarReseña();
    public void elimnarReseña(Long id);
    public HU3 contarReseñasPorProducto(Long idProducto);

}
