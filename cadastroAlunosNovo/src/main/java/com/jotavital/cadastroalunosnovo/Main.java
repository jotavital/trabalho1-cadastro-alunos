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
        String nome, cpf, nomeSala, titulo;
        Aluno al;
        Sala sala = null, salaEncontrada = null;
        ArrayList<Sala> salas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        
        do{
            linha();
            titulo = "SISTEMA DE ALUNOS";
            imprimirTitulo(titulo);
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
                    titulo = "CADASTRAR ALUNO";
                    imprimirTitulo(titulo);
                    
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
                    titulo = "LISTAR ALUNOS";
                    imprimirTitulo(titulo);
                    
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
                    boolean alunoExcluido = false;
                    linha();
                    titulo = "EXCLUIR ALUNOS";
                    imprimirTitulo(titulo);
                    
                    if(naoExisteSalaNenhuma(salas)){
                        
                    }else{
                        System.out.println("Cpf do aluno: ");
                        cpf = teclado.nextLine();
                        
                        for(Sala s:salas){
                            Aluno alunoEncontrado = s.procuraAluno(cpf);
                            
                            if(alunoEncontrado != null){
                                s.excluirAluno(alunoEncontrado);
                                alunoExcluido = true;
                            }
                        }
                        
                        if(alunoExcluido){
                            System.out.println("\nAluno excluido com sucesso!");
                        }else{
                            System.out.println("\nAluno não encontrado!");
                        }
                    }
                    
                    break;
                case 4:
                    linha();
                    titulo = "CRIAR SALA";
                    imprimirTitulo(titulo);
                    
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
                    linha();
                    titulo = "LISTAR SALAS";
                    imprimirTitulo(titulo);
                    
                    listarSalas(salas);
                    
                    break;
                case 6:
                    boolean salaExcluida = false;
                    linha();
                    titulo = "EXCLUIR SALAS";
                    imprimirTitulo(titulo);
                    
                    if(naoExisteSalaNenhuma(salas)){
                        
                    }else{
                        System.out.println("Código da sala: ");
                        codigoSala = teclado.nextInt();
                        teclado.nextLine();
                        
                        for(Sala s:salas){
                            salaEncontrada = procuraSala(salas, codigoSala);
                            
                            if(salaEncontrada != null){
                                salaExcluida = true;
                            }
                        }
                        
                        if(salaExcluida){
                            salas.remove(salaEncontrada);
                            System.out.println("\nSala excluída com sucesso!");
                        }else{
                            System.out.println("\nSala não encontrada!");
                        }
                    }
                    
                    break;
                case 7:
                    linha();
                    titulo = "SITUAÇÕES";
                    imprimirTitulo(titulo);
                    
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
                    linha();
                    titulo = "SAINDO...";
                    imprimirTitulo(titulo);
                    
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
                    
                    break;
            }
            
        }while(opc != 0);
        
        
        
    }
    
    public static void listarSalas(ArrayList<Sala> salas){
        
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
        System.out.println("\n----------------------------------------\n");
    }
    
    public static void imprimirTitulo(String titulo){
        System.out.println("\t" + titulo + "\n");
    }
    
}
