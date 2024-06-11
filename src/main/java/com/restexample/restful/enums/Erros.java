package com.restexample.restful.enums;

public enum Erros {
    VALIDA_ERRO_NULO("O produto contém campos nulos, por favor corrija e tente novamente!"),
    VALIDA_PRECO_PRODUTO("O valor do produto não pode ser menor que 0.");

    private String mensagem;

    Erros(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
