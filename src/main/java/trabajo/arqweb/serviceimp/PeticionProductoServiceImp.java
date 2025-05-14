package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.HU13;
import trabajo.arqweb.dtos.HU14;
import trabajo.arqweb.dtos.HU17;
import trabajo.arqweb.dtos.HU7;
import trabajo.arqweb.entities.PeticionProducto;
import trabajo.arqweb.repositories.PeticionProductoRepository;
import trabajo.arqweb.services.PeticionProductoService;

import java.util.List;
@Service
public class PeticionProductoServiceImp implements PeticionProductoService {
    @Autowired
    private PeticionProductoRepository peticionProductoRepository;

    @Override
    public PeticionProducto insertarPeticionProducto(PeticionProducto peticionProducto) {
        return peticionProductoRepository.save(peticionProducto);
    }

    @Override
    public List<PeticionProducto> mostrarPeticionProducto() {
        return peticionProductoRepository.findAll();
    }


    @Override
    public void elimnarPeticionProducto(Long id) {
        peticionProductoRepository.deleteById(id);
    }

    @Override
    public List<HU7> obtenerProductosPorDiseñador(Long idDisenador) {
        List<Object[]> datos = peticionProductoRepository.obtenerProductosRecomendadosPorDiseñador(idDisenador);

        return datos.stream()
                .map(obj -> new HU7(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        (String) obj[2],
                        (String) obj[3],
                        (String) obj[4]
                ))
                .toList();
    }

    @Override
    public List<HU13> obtenerProductosRecomendadosUltimos30Dias(Long idTienda) {
        List<Object[]> datos = peticionProductoRepository.obtenerProductosRecomendadosUltimos30Dias(idTienda);

        return datos.stream()
                .map(obj -> new HU13(
                        ((Number) obj[0]).longValue(),  // idProducto
                        (String) obj[1],                // nombreProducto
                        (String) obj[2],                // nombreTienda
                        (String) obj[3],                // enlace
                        obj[4].toString()               // fecha recomendación
                ))
                .toList();
    }

    @Override
    public List<HU14> obtenerTotalesPorCategoriaYDisenador(Long idDisenador) {
        List<Object[]> resultados = peticionProductoRepository.obtenerTotalesPorCategoriaYDisenador(idDisenador);

        return resultados.stream()
                .map(obj -> new HU14(
                        (String) obj[0],                   // categoria
                        ((Number) obj[1]).doubleValue()    // totalPrecio
                ))
                .toList();
    }
    @Override
    public List<HU17> obtenerPeticionesConProductosDeMultiplesTiendas() {
        List<Object[]> resultados = peticionProductoRepository.obtenerPeticionesConProductosDeMultiplesTiendas();

        return resultados.stream()
                .map(obj -> new HU17(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        ((Number) obj[2]).intValue()
                ))
                .toList();
    }

}
