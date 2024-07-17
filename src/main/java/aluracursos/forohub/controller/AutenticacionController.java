package aluracursos.forohub.controller;

import aluracursos.forohub.domain.usuario.Usuario;
import aluracursos.forohub.dto.DatosAutenticacionUsuarioDTO;
import aluracursos.forohub.dto.DatosJWTTokenDTO;
import aluracursos.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuarioDTO datosAutenticacionUsuarioDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken
                (datosAutenticacionUsuarioDTO.login(), datosAutenticacionUsuarioDTO.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTTokenDTO(JWTtoken)); //consumir DTO, devolver DTO
    }
}
