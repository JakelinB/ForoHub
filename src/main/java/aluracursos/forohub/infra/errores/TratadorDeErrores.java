package aluracursos.forohub.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){

        var errores = e.getFieldErrors().stream().map(DatosErrorValidacionDTO::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }


    private record DatosErrorValidacionDTO(String campo, String error){

        public DatosErrorValidacionDTO(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
