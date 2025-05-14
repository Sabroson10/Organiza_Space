package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Suscripcion;
import trabajo.arqweb.repositories.SuscripcionRepository;
import trabajo.arqweb.services.SuscripcionService;

import java.util.List;

@Service
public class SuscripcionServiceImp implements SuscripcionService {
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Override
    public Suscripcion insertarSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    @Override
    public List<Suscripcion> mostrarSuscripcion() {
        return suscripcionRepository.findAll();
    }

    @Override
    public Suscripcion actualizarSuscripcion(Long id, Suscripcion suscripcionActualizado) {
        Suscripcion suscripcion = suscripcionRepository.findById(id).orElse(null);
        if (suscripcion != null) {
            suscripcion.setNombre(suscripcionActualizado.getNombre());
            return suscripcionRepository.save(suscripcion);
        }
        return null;
    }

    @Override
    public void eliminarSuscripcion(Long id) {
        suscripcionRepository.deleteById(id);
    }
}
