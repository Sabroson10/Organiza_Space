package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.ClienteDto;
import trabajo.arqweb.dtos.EspaciosDto;
import trabajo.arqweb.entities.Cliente;
import trabajo.arqweb.entities.Espacios;
import trabajo.arqweb.services.EspaciosService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/espacios")
public class EspaciosController {
    @Autowired
    private EspaciosService espaciosService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<EspaciosDto> insertarEspacios(@RequestBody EspaciosDto espaciosDto) {
        Espacios espacios = modelMapper.map(espaciosDto, Espacios.class);
        espacios = espaciosService.insertarEspacios(espacios);
        espaciosDto = modelMapper.map(espacios, EspaciosDto.class);
        return ResponseEntity.ok(espaciosDto);
    }

    @GetMapping("/mostrar")
    public List<EspaciosDto> mostrarEspacios() {
        List<Espacios> espacios = espaciosService.mostrarEspacios();
        List<EspaciosDto> espaciosDtos = Arrays.asList(modelMapper.map(espacios, EspaciosDto[].class));
        return espaciosDtos;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EspaciosDto> actualizarEspacico(@PathVariable Long id, @RequestBody EspaciosDto espaciosDto) {
        Espacios espacios = modelMapper.map(espaciosDto, Espacios.class);
        espacios = espaciosService.actualizarEspacico(id, espacios);
        espaciosDto= modelMapper.map(espacios, EspaciosDto.class);
        return ResponseEntity.ok(espaciosDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEspacios(@PathVariable Long id) {
        espaciosService.eliminarEspacios(id);
    }
}
