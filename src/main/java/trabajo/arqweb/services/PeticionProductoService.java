package trabajo.arqweb.services;

import trabajo.arqweb.dtos.HU13;
import trabajo.arqweb.dtos.HU14;
import trabajo.arqweb.dtos.HU17;
import trabajo.arqweb.dtos.HU7;
import trabajo.arqweb.entities.PeticionProducto;

import java.util.List;

public interface PeticionProductoService {
    public PeticionProducto insertarPeticionProducto(PeticionProducto peticionProducto);
    public List<PeticionProducto> mostrarPeticionProducto();
    public void elimnarPeticionProducto(Long id);
    public List<HU7> obtenerProductosPorDiseñador(Long idDisenador);
    List<HU13> obtenerProductosRecomendadosUltimos30Dias(Long idTienda);
    List<HU14> obtenerTotalesPorCategoriaYDisenador(Long idDisenador);
    List<HU17> obtenerPeticionesConProductosDeMultiplesTiendas();

}
