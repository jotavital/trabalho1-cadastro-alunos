/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotavital.cadastroalunos;

import java.util.ArrayList;

/**
 *
 * @author picle
 */
public class Sala {
    ArrayList<Aluno> listaDeAlunos;
    
    public Sala(){
        this.listaDeAlunos = new ArrayList<>();
    }
    
    void insereAluno(Aluno aluno){
        aluno.calculaNotas();
        listaDeAlunos.add(aluno);
    }
    
    void listarAlunos(){
        System.out.println("\n---------------");
        System.out.println("Lista de alunos");
        for(Aluno a:listaDeAlunos){
            a.listar();
        }
    }
    
    void situacoes(){
        System.out.println("\n---------------");
        System.out.println("Situações");
        for(Aluno a:listaDeAlunos){
            a.listarSituacoes();
        }
    }

    public ArrayList<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(ArrayList<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
}
