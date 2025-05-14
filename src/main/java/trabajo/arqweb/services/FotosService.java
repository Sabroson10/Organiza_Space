package trabajo.arqweb.services;

import trabajo.arqweb.entities.Fotos;

import java.util.List;

public interface FotosService {
    public Fotos insertarFotos(Fotos fotos);
    public List<Fotos> mostrarFotos();
    public Fotos actualizarFoto(Long id, Fotos fotoActualizado);
    public void eliminarFoto(Long id);
}
