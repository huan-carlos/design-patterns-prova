package com.manoelcampos.impostorenda.calcular;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaJuridica extends Pessoa {
    private double lucro;
    private double comprasProdutosICMS;

    public PessoaJuridica(String nome, String cgc, double lucro, double comprasProdutosICMS) {
        super(nome, cgc);
        this.lucro = lucro;
        this.comprasProdutosICMS = comprasProdutosICMS;
    }

    @Override
    protected double calcularIR() {
        double irParcial = lucro * 0.15;  // valor referente ao IRPJ
        double irExcedente = irParcial - 20000; //diferença entre o IRMax e o IRParcial calculado
        double valorExcedente = irExcedente > 0 ? irExcedente * 0.1 : 0; // valor referente ao excedente
        return (irParcial + valorExcedente);
    }

    @Override
    protected double calcularOutrosImpostos() {
        double csll = lucro * 0.09;  // valor referente ao Considere a Contribuição Social sobre Lucro Líquido (CSLL)
        double icms = comprasProdutosICMS * 0.05; // valor referente ao ICMS
        return (csll + icms);
    }
}