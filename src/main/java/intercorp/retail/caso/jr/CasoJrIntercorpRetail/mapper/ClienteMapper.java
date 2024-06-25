package intercorp.retail.caso.jr.CasoJrIntercorpRetail.mapper;

import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.request.ClienteRequest;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.dto.response.ClienteResponse;
import intercorp.retail.caso.jr.CasoJrIntercorpRetail.model.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", source = "idCliente")
    @Mapping(target = "nombre", source = "nombreCliente")
    @Mapping(target = "apellido", source = "apellidoCliente")
    @Mapping(target = "edad", source = "edadCliente")
    @Mapping(target = "fcnacimiento", source = "fechaDeNacimientoCliente")
    ClienteResponse entityToDto(ClienteEntity entity);

    @Mapping(target = "idCliente", source = "id")
    @Mapping(target = "nombreCliente", source = "nombre")
    @Mapping(target = "apellidoCliente", source = "apellido")
    @Mapping(target = "edadCliente", source = "edad")
    @Mapping(target = "fechaDeNacimientoCliente", source = "fcnacimiento")
    ClienteEntity dtoToEntity(ClienteRequest request);

}
