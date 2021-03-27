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
        int opc, qtdNotas, alunoExiste = 0;
        float nota = 0;
        String nomeAluno, cpfAluno;
        Aluno aluno = new Aluno();
        Sala sala = new Sala();
        Scanner entrada = new Scanner(System.in);
        
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
                    
                    for(Aluno a:sala.listaDeAlunos){
                        if(cpfAluno.equals(aluno.getCpf())){
                            System.out.println("\nEste cpf já está cadastrado!");
                            alunoExiste = 1;
                            break;
                        }
                        if(alunoExiste == 1){
                            break;
                        }
                    }
                    
                    if(alunoExiste == 0){
                        System.out.println("Quantidade de notas:");
                        qtdNotas = entrada.nextInt();

                        aluno = new Aluno(nomeAluno, cpfAluno);

                        for(int i = 0; i < qtdNotas; i++){
                            System.out.println("Nota " + (i+1) + ":");
                            nota = entrada.nextFloat();
                            aluno.insereNota(nota);
                        }

                        sala.insereAluno(aluno);
                    }
                    
                    break;
                    
                case 2:
                    if(sala.listaDeAlunos.isEmpty()){
                        System.out.println("\nNenhum aluno cadastrado");
                    }else{
                        sala.listarAlunos();
                    }
                    break;
                    
                case 3:
                    if(sala.listaDeAlunos.isEmpty()){
                        System.out.println("\nNenhum aluno cadastrado");
                    }else{
                        sala.situacoes();
                    }
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
