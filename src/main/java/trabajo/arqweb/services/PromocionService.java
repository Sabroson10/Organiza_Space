package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU4;
import trabajo.arqweb.dtos.HU8;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Producto;
import trabajo.arqweb.entities.Promocion;

import java.util.List;

public interface PromocionService {
    public Promocion insertarPromocion(Promocion promocion);
    public List<Promocion> mostraPromocion();
    public Promocion actualizarPromocion(Long id, Promocion promocionActualizada);
    public void eliminarPromocion(Long id);
    public List<HU4> obtenerPromocionesActivas();
    public List<HU8> obtenerClientesQueUsaronPromocion(Long idPromocion);

}
