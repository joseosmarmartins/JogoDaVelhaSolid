package com.jose.ocp;

import com.jose.srp.Tabuleiro;

import java.util.Scanner;

public class JogadorFisico extends Jogador {

    public Scanner scanner = new Scanner(System.in);

    public JogadorFisico(int jogador){
        super(jogador);
        this.jogador = jogador;
    }

    @Override
    public void fazJogada(Tabuleiro tabuleiro){
        marcaNoTabuleiro(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }

    @Override
    public void marcaNoTabuleiro(Tabuleiro tabuleiro){
        do {
            do {
                System.out.print("Linha: ");
                tentativa[0] = scanner.nextInt();

                if (tentativa[0] > 3 ||tentativa[0] < 1) {
                    System.out.println("Linha inválida. É 1, 2 ou 3");
                }
            } while (tentativa[0] > 3 ||tentativa[0] < 1);

            do {
                System.out.print("Coluna: ");
                tentativa[1] = scanner.nextInt();

                if (tentativa[1] > 3 ||tentativa[1] < 1) {
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                }
            } while (tentativa[1] > 3 ||tentativa[1] < 1);

            tentativa[0]--;
            tentativa[1]--;

            if (!verificaJogada(tentativa, tabuleiro)) {
                System.out.println("Esse local já foi marcado. Tente outro.");
            }
        } while (!verificaJogada(tentativa, tabuleiro));
    }
}
