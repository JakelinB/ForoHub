package aluracursos.forohub.dto;

import aluracursos.forohub.domain.topico.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroTopicoDTO(
        @NotNull Long autor,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Curso curso) {


}
