/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotavital.cadastroalunos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author picle
 */
public class Main {
    public static void main(String[] args){
        int opc, qtdNotas;
        float nota;
        String nomeAluno, cpfAluno;
        Scanner entrada = new Scanner(System.in);
        Aluno al;
        Sala sala = null;
        ArrayList<Sala> sal = new ArrayList<>();
        
        do{
            System.out.println("\n---------------");
            System.out.println("     MENU");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Situações");
            System.out.println("0 - Sair");
            opc = entrada.nextInt();
            entrada.nextLine();
            
            switch(opc){
                case 1:
                    System.out.println("\n---------------");
                    System.out.println("Inserir aluno");
                    System.out.println("\nNome:");
                    nomeAluno = entrada.nextLine();
                    System.out.println("CPF:");
                    cpfAluno = entrada.nextLine();
                    System.out.println("Quantidade de notas:");
                    qtdNotas = entrada.nextInt();
                    
                    al = new Aluno(nomeAluno, cpfAluno);
                    
                    for(int i = 0; i < qtdNotas; i++){
                        System.out.println("Nota " + (i+1) + ":");
                        nota = entrada.nextFloat();
                        al.insereNota(nota);
                    }
                    
                    sala = new Sala();
                    sal.add(sala);
                    sala.insereAluno(al);
                    break;
                    
                case 2:
                    for(Sala s:sal){
                       s.listarTodos();
                    }
                    break;
                case 3:
                    sala.verSituacoes();
                    break;
                    
                case 0:
                    System.out.println("Saindo..." );
                    break;
                    
                default:
                    System.out.println("\nOpção Inválida!");
            }
        }while(opc != 0);
    }
}
