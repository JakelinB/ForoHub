package aluracursos.forohub.controller;

import aluracursos.forohub.domain.topico.*;
import aluracursos.forohub.dto.DatosActualizarTopicoDTO;
import aluracursos.forohub.dto.DatosListadoTopicoDTO;
import aluracursos.forohub.dto.DatosRegistroTopicoDTO;
import aluracursos.forohub.dto.DatosRespuestaTopicoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopicoDTO> registrarTopico
            (@RequestBody @Valid DatosRegistroTopicoDTO datosRegistroTopicoDTO,
             UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopicoDTO));
        DatosRespuestaTopicoDTO datosRespuestaTopicoDTO = new DatosRespuestaTopicoDTO(topico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopicoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopicoDTO> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopicoDTO(topico);
        return ResponseEntity.ok(datosTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicoDTO>> listadoTopicos
            (@PageableDefault(size = 10, sort = "fecha", direction = Sort.Direction.ASC)
             Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion)
                .map(DatosListadoTopicoDTO::new));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopicoDTO datosActualizarTopicoDTO) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopicoDTO.id());
        topico.actualizarDatos(datosActualizarTopicoDTO);
        return ResponseEntity.ok(new DatosRespuestaTopicoDTO(topico));
    }


}

