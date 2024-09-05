package com.manoelcampos.impostorenda.calcular;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pessoa {
    private String cgc; // Cadastro Geral de Contribuinte
    private String nome;

    public Pessoa(String cgc, String nome) {
        this.cgc = cgc;
        this.nome = nome;
    }

    public final double calcularImpostos() {
        double impostoRenda = calcularIR();
        double outrosImpostos = calcularOutrosImpostos(); // Método que pode ser diferente para PF e PJ
        return (impostoRenda + outrosImpostos);
    }

    // Métodos que serão implementados nas subclasses que contem calculos próprios para cada Tipo de Pessoa
    protected abstract double calcularIR(); // Calcular o imposto sobre a Renda próprio de cada Tipo de Pessoa
    protected abstract double calcularOutrosImpostos(); // Calcular demais impostos (INSS, CSLL, IRExcedente)
}
