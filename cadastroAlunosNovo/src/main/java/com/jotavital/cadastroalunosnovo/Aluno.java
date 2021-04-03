/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotavital.cadastroalunosnovo;

import java.util.ArrayList;

/**
 *
 * @author jotavital
 */
public class Aluno {
    String nome, cpf, situacao = "REPROVADO";
    float total;
    ArrayList<Float> notasAluno = new ArrayList<>();
    
    public Aluno(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public void insereNota(float nota){
        this.notasAluno.add(nota);
        calculaNotas(notasAluno);
    }
    
    public void calculaNotas(ArrayList<Float> notasAluno){
        total = 0;
        
        for(Float n:notasAluno){
            total += n;
        }
        
        if(total < 70){
            situacao = "REPROVADO";
        }else{
            situacao = "APROVADO";
        }
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

    public ArrayList getNotasAluno() {
        return notasAluno;
    }

    public void setNotasAluno(ArrayList notasAluno) {
        this.notasAluno = notasAluno;
    }
    
}
