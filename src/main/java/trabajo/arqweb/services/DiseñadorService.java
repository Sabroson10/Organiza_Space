package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU15;
import trabajo.arqweb.entities.Cliente;
import trabajo.arqweb.entities.Diseñador;

import java.util.List;

public interface DiseñadorService {
    public Diseñador insetarDiseñador(Diseñador diseñador);
    public List<Diseñador> mostrarDiseñadores();
    public Diseñador actualizarDiseñador(Long id, Diseñador diseñadorActualizado);
    public void eliminarDiseñador(Long id);
    List<HU15> obtenerDiseñadoresDisponibles();

}
