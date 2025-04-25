package ar.com.empresas.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import paas.commons.error.serializer.rest.ErrorData;
import paas.commons.error.serializer.rest.MetaData;

import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "Response standard de errores para los servicios API REST")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"meta", "data", "errors"})
@Data
public class StandardErrorRestResponse {
    @ApiModelProperty(notes = "Metadatos del método")
    @JsonProperty("meta")
    private final MetaData meta;
    @JsonProperty("data")
    @ApiModelProperty(notes = "Cuerpo de la respuesta (al ser error se retorna vacío)")
    private Object data = new ArrayList<>();
    @JsonProperty("errors")
    @ApiModelProperty(notes = "Lista con los errores ocurridos")
    private List<ErrorData> errors = null;
}
