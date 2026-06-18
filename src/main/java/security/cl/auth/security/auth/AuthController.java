package security.cl.auth.security.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.auth.AUTH;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bibliotecaam/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticador", description = "Autenticacion y login para los servicios de la Biblioteca AM")
public class AuthController {

    private final AuthService authService;

    @ArraySchema(schema = @Schema(implementation = LoginRequest.class))
    @Operation(summary = "Iniciar sesion a un trabajador ya registrado de la Biblioteca AM", description = "Esta opcion permitira iniciar sesion a un trabajador que ya tenga una cuenta.")
    @PostMapping(value = "login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "¡Usuario logeado con exito!"),
            @ApiResponse(responseCode = "404",description = "El usuario no fue encontrado, pruebe a revisar si ingreso bien sus parametros."),
            @ApiResponse(responseCode = "400",description = "Puede que hayan faltado algunos parametros, revise que haya introducido todos.")
    })
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid  LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @ArraySchema(schema = @Schema(implementation = LoginRequest.class))
    @Operation(summary = "Registrar a un trabajador a los servicios de la Biblioteca AM", description = "Esta opcion permitira registrar a un trabajador para que pueda ingresar con su cuenta.")
    @PostMapping(value = "register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "¡Usuario registrado con exito!"),
            @ApiResponse(responseCode = "400",description = "El usuario no pudo ser creado, pruebe a revisar si ingreso bien sus parametros.")
    })
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }


}
