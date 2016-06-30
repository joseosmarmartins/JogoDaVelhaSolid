package com.jose;

import com.jose.ocp.Jogador;
import com.jose.ocp.JogadorBot;
import com.jose.ocp.JogadorFisico;
import com.jose.srp.Tabuleiro;

public class Jogo {

    private Tabuleiro tabuleiro;
    private Jogador jogadorFisico;
    private Jogador jogadorBot;

    public void inicializar() {
        tabuleiro = new Tabuleiro();

        tabuleiro.mostraTabuleiro();

        inicializarJogadores();

        while (jogar());
    }

    public void inicializarJogadores(){
        this.jogadorFisico = new JogadorFisico(1);
        this.jogadorBot = new JogadorBot(2);
    }

    public boolean jogar(){
        if (ganhou() == 0 ) {
            System.out.println("Sua vez");
            jogadorFisico.fazJogada(tabuleiro);
            jogadorBot.fazJogada(tabuleiro);

            if(tabuleiro.deuVelha()){
                System.out.println("Deu velha!");
                return false;
            }

            return true;
        } else {
            if (ganhou() == -1) {
                tabuleiro.mostraTabuleiro();
                System.out.println("Voce ganhou!");
            } else {
                tabuleiro.mostraTabuleiro();
                System.out.println("Voce perdeu!");
            }

            return false;
        }
    }

    public int ganhou() {
        if(tabuleiro.getLinha() == 1) {
            return 1;
        }

        if(tabuleiro.getColuna() == 1) {
            return 1;
        }

        if(tabuleiro.getDiagonal() == 1) {
            return 1;
        }

        if(tabuleiro.getLinha() == -1) {
            return -1;
        }

        if(tabuleiro.getColuna() == -1) {
            return -1;
        }

        if(tabuleiro.getDiagonal() == -1) {
            return -1;
        }

        return 0;
    }
}
