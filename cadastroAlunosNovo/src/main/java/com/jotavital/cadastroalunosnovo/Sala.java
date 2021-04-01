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
public class Sala {
    int codigo;
    String nome;
    ArrayList<Aluno> alunos = new ArrayList<>();
    
    public Sala(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public void insereAluno(Aluno al){
        this.alunos.add(al);
    }
    
    public void listarAlunos(){
        if(salaVazia()){
            
        }else{
            for(Aluno a:alunos){
                int i = 1;
                Main.linha();
                System.out.println("Nome: " + a.getNome());
                System.out.println("Cpf: " + a.getCpf());
                System.out.println("Sala: " + this.getCodigo());

                for(Float n:a.notasAluno){
                    System.out.println("Nota " + i + ": " + n);
                    i++;
                }

                System.out.println("Total: " + a.total);
            }
        }
    }
    
    public void listarSituacoes(){
        if(salaVazia()){
            
        }else{
            for(Aluno a:alunos){
                int i = 1;
                Main.linha();
                System.out.println("Nome: " + a.getNome());
                System.out.println("Sala: " + codigo);
                System.out.println("Total: " + a.total);
                System.out.println("Situação: " + a.situacao);
            }
        }
    }
    
    public boolean salaVazia(){
        if(alunos.isEmpty()){
            System.out.println("\nNenhum aluno na sala " + this.codigo);
            return true;
        }else
            return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList alunos) {
        this.alunos = alunos;
    }
    
    
}
