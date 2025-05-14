package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU10;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Pregunta;

import java.util.List;

public interface PreguntaService {
    public Pregunta insertarPregunta(Pregunta pregunta);
    public List<Pregunta> mostraPregunta();
    public Pregunta actualizarPregunta(Long id, Pregunta preguntaActualizada);
    public void elimnarPregunta(Long id);
    public List<HU10> listarPreguntasPorCliente(Long idCliente);

}
