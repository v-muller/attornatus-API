package com.restapi.attornatus.enums;

public enum EnderecoPrincipal {

    PRINCIPAL(0),
    SECUNDARIO(1);

    private int code;

    private EnderecoPrincipal(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EnderecoPrincipal valueOf(int code) {
        for (EnderecoPrincipal value : EnderecoPrincipal.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código de de definição de endereço inválido. ");
    }
}
