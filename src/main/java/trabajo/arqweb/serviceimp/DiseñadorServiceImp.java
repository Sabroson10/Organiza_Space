package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU15;
import trabajo.arqweb.entities.Diseñador;
import trabajo.arqweb.repositories.DiseñadorRepository;
import trabajo.arqweb.services.DiseñadorService;

import java.util.List;

@Service
public class DiseñadorServiceImp implements DiseñadorService {
    @Autowired
    private DiseñadorRepository diseñadorRepository;

    @Override
    public Diseñador insetarDiseñador(Diseñador diseñador) {
        return diseñadorRepository.save(diseñador);
    }

    @Override
    public List<Diseñador> mostrarDiseñadores() {
        return diseñadorRepository.findAll();
    }

    @Override
    public Diseñador actualizarDiseñador(Long id, Diseñador diseñadorActualizado) {
        Diseñador diseñador = diseñadorRepository.findById(id).orElse(null);
        if (diseñador != null) {
            diseñador.setNombreDiseñador(diseñadorActualizado.getNombreDiseñador());
            return diseñadorRepository.save(diseñador);
        }
        return null;
    }

    @Override
    public void eliminarDiseñador(Long id) {
        diseñadorRepository.deleteById(id);
    }
    @Override
    public List<HU15> obtenerDiseñadoresDisponibles() {
        return diseñadorRepository.obtenerDiseñadoresDisponibles();
    }
}
