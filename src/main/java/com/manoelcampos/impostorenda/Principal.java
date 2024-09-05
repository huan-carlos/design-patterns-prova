package com.manoelcampos.impostorenda;

import com.manoelcampos.impostorenda.calcular.Pessoa;
import com.manoelcampos.impostorenda.calcular.PessoaFisica;
import com.manoelcampos.impostorenda.calcular.PessoaJuridica;

public class Principal {
    public static void main(String[] args) {
        Pessoa pf = new PessoaFisica("Huan Carlos","000.000.000-00", 2800, 2, 500, 600);//informar salário bruto, Nº dependentes, INSS pago, gastos saúde, gastos educação
        Pessoa pj = new PessoaJuridica("IFTO", "00.000.000/0000-00", 200000, 50000);//informar nome, cnpj, lucro, compra de produtos que incidem icms R$,

        System.out.println(pf.getNome() + " deve pagar de IR + INSS: R$" + pf.calcularImpostos());
        System.out.println(pj.getNome() + " deve pagar de IR + CSLL + ICMS: R$" + pj.calcularImpostos());
    }
}