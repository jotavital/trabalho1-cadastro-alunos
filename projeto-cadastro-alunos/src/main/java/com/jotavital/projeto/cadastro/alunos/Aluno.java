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
public class Aluno {
    private String nome, cpf;
    ArrayList<Float> notas = new ArrayList<>();
    
    public Aluno(String nome){
        
    }
    
    public Aluno(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    
    void insereNota(float nota){
        
    }
    
    float calculaNotas(){
        return 0;
    }
    
    void listar(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Float> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Float> notas) {
        this.notas = notas;
    }
    
}
