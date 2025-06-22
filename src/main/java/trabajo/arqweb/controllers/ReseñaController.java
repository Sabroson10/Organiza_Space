package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.HU3;
import trabajo.arqweb.dtos.ReseñaDto;
import trabajo.arqweb.dtos.TiendasDto;
import trabajo.arqweb.entities.Reseña;
import trabajo.arqweb.entities.Tiendas;
import trabajo.arqweb.services.ReseñaService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/reseña")
public class ReseñaController {
    @Autowired
    private ReseñaService reseñaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<ReseñaDto> insertarReseña(@RequestBody ReseñaDto reseñaDto) {
        Reseña reseña = modelMapper.map(reseñaDto, Reseña.class);
        reseña = reseñaService.insetarReseña(reseña);
        reseñaDto = modelMapper.map(reseña, ReseñaDto.class);
        return ResponseEntity.ok(reseñaDto);
    }

    @GetMapping("/mostrar")
    public List<ReseñaDto> mostrarReseña() {
        List<Reseña> reseña = reseñaService.mostrarReseña();
        List<ReseñaDto> reseñaDto = Arrays.asList(modelMapper.map(reseña, ReseñaDto[].class));
        return reseñaDto;
    }
    @DeleteMapping("/eliminar/{id}")
    public void elimnarReseña(@PathVariable Long id) {
        reseñaService.elimnarReseña(id);
    }

    @GetMapping("/producto/{idProducto}/cantidad")
    public ResponseEntity<HU3> contarReseñasPorProducto(@PathVariable Long idProducto) {
        return ResponseEntity.ok(reseñaService.contarReseñasPorProducto(idProducto));
    }
}
