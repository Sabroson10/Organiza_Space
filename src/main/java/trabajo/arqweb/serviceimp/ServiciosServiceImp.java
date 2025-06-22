package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.entities.Servicios;
import trabajo.arqweb.repositories.ServiciosRepository;
import trabajo.arqweb.services.ServiciosService;

import java.util.List;

@Service
public class ServiciosServiceImp implements ServiciosService {
    @Autowired
    private ServiciosRepository serviciosRepository;

    @Override
    public Servicios insertarServicios(Servicios servicio) {
        return serviciosRepository.save(servicio);
    }

    @Override
    public List<Servicios> mostrarServicios() {
        return serviciosRepository.findAll();
    }

    @Override
    public void elimnarServicio(Long id) {
        serviciosRepository.deleteById(id);
    }
}
