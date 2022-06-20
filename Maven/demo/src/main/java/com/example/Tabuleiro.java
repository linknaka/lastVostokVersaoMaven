package com.example;

public class Tabuleiro{
    private int[][] tabuleiro;

    public Tabuleiro(int[][] t){

        this.tabuleiro=t;
        exemploCampo();

    }

    public void exemploCampo(){
        addTipo(5, 1);
        addTipo(7, 1);
        addTipo(15, 1);
        addTipo(26, 1);
        addTipo(28, 1);
        addTipo(42, 1);
        addTipo(44, 1);
        addTipo(8, 2);
        addTipo(9, 2);
        addTipo(17, 2);
        addTipo(38, 2);
        addTipo(25,3);
        
    }
    public int getTipo(int index){
        return tabuleiro[index][2];
    }
    public void addTipo(int index, int tipo){
        tabuleiro[index][2]=tipo;
        
    }

    

}
