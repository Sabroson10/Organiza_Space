package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU10;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Pregunta;
import trabajo.arqweb.repositories.PreguntaRepository;
import trabajo.arqweb.services.PreguntaService;

import java.util.List;

@Service
public class PreguntaServiceImp implements PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public Pregunta insertarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public List<Pregunta> mostraPregunta() {
        return preguntaRepository.findAll();
    }

    @Override
    public Pregunta actualizarPregunta(Long id, Pregunta preguntaActualizada) {
        Pregunta pregunta = preguntaRepository.findById(id).orElse(null);
        if (pregunta != null) {
            pregunta.setPregunta(preguntaActualizada.getPregunta());
            return preguntaRepository.save(pregunta);
        }
        return null;
    }

    @Override
    public void elimnarPregunta(Long id) {
        preguntaRepository.deleteById(id);
    }

    @Override
    public List<HU10> listarPreguntasPorCliente(Long idCliente) {
        return preguntaRepository.listarPreguntasPorCliente(idCliente);
    }


}
