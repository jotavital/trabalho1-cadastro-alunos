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
    ArrayList<Aluno> listaAlunosSala;
    
    public Sala(){
       listaAlunosSala = new ArrayList<>(); 
    }

    public ArrayList<Aluno> getListaAlunosSala() {
        return listaAlunosSala;
    }

    public void setListaAlunosSala(ArrayList<Aluno> listaAlunosSala) {
        this.listaAlunosSala = listaAlunosSala;
    }
    
    void insereAluno(Aluno al){
        this.listaAlunosSala.add(al);
        al.calculaNotas();
    }
    
    void listarTodos(){
        for(Aluno a:listaAlunosSala){
            a.listar();
        }
    }
    
    void verSituacoes(){
        for(Aluno a:listaAlunosSala){
            a.listar();
            
            if(a.calculaNotas() < 70){
                System.out.println("Situação: Reprovado" );
            }else{
                System.out.println("Situação: Aprovado" );
            }
            
        }
    }
}
