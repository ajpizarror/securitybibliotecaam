package security.cl.auth.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest  {

    String USUARIO;
    String CONTRASENA;
    String NOMBRE;
    String APELLIDO;
    String PAIS;
}
