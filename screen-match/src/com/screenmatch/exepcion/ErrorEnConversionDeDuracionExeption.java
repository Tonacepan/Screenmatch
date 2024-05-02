package com.alura.screenmatch.exepcion;

public class ErrorEnConversionDeDuracionExeption extends RuntimeException{
    private String mensaje;
    public ErrorEnConversionDeDuracionExeption(String mensaje) {
        this.mensaje = mensaje;

    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
