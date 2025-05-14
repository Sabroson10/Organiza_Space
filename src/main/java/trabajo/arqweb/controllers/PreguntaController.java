package trabajo.arqweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabajo.arqweb.dtos.HU10;
import trabajo.arqweb.dtos.PreguntaDto;
import trabajo.arqweb.entities.Pregunta;
import trabajo.arqweb.services.PreguntaService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insertar")
    public ResponseEntity<PreguntaDto> insertarPregunta(@RequestBody PreguntaDto preguntaDto) {
        Pregunta pregunta = modelMapper.map(preguntaDto, Pregunta.class);
        pregunta = preguntaService.insertarPregunta(pregunta);
        preguntaDto = modelMapper.map(pregunta, PreguntaDto.class);
        return ResponseEntity.ok(preguntaDto);
    }

    @GetMapping("/mostrar")
    public List<PreguntaDto> mostraPregunta() {
        List<Pregunta> pregunta = preguntaService.mostraPregunta();
        List<PreguntaDto> preguntaDtos = Arrays.asList(modelMapper.map(pregunta, PreguntaDto[].class));
        return preguntaDtos;
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PreguntaDto> actualizarPregunta(@PathVariable Long id, @RequestBody PreguntaDto preguntaDto) {
        Pregunta pregunta = modelMapper.map(preguntaDto, Pregunta.class);
        pregunta = preguntaService.actualizarPregunta(id, pregunta);
        preguntaDto= modelMapper.map(pregunta, PreguntaDto.class);
        return ResponseEntity.ok(preguntaDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void elimnarPregunta(@PathVariable Long id) {
        preguntaService.elimnarPregunta(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<HU10>> listarPreguntasPorCliente(@PathVariable Long idCliente) {
        List<HU10> preguntas = preguntaService.listarPreguntasPorCliente(idCliente);
        return ResponseEntity.ok(preguntas);
    }
}
