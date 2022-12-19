package org.reynaldoAbreu;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {
    private List<Pessoa> pessoas;

    public CadastroPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return this.pessoas;

    }

    public void adicionar(Pessoa pessoa) {
        if (pessoa.getNome() == null){
            throw new PessoaSemNomeException();
        }

        this.getPessoas().add(pessoa);
    }

    public void remover(Pessoa pessoa) {

        if (!this.getPessoas().contains(pessoa)){
            throw new PessoInexistenteException();
        }
        this.getPessoas().remove(pessoa);
    }
}
