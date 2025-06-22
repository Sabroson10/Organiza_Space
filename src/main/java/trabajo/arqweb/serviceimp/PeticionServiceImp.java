package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU16;
import trabajo.arqweb.dtos.HU18;
import trabajo.arqweb.dtos.HU2;
import trabajo.arqweb.entities.Peticion;
import trabajo.arqweb.repositories.PeticionRepository;
import trabajo.arqweb.services.PeticionService;

import java.util.List;
@Service
public class PeticionServiceImp implements PeticionService {
    @Autowired
    private PeticionRepository peticionRepository;

    @Override
    public Peticion insertarPeticion(Peticion peticion) {
        return peticionRepository.save(peticion);
    }

    @Override
    public List<Peticion> mostrarPeticiones() {
        return peticionRepository.findAll();
    }

    @Override
    public void elimnarPeticion(Long id) {
        peticionRepository.deleteById(id);
    }

    @Override
    public List<HU2> obtenerPeticionesPorCliente(Long idCliente) {
        List<Peticion> peticiones = peticionRepository.findByClienteIdCliente(idCliente);

        return peticiones.stream()
                .map(p -> new HU2(
                        p.getIdPeticion(),
                        p.getDescripcion(),
                        p.getRecomendacion(),
                        p.getCliente().getNombre() + " " + p.getCliente().getApellido()
                ))
                .toList();
    }
    @Override
    public List<HU16> obtenerDiseñadoresConMasDeXProyectos(Long minProyectos) {
        return peticionRepository.obtenerDiseñadoresConMasDeXProyectos(minProyectos);
    }
    @Override
    public List<HU18> obtenerDisenadoresConMasPeticionesActivas() {
        return peticionRepository.obtenerDisenadoresConMasPeticionesActivas();
    }

}
