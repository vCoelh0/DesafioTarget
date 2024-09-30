package com.coelhodev.desafiotarget;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

class FaturamentoDiario {
    private int dia;
    private double valor;

    public int getDia() {
        return dia;
    }

    public double getValor() {
        return valor;
    }
}

public class Faturamento {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<FaturamentoDiario> faturamento = mapper.readValue(
                new File("faturamento.json"), new TypeReference<List<FaturamentoDiario>>() {}
            );

       
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaValores = 0.0;
            int diasComFaturamento = 0;

            
            for (FaturamentoDiario dia : faturamento) {
                double valor = dia.getValor();
                if (valor > 0) {  // Ignorar dias sem faturamento
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                    somaValores += valor;
                    diasComFaturamento++;
                }
            }

         
            double mediaMensal = somaValores / diasComFaturamento;

           
            int diasAcimaDaMedia = 0;
            for (FaturamentoDiario dia : faturamento) {
                if (dia.getValor() > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

      
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
