package com.coelhodev.desafiotarget;

import java.util.Scanner;

public class SequenciaFibonacci {
         
        public static boolean Fibonacci(int numero) {
        
        int a = 0;
        int b = 1;
        
        // Se o número informado for 0 ou 1, já está na sequência
        if (numero == a || numero == b) {
            return true;
        }
        
        int next;
        
        while (b < numero) {
            next = a + b;
            a = b;
            b = next;
            
            if (b == numero) {
                return true; 
            }
        }
        
        return false;  
    }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        System.out.print("Informe um numero: ");
        int numbero = sc.nextInt();
        
        if (Fibonacci(numbero)) {
            System.out.println(numbero + " pertence a sequencia de Fibonacci.");
        } else {
            System.out.println(numbero + " nao pertence a sequencia de Fibonacci.");
        }
        
        sc.close();
    }
}
        
        
        

