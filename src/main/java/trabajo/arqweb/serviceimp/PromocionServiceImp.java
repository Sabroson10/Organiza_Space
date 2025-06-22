package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU4;
import trabajo.arqweb.dtos.HU8;
import trabajo.arqweb.entities.Producto;
import trabajo.arqweb.entities.Promocion;
import trabajo.arqweb.repositories.PromocionRepository;
import trabajo.arqweb.services.PromocionService;

import java.util.List;

@Service
public class PromocionServiceImp implements PromocionService {
    @Autowired
    private PromocionRepository promocionRepository;

    @Override
    public Promocion insertarPromocion(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    @Override
    public List<Promocion> mostraPromocion() {
        return promocionRepository.findAll();
    }

    @Override
    public Promocion actualizarPromocion(Long id, Promocion promocionActualizada) {
        Promocion promocion = promocionRepository.findById(id).orElse(null);
        if (promocion != null) {
            promocion.setNombreCodigo(promocionActualizada.getNombreCodigo());
            return promocionRepository.save(promocion);
        }
        return null;
    }

    @Override
    public void eliminarPromocion(Long id) {
        promocionRepository.deleteById(id);
    }

    @Override
    public List<HU4> obtenerPromocionesActivas() {
        List<Promocion> promociones = promocionRepository.findByRedimidoFalse();

        return promociones.stream().map(p -> new HU4(
                p.getIdPromocion(),
                p.getNombreCodigo(),
                p.getDescripcion(),
                p.getCliente().getNombre() + " " + p.getCliente().getApellido()
        )).toList();
    }
    @Override
    public List<HU8> obtenerClientesQueUsaronPromocion(Long idPromocion) {
        List<Object[]> resultados = promocionRepository.listarClientesQueUsaronPromocion(idPromocion);

        return resultados.stream()
                .map(obj -> new HU8(
                        ((Number) obj[0]).longValue(), // idCliente
                        (String) obj[1],               // nombreCompleto
                        (String) obj[2]                // nombrePromocion
                ))
                .toList();
    }
}
