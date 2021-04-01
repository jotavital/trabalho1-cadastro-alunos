/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotavital.cadastroalunosnovo;

import java.util.Scanner;

import java.util.ArrayList;
/**
 *
 * @author jotavital
 */
public class Main {
    
    public static void main(String[] args) {
        int opc, qtdNotas, codigoSala, salaJaExiste = 0;
        String nome, cpf, nomeSala;
        Aluno al;
        Sala sala = null, salaEncontrada;
        ArrayList<Sala> salas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        
        do{
            linha();
            System.out.println("SISTEMA DE ALUNOS\n");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Excluir alunos");
            System.out.println("4 - Criar sala");
            System.out.println("5 - Listar salas");
            System.out.println("6 - Excluir sala");
            System.out.println("7 - Situações");
            System.out.println("0 - Sair");
            opc = teclado.nextInt();
            teclado.nextLine();
            System.out.println("\n");
            
            switch(opc){
                case 1:
                    linha();
                    System.out.println("CADASTRAR ALUNO");
                    
                    if(naoExisteSalaNenhuma(salas)){
                        break;
                    }else{
                        System.out.println("\nNome:");
                        nome = teclado.nextLine();
                        System.out.println("\nCpf:");
                        cpf = teclado.nextLine();

                        al = new Aluno(nome, cpf);

                        System.out.println("\nQuantidade de notas: ");
                        qtdNotas = teclado.nextInt();

                        for (int i = 0; i < qtdNotas; i++) {
                            System.out.println("Nota " + (i + 1) + ": ");
                            al.insereNota(teclado.nextFloat());
                        }
                        
                        System.out.println("\nCódigo da sala do aluno: ");
                        codigoSala = teclado.nextInt();
                        
                        salaEncontrada = procuraSala(salas, codigoSala);
                        
                        if(salaEncontrada != null){
                            salaEncontrada.insereAluno(al);
                            System.out.println("\nAluno inserido!");
                        }
                    }
                    
                    break;
                case 2:
                    linha();
                    System.out.println("LISTAR ALUNOS");
                    
                    if(naoExisteSalaNenhuma(salas)){
                        break;
                    }else{
                        System.out.println("\nCódigo da sala: [0 para listar todas]");
                        codigoSala = teclado.nextInt();

                        if(codigoSala == 0){
                            listarTodosAlunos(salas);
                        }else{
                            salaEncontrada = procuraSala(salas, codigoSala);
                            
                            if(salaEncontrada != null){
                                salaEncontrada.listarAlunos();
                            }else{
                                System.out.println("\nSala não encontrada!");
                            }
                        }
                    }
                    
                    break;
                case 3:
                    linha();
                    System.out.println("EXCLUIR ALUNOS");
                    
                    break;
                case 4:
                    linha();
                    System.out.println("CRIAR SALA");
                    System.out.println("\nCodigo: ");
                    codigoSala = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("\nNome da sala: ");
                    nomeSala = teclado.nextLine();
                    
                    salaEncontrada = procuraSala(salas, codigoSala);
                    
                    if(salaEncontrada != null){
                        System.out.println("Já existe uma sala com esse código");
                        break;
                    }else{
                        sala = new Sala(codigoSala, nomeSala);
                        salas.add(sala);
                        
                        System.out.println("\nSala criada!");
                    }
                    
                    break;
                case 5:
                    listarSalas(salas);
                    
                    break;
                case 6:
                    //excluir sala
                    
                    break;
                case 7:
                    linha();
                    System.out.println("SITUAÇÕES");
                    
                    if(naoExisteSalaNenhuma(salas)){
                        break;
                    }else{
                        System.out.println("\nCódigo da sala: [0 para listar todas]");
                        codigoSala = teclado.nextInt();
                        
                        if(codigoSala == 0){
                            listarTodasSituacoes(salas);
                        }else{
                            salaEncontrada = procuraSala(salas, codigoSala);
                            
                            if(salaEncontrada != null){
                                salaEncontrada.listarSituacoes();
                            }else{
                                System.out.println("\nSala não encontrada!");
                            }
                        }
                    }
                    
                    break;
                case 0:
                    System.out.println("\nSAINDO...");
                    
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
                    
                    break;
            }
            
        }while(opc != 0);
        
        
        
    }
    
    public static void listarSalas(ArrayList<Sala> salas){
        System.out.println("LISTAR SALAS");
        
        if(!naoExisteSalaNenhuma(salas)){
            for(Sala s:salas){
                linha();
                System.out.println("Nome: " + s.getNome());
                System.out.println("Código: " + s.getCodigo());
            }
        }
    }
    
    public static Sala procuraSala(ArrayList<Sala> salas, int codigoSala){
        
        for(Sala s:salas){
            if(s.getCodigo() == codigoSala){
                return s;
            }
        }
        
        return null;
    }
    
    public static void listarTodosAlunos(ArrayList<Sala> salas){
        for(Sala s:salas){
            s.listarAlunos();
        }
    }
    
    public static void listarTodasSituacoes(ArrayList<Sala> salas){
        for(Sala s:salas){
            s.listarSituacoes();
        }
    }
    
    public static boolean naoExisteSalaNenhuma(ArrayList<Sala> salas){
        if(salas.isEmpty()){
            System.out.println("\nAinda não existe nenhuma sala, por favor, crie uma.");
            return true;
        }else{
            return false;
        }
    }
    
    public static void linha(){
        System.out.println("\n--------------------\n");
    }
    
}
