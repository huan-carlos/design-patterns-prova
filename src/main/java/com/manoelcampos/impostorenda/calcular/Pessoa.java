package com.manoelcampos.impostorenda.calcular;

public abstract class Pessoa {
    private String cgc; // Cadastro Geral de Contribuinte
    private String nome;

    public Pessoa(String nome, String cgc) {
        this.cgc = cgc;
        this.nome = nome;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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
