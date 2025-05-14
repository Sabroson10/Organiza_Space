package trabajo.arqweb.services;

import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Servicios;
import trabajo.arqweb.entities.Suscripcion;

import java.util.List;

public interface SuscripcionService {
    public Suscripcion insertarSuscripcion(Suscripcion suscripcion);
    public List<Suscripcion> mostrarSuscripcion();
    public Suscripcion actualizarSuscripcion(Long id, Suscripcion suscripcionActualizado);
    public void eliminarSuscripcion(Long id);
}
