package intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String fcnacimiento;

}
