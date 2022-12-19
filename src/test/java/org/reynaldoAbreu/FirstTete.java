package org.reynaldoAbreu;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class FirstTete {

    Calculadora calculadora;
    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois numeros")
    public void soma(){

        //Cenario
        int numero1 = 1, numero2 =5;

        //execução
        int resultado = calculadora.somar(numero1, numero2);

        //Verificação
        Assertions.assertThat(resultado).isEqualTo(6);
    }

    @Test
    @DisplayName("Deve subtrair dois numeros")
    public void subtrair(){

        //Cenario

        int numero1 = 1, numero2 = 5;

        //Verificação

        Assertions.assertThat(calculadora.subtrair(numero1, numero2)).isEqualTo(- 4);
    }

    @Test
    @DisplayName("Deve multiplicar dois numeros")
    public void multiplicar(){

        //Cenario

        //Execução
        int numero1 = 1, numero2 = 5;

        //Verificação

        Assertions.assertThat(calculadora.multiplicar(numero1, numero2)).isEqualTo(5);
    }

    @Test
    @DisplayName("Não deve dividir por Zero")
    public void dividirDoisNumeros(){

        //Cenario
        int numero1 = 0, numero2 = 5;

        //Execução
       org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class,() -> calculadora.dividir(numero1, numero2));
    }

    @Test
    @DisplayName("Deve dividir dois numeros")
    public void dividir(){

        //Cenario

        //Execução
        int numero1 = 4, numero2 = 2;

        //Verificação

        Assertions.assertThat(calculadora.dividir(numero1, numero2)).isEqualTo(2);
    }

}

class Calculadora{

    int somar (int numero1, int numero2){

        return numero1 + numero2;
    }

    int subtrair(int numero1, int numero2){

        return numero1 - numero2;

    }

    int multiplicar(int numero1, int numero2){

        return numero1 * numero2;
    }

    int dividir(int numero1, int numero2){

        if (numero1 == 0 || numero2 == 0){

            throw new RuntimeException("não deve dividir por 0");

        }
        return numero1 / numero2;
    }

}
