package ar.com.empresas.exception;

public enum ConstantsError {
    CODE_ERROR_PARSE("PASS000", "Error al parsear datos del servicio externo"),
    CODE_ERROR_RESOURCE("PASS001", "No hay respuesta del servicio externo"),
    CODE_ERROR_REST_NODATA("PASS002", "No hay datos")
    ;

    private final String codigo;
    private final String descripcion;

    ConstantsError(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
