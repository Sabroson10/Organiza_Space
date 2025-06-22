package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.entities.Espacios;
import trabajo.arqweb.repositories.EspaciosRepository;
import trabajo.arqweb.services.EspaciosService;

import java.util.List;

@Service
public class EspaciosServiceImp implements EspaciosService {
    @Autowired
    private EspaciosRepository espaciosRepository;

    @Override
    public Espacios insertarEspacios(Espacios espacios) {
        return espaciosRepository.save(espacios);
    }

    @Override
    public List<Espacios> mostrarEspacios() {
        return espaciosRepository.findAll();
    }

    @Override
    public Espacios actualizarEspacico(Long id, Espacios espacioActualizado) {
        Espacios ropa = espaciosRepository.findById(id).orElse(null);
        if (ropa != null) {
            ropa.setNombreEspacio(espacioActualizado.getNombreEspacio());
            return espaciosRepository.save(ropa);
        }
        return null;
    }

    @Override
    public void eliminarEspacios(Long id) {
        espaciosRepository.deleteById(id);
    }
}
