package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.*;
import trabajo.arqweb.entities.Peticion;
import trabajo.arqweb.entities.PeticionProducto;
import trabajo.arqweb.services.PeticionProductoService;
import trabajo.arqweb.services.PeticionService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/peticionProducto")
public class PeticionProductoController {
    @Autowired
    private PeticionProductoService peticionProductoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<PeticionProductoDto> insertarPeticionProducto(@RequestBody PeticionProductoDto peticionProductoDto) {
        PeticionProducto peticionProducto = modelMapper.map(peticionProductoDto, PeticionProducto.class);
        peticionProducto = peticionProductoService.insertarPeticionProducto(peticionProducto);
        peticionProductoDto = modelMapper.map(peticionProducto, PeticionProductoDto.class);
        return ResponseEntity.ok(peticionProductoDto);
    }

    @GetMapping("/mostrar")
    public List<PeticionProductoDto> mostrarPeticionProducto() {
        List<PeticionProducto> peticionProducto = peticionProductoService.mostrarPeticionProducto();
        List<PeticionProductoDto> peticionProductoDto = Arrays.asList(modelMapper.map(peticionProducto, PeticionProductoDto[].class));
        return peticionProductoDto;
    }

    @DeleteMapping("/eliminar/{id}")
    public void elimnarPeticionProducto(@PathVariable Long id) {
        peticionProductoService.elimnarPeticionProducto(id);
    }


    @GetMapping("/recomendados/diseñador/{idDisenador}")
    public ResponseEntity<List<HU7>> obtenerProductosRecomendadosPorDiseñador(@PathVariable Long idDisenador) {
        List<HU7> productos = peticionProductoService.obtenerProductosPorDiseñador(idDisenador);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/recomendados/ultimos-30-dias/tienda/{idTienda}")
    public ResponseEntity<List<HU13>> productosRecomendadosUltimos30Dias(@PathVariable Long idTienda) {
        List<HU13> productos = peticionProductoService.obtenerProductosRecomendadosUltimos30Dias(idTienda);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/disenador/{idDisenador}/totales-categoria")
    public ResponseEntity<List<HU14>> obtenerTotalesPorCategoriaYDisenador(@PathVariable Long idDisenador) {
        List<HU14> resultados = peticionProductoService.obtenerTotalesPorCategoriaYDisenador(idDisenador);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/multiples-tiendas")
    public ResponseEntity<List<HU17>> obtenerPeticionesMultiplesTiendas() {
        return ResponseEntity.ok(peticionProductoService.obtenerPeticionesConProductosDeMultiplesTiendas());
    }
}
