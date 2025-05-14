package trabajo.arqweb.services;

import trabajo.arqweb.entities.Tiendas;

import java.util.List;

public interface TiendasService {
    public Tiendas insertarTiendas(Tiendas tiendas);
    public List<Tiendas> mostrarTiendas();
    public Tiendas actualizarTienda(Long id, Tiendas tiendasactualizada);
    public void eliminarTienda(Long id);
}
