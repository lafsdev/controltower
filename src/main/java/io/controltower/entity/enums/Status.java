package io.controltower.entity.enums;

public enum Status {

    VAZIO("Vazio"),
    EM_VIAGEM("Em Viagem"),
    AGUARDANDO_ROTA("Aguardando Rota");

    private String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
