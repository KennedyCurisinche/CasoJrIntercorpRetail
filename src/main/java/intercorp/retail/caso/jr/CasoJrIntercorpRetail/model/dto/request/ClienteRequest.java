package intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String fcnacimiento;

}
