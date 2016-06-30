package com.jose.ocp;

import com.jose.ocp.interfaces.IJogador;
import com.jose.srp.Tabuleiro;

public abstract class Jogador implements IJogador {

    protected int[] tentativa = new int[2];
    protected int jogador;

    public Jogador(int jogador){
        this.jogador = jogador;
    }

    public boolean verificaJogada(int[] tentativa, Tabuleiro tabuleiro){
        return tabuleiro.getPosicao(tentativa) == 0;
    }
}
