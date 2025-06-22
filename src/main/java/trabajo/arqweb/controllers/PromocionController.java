package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.HU4;
import trabajo.arqweb.dtos.HU8;
import trabajo.arqweb.dtos.ProductoDto;
import trabajo.arqweb.dtos.PromocionDto;
import trabajo.arqweb.entities.Producto;
import trabajo.arqweb.entities.Promocion;
import trabajo.arqweb.services.PromocionService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/promocion")
public class PromocionController {
    @Autowired
    private PromocionService promocionService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<PromocionDto> insertarPromocion(@RequestBody PromocionDto promocionDto) {
        Promocion promocion = modelMapper.map(promocionDto, Promocion.class);
        promocion = promocionService.insertarPromocion(promocion);
        promocionDto = modelMapper.map(promocion, PromocionDto.class);
        return ResponseEntity.ok(promocionDto);
    }

    @GetMapping("/mostrar")
    public List<PromocionDto> mostraPromocion() {
        List<Promocion> promocion = promocionService.mostraPromocion();
        List<PromocionDto> promocionDtos = Arrays.asList(modelMapper.map(promocion, PromocionDto[].class));
        return promocionDtos;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PromocionDto> actualizarPromocion(@PathVariable Long id, @RequestBody PromocionDto promocionDto) {
        Promocion promocion = modelMapper.map(promocionDto, Promocion.class);
        promocion = promocionService.actualizarPromocion(id, promocion);
        promocionDto= modelMapper.map(promocion, PromocionDto.class);
        return ResponseEntity.ok(promocionDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void elimnarProducto(@PathVariable Long id) {
        promocionService.eliminarPromocion(id);
    }

    @GetMapping("/activas")
    public ResponseEntity<List<HU4>> obtenerPromocionesActivas() {
        return ResponseEntity.ok(promocionService.obtenerPromocionesActivas());
    }

    @GetMapping("/{idPromocion}/clientes-usaron")
    public ResponseEntity<List<HU8>> obtenerClientesQueUsaronPromocion(@PathVariable Long idPromocion) {
        return ResponseEntity.ok(promocionService.obtenerClientesQueUsaronPromocion(idPromocion));
    }
}
