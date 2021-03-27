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
    String nome, cpf, situacao;
    float total = 0;
    ArrayList<Float> listaNotas = new ArrayList<>();
    
    public Aluno(){
        
    }
    
    public Aluno(String nome, String cpf){
        setNome(nome);
        setCpf(cpf);
    }

    void listar(){
        System.out.println("\nNome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        
        for(int i = 0; i < listaNotas.size(); i++){
            System.out.println("Nota " + (i + 1) + ": " + this.listaNotas.get(i));
        }
        
        System.out.println("Total: " + this.total);
    }
    
    void listarSituacoes(){
        System.out.println("\nNome: " + this.nome);
        System.out.println("Total: " + this.total);
        System.out.println("Situação: " + this.situacao);
    }
    
    void insereNota(float nota){
        listaNotas.add(nota);
    }
    
    void calculaNotas(){
        for(float n:listaNotas){
            total += n;
        }
        
        if(total >= 70){
            this.situacao = "Aprovado";
        }else{
            this.situacao = "Reprovado";
        }
    }
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<Float> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<Float> listaNotas) {
        this.listaNotas = listaNotas;
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
    
}
