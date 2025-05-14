package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.SuscripcionDto;
import trabajo.arqweb.dtos.TiendasDto;
import trabajo.arqweb.entities.Suscripcion;
import trabajo.arqweb.entities.Tiendas;
import trabajo.arqweb.services.SuscripcionService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/suscripcion")
public class SuscripcionController {
    @Autowired
    private SuscripcionService suscripcionService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<SuscripcionDto> insertarSuscripcion(@RequestBody SuscripcionDto suscripciondto) {
        Suscripcion suscripciones = modelMapper.map(suscripciondto, Suscripcion.class);
        suscripciones = suscripcionService.insertarSuscripcion(suscripciones);
        suscripciondto = modelMapper.map(suscripciones, SuscripcionDto.class);
        return ResponseEntity.ok(suscripciondto);
    }

    @GetMapping("/mostrar")
    public List<SuscripcionDto> mostrarSuscripciones() {
        List<Suscripcion> suscripciones = suscripcionService.mostrarSuscripcion();
        List<SuscripcionDto> suscripcionesdto = Arrays.asList(modelMapper.map(suscripciones, SuscripcionDto[].class));
        return suscripcionesdto;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<SuscripcionDto> actualizarSuscripciones(@PathVariable Long id, @RequestBody SuscripcionDto suscripciondto) {
        Suscripcion suscripciones = modelMapper.map(suscripciondto, Suscripcion.class);
        suscripciones = suscripcionService.actualizarSuscripcion(id, suscripciones);
        suscripciondto= modelMapper.map(suscripciones, SuscripcionDto.class);
        return ResponseEntity.ok(suscripciondto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSuscripcion(@PathVariable Long id) {
        suscripcionService.eliminarSuscripcion(id);
    }

}
