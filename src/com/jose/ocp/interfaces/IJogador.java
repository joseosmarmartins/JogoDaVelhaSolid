package com.jose.ocp.interfaces;

import com.jose.srp.Tabuleiro;

public interface IJogador {

    void fazJogada(Tabuleiro tabuleiro);

    void marcaNoTabuleiro(Tabuleiro tabuleiro);
}
