package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.entities.Tiendas;
import trabajo.arqweb.repositories.TiendasRepository;
import trabajo.arqweb.services.TiendasService;

import java.util.List;

@Service
public class TiendasServiceImp implements TiendasService {
    @Autowired
    private TiendasRepository tiendasRepository;

    @Override
    public Tiendas insertarTiendas(Tiendas tiendas) {
        return tiendasRepository.save(tiendas);
    }

    @Override
    public List<Tiendas> mostrarTiendas() {
        return tiendasRepository.findAll();
    }

    @Override
    public Tiendas actualizarTienda(Long id, Tiendas tiendasactualizada) {
        Tiendas tienda = tiendasRepository.findById(id).orElse(null);
        if (tienda != null) {
            tienda.setNombreTienda(tiendasactualizada.getNombreTienda());
            return tiendasRepository.save(tienda);
        }
        return null;
    }

    @Override
    public void eliminarTienda(Long id) {
        tiendasRepository.deleteById(id);
    }
}
