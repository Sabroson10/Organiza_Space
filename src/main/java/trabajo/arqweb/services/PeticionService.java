package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU16;
import trabajo.arqweb.dtos.HU18;
import trabajo.arqweb.dtos.HU2;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Peticion;

import java.util.List;

public interface PeticionService {
    public Peticion insertarPeticion(Peticion peticion);
    public List<Peticion> mostrarPeticiones();
    public void elimnarPeticion(Long id);
    public List<HU2> obtenerPeticionesPorCliente(Long idCliente);
    List<HU16> obtenerDiseñadoresConMasDeXProyectos(Long minProyectos);
    List<HU18> obtenerDisenadoresConMasPeticionesActivas();

}
