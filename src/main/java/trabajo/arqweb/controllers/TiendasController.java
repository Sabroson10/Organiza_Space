package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.TiendasDto;
import trabajo.arqweb.entities.Tiendas;
import trabajo.arqweb.services.TiendasService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tienda")
public class TiendasController {
    @Autowired
    private TiendasService tiendasService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<TiendasDto> insertarRopa(@RequestBody TiendasDto tiendasDto) {
        Tiendas tiendas = modelMapper.map(tiendasDto, Tiendas.class);
        tiendas = tiendasService.insertarTiendas(tiendas);
        tiendasDto = modelMapper.map(tiendas, TiendasDto.class);
        return ResponseEntity.ok(tiendasDto);
    }

    @GetMapping("/mostrar")
    public List<TiendasDto> mostrarTiendas() {
        List<Tiendas> tiendas = tiendasService.mostrarTiendas();
        List<TiendasDto> tiendasDtos = Arrays.asList(modelMapper.map(tiendas, TiendasDto[].class));
        return tiendasDtos;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TiendasDto> actualizarTiendas(@PathVariable Long id, @RequestBody TiendasDto tiendasDto) {
        Tiendas tiendas = modelMapper.map(tiendasDto, Tiendas.class);
        tiendas = tiendasService.actualizarTienda(id, tiendas);
        tiendasDto= modelMapper.map(tiendas, TiendasDto.class);
        return ResponseEntity.ok(tiendasDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTienda(@PathVariable Long id) {
        tiendasService.eliminarTienda(id);
    }
}
