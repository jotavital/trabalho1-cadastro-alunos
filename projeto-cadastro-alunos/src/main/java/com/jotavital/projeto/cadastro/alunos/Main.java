/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotavital.projeto.cadastro.alunos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author picle
 */
public class Main {
    public static void main(String[] args){
        int opc, qtdNotas, salaExiste = 0;
        float nota;
        String nomeAluno, cpfAluno, codSala;
        Scanner entrada = new Scanner(System.in);
        Aluno al;
        ArrayList<Sala> sal = new ArrayList<Sala>();
        
        do{
            System.out.println("\nMENU");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Situações");
            System.out.println("0 - Sair");
            opc = entrada.nextInt();
            entrada.nextLine();
            
            switch(opc){
                case 1:
                    System.out.println("\nInserir aluno");
                    System.out.println("\nNome:");
                    nomeAluno = entrada.nextLine();
                    System.out.println("\nCPF:");
                    cpfAluno = entrada.nextLine();
                    System.out.println("\nQuantidade de notas:");
                    qtdNotas = entrada.nextInt();
                    
                    for(int i = 0; i < qtdNotas; i++){
                        System.out.println("\nNota " + (i+1) + ":");
                        nota = entrada.nextFloat();
                    }
                    
                    al = new Aluno(nomeAluno, cpfAluno);
                    System.out.println("\nCodigo da Sala:");
                    codSala = entrada.nextLine();
                    
                    for(int i = 0; i < sal.size(); i++){
                        if(codSala.equals(sal.get(i).getCodigo())){
                            salaExiste = 1;
                            break;
                        }
                    }
                    
                    if(salaExiste == 1){
                        //cadastrar aluno naquela sala
                    }else{
                        System.out.println("\nNão existe uma sala com esse código!");
                    }
                    break;

                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }
        }while(opc != 0);
    }
}
