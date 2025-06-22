package trabajo.arqweb.services;

import trabajo.arqweb.entities.Espacios;

import java.util.List;

public interface EspaciosService {
    public Espacios insertarEspacios(Espacios espacios);
    public List<Espacios> mostrarEspacios();
    public Espacios actualizarEspacico(Long id, Espacios espacioActualizado);
    public void eliminarEspacios(Long id);
}
