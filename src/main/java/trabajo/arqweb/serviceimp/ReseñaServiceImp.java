package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU3;
import trabajo.arqweb.entities.Fotos;
import trabajo.arqweb.entities.Promocion;
import trabajo.arqweb.entities.Reseña;
import trabajo.arqweb.repositories.ReseñaRepository;
import trabajo.arqweb.services.ReseñaService;

import java.util.List;

@Service
public class ReseñaServiceImp implements ReseñaService {
    @Autowired
    private ReseñaRepository reseñaRepository;

    @Override
    public Reseña insetarReseña(Reseña reseña) {
        return reseñaRepository.save(reseña);
    }

    @Override
    public List<Reseña> mostrarReseña() {
        return reseñaRepository.findAll();
    }

    @Override
    public void elimnarReseña(Long id) {
        reseñaRepository.deleteById(id);
    }

    @Override
    public HU3 contarReseñasPorProducto(Long idProducto) {
        int cantidad = reseñaRepository.countByProductoIdProducto(idProducto);
        return new HU3(idProducto, cantidad);
    }
}
