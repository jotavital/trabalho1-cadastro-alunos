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
public class Aluno {
    private String nome, cpf;
    private float soma = 0;
    ArrayList<Float> notas = new ArrayList<>();
    
    public Aluno(String nome){
        this.nome = nome;
    }
    
    public Aluno(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    
    void insereNota(float nota){
        this.notas.add(nota);
    }
    
    float calculaNotas(){
        for(int i = 0; i < notas.size(); i++){
            soma += this.notas.get(i);
        }
        
        return soma;
    }
    
    void listar(){
        System.out.println("---------------");
        System.out.println("Lista de alunos");
        System.out.println("\nNome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        
        for(int i = 0; i < notas.size(); i++){
            System.out.println("Nota " + (i + 1) + ": " + this.notas.get(i));
        }
        
        System.out.println("Total: " + this.soma);
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
