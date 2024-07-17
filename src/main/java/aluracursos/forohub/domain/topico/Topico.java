package aluracursos.forohub.domain.topico;

import aluracursos.forohub.dto.DatosActualizarTopicoDTO;
import aluracursos.forohub.dto.DatosRegistroTopicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table (name = "topicos")
@Entity (name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    private Long autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DatosRegistroTopicoDTO datosRegistroTopicoDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.titulo = datosRegistroTopicoDTO.titulo();
        this.mensaje = datosRegistroTopicoDTO.mensaje();
        this.fecha = LocalDateTime.now().format(formatter);
        this.estatus = Estatus.PENDIENTE;
        this.autor = datosRegistroTopicoDTO.autor();
        this.curso = datosRegistroTopicoDTO.curso();
    }

    public void actualizarDatos(DatosActualizarTopicoDTO datosActualizarTopicoDTO) {
        if (datosActualizarTopicoDTO.titulo() != null){
            this.titulo = datosActualizarTopicoDTO.titulo();
        }
        if (datosActualizarTopicoDTO.mensaje() != null){
            this.mensaje = datosActualizarTopicoDTO.mensaje();
        }
        if (datosActualizarTopicoDTO.estatus() != null){
            this.estatus = Estatus.valueOf(datosActualizarTopicoDTO.estatus());
        }
        if (datosActualizarTopicoDTO.curso() != null){
            this.curso = Curso.valueOf(datosActualizarTopicoDTO.curso());
        }


    }

}
