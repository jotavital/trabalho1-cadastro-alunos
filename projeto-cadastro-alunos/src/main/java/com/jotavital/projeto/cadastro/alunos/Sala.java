/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotavital.projeto.cadastro.alunos;

import java.util.ArrayList;

/**
 *
 * @author picle
 */
public class Sala {
    String codigo;
    ArrayList<Aluno> listaAlunosSala;
    
    public Sala(){
       listaAlunosSala = new ArrayList<>(); 
    }
    
    public Sala(String codigoSala){
        this.codigo = codigoSala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Aluno> getListaAlunosSala() {
        return listaAlunosSala;
    }

    public void setListaAlunosSala(ArrayList<Aluno> listaAlunosSala) {
        this.listaAlunosSala = listaAlunosSala;
    }
    
    void insereAluno(Aluno al){
        this.listaAlunosSala.add(al);
    }
    
    void listarTodos(){
        
    }
    
    void verSituacoes(){
        
    }
}
