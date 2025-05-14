package trabajo.arqweb.services;

import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Servicios;

import java.util.List;

public interface ServiciosService {
    public Servicios insertarServicios(Servicios servicio);
    public List<Servicios> mostrarServicios();
    public void elimnarServicio(Long id);
}
