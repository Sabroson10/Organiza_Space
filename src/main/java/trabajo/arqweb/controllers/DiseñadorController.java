package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.ClienteDto;
import trabajo.arqweb.dtos.DiseñadorDto;
import trabajo.arqweb.dtos.HU15;
import trabajo.arqweb.entities.Cliente;
import trabajo.arqweb.entities.Diseñador;
import trabajo.arqweb.services.DiseñadorService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/diseñador")
public class DiseñadorController {
    @Autowired
    private DiseñadorService diseñadorService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<DiseñadorDto> insetarDiseñador(@RequestBody DiseñadorDto diseñadorDto) {
        Diseñador diseñador = modelMapper.map(diseñadorDto, Diseñador.class);
        diseñador = diseñadorService.insetarDiseñador(diseñador);
        diseñadorDto = modelMapper.map(diseñador, DiseñadorDto.class);
        return ResponseEntity.ok(diseñadorDto);
    }

    @GetMapping("/mostrar")
    public List<DiseñadorDto> mostrarDiseñadores() {
        List<Diseñador> diseñador = diseñadorService.mostrarDiseñadores();
        List<DiseñadorDto> clienteDto = Arrays.asList(modelMapper.map(diseñador, DiseñadorDto[].class));
        return clienteDto;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DiseñadorDto> actualizarDiseñador(@PathVariable Long id, @RequestBody DiseñadorDto diseñadorDto) {
        Diseñador diseñador = modelMapper.map(diseñadorDto, Diseñador.class);
        diseñador = diseñadorService.actualizarDiseñador(id, diseñador);
        diseñadorDto= modelMapper.map(diseñador, DiseñadorDto.class);
        return ResponseEntity.ok(diseñadorDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarDiseñador(@PathVariable Long id) {
        diseñadorService.eliminarDiseñador(id);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<HU15>> obtenerDiseñadoresDisponibles() {
        return ResponseEntity.ok(diseñadorService.obtenerDiseñadoresDisponibles());
    }
}
