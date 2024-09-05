package com.manoelcampos.impostorenda.calcular;

public class PessoaFisica extends Pessoa {
    private double salarioBruto;
    private double deducaoDependentes;
    private double gastosSaude;
    private double gastosEducacao;
    private double inss;

    public PessoaFisica(String nome, String cgc, double salarioBruto, int quantidadeDependentes, double gastosSaude, double gastosEducacao) {
        super(nome, cgc);
        this.salarioBruto = salarioBruto;
        this.deducaoDependentes = 2275.08 * quantidadeDependentes; //2275,08 é o valor referente a dedução anual de cada dependente
        this.gastosSaude = gastosSaude;
        this.gastosEducacao = gastosEducacao;
        this.inss = salarioBruto * 0.11;  // 11% de INSS
    }

    @Override
    protected double calcularIR() {
        double irParcial = (salarioBruto - deducaoDependentes - inss) * 0.11; // valor referente ao IRPF
        return irParcial - (gastosSaude + gastosEducacao);
    }

    @Override
    protected double calcularOutrosImpostos() {
        return inss; // PF paga apenas INSS além do IR
    }
}