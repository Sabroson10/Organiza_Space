package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.repositories.FotosRepository;
import trabajo.arqweb.services.FotosService;

import java.util.List;

@Service
public class FotosServiceImp implements FotosService {
    @Autowired
    private FotosRepository fotosRepository;


    @Override
    public Fotos insertarFotos(Fotos fotos) {
        return fotosRepository.save(fotos);
    }

    @Override
    public List<Fotos> mostrarFotos() {
        return fotosRepository.findAll();
    }

    @Override
    public Fotos actualizarFoto(Long id, Fotos fotoActualizado) {
        Fotos fotos = fotosRepository.findById(id).orElse(null);
        if (fotos != null) {
            fotos.setNombreFotos(fotoActualizado.getNombreFotos());
            return fotosRepository.save(fotos);
        }
        return null;
    }

    @Override
    public void eliminarFoto(Long id) {
        fotosRepository.deleteById(id);
    }
}
