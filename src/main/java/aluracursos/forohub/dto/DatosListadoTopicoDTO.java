package aluracursos.forohub.dto;

import aluracursos.forohub.domain.topico.Topico;

public record DatosListadoTopicoDTO(Long id, String titulo, String mensaje,
                                    String fecha, String estatus,
                                    Long autor, String curso) {

    public DatosListadoTopicoDTO(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
             topico.getEstatus().toString(), topico.getAutor(), topico.getCurso().toString());
    }



}
