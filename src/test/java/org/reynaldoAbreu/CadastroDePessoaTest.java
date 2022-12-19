package org.reynaldoAbreu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadastroDePessoaTest {

    @Test
    @DisplayName("Deve criar um cadstro de Pessoa")
    public void criarCadastroDePessoa() {
        //cenario e execução
        CadastroPessoa cadastroPessoa = new CadastroPessoa();

        //verificação
        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();

    }

    @Test
    @DisplayName("Deve adicionar uma pessoa")
    public void adicionarPessoa() {

        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("ruth");

        //execução
        cadastroPessoa.adicionar(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoa.getPessoas())
                .isNotEmpty()
                .hasSize( 1)
                .contains(pessoa);
    }

    @Test
    @DisplayName("Deve lançar uma exception ao adicionar uma pessoa sem nome")
    public void adicionarPessoaSemNome () {

        //cenario
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();

        //execução
        org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNomeException.class, () -> cadastroPessoa.adicionar(pessoa));

    }

    @Test
    @DisplayName("Deve remover uma pessoa do cadastro")
    public void removerUmaPessoa(){

        //cenario
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("ruth");
        cadastroPessoa.adicionar(pessoa);

        //execução
        cadastroPessoa.remover(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();

    }

    @Test
    @DisplayName("Deve lançar uma exception quando for remover uma pessoa inexistente")
    public void removerPessoa(){

        //cenario
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        //execução
        //verificação
        org.junit.jupiter.api.Assertions.assertThrows(PessoInexistenteException.class, () -> cadastroPessoa.remover(pessoa));

    }

}
