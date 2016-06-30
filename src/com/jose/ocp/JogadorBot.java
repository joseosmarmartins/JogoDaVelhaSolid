package com.jose.ocp;

import com.jose.srp.Tabuleiro;

import java.util.ArrayList;
import java.util.List;

public class JogadorBot extends Jogador {

    private boolean fazJogada;
    private boolean gerouJogo;

    public JogadorBot(int jogador){
        super(jogador);
    }

    @Override
     public void fazJogada(Tabuleiro tabuleiro){
        fazJogada = false;
        gerouJogo = false;

        marcaNoTabuleiro(tabuleiro);

        tabuleiro.setPosicao(tentativa, jogador);
        tabuleiro.mostraTabuleiro();
    }

    @Override
    public void marcaNoTabuleiro(Tabuleiro tabuleiro){
        trataHorizontal(tabuleiro);
        trataVertical(tabuleiro);
        trataDiagonal(tabuleiro);

        if (fazJogada) {
            do {
                tentativa[0] = 1 + (int) (3 * Math.random());
                tentativa[1] = 1 + (int) (3 * Math.random());

                tentativa[0]--;
                tentativa[1]--;
            } while (!verificaJogada(tentativa, tabuleiro));
        }
    }

    public void trataHorizontal(Tabuleiro tabuleiro) {
        List<Integer> linhasUm = new ArrayList<>();
        linhasUm.add(0);
        linhasUm.add(0);
        linhasUm.add(0);

        List<Integer> linhasDois = new ArrayList<>();
        linhasDois.add(1);
        linhasDois.add(1);
        linhasDois.add(1);

        List<Integer> linhasTres= new ArrayList<>();
        linhasTres.add(2);
        linhasTres.add(2);
        linhasTres.add(2);

        List<Integer> colunas = new ArrayList<>();
        colunas.add(0);
        colunas.add(1);
        colunas.add(2);

        trataLinha(tabuleiro, linhasUm, colunas);
        trataLinha(tabuleiro, linhasDois, colunas);
        trataLinha(tabuleiro, linhasTres, colunas);
    }

    public void trataVertical(Tabuleiro tabuleiro) {
        List<Integer> linhas = new ArrayList<>();
        linhas.add(0);
        linhas.add(1);
        linhas.add(2);

        List<Integer> colunasUm = new ArrayList<>();
        colunasUm.add(0);
        colunasUm.add(0);
        colunasUm.add(0);

        List<Integer> colunasDois = new ArrayList<>();
        colunasDois.add(1);
        colunasDois.add(1);
        colunasDois.add(1);

        List<Integer> colunasTres= new ArrayList<>();
        colunasTres.add(2);
        colunasTres.add(2);
        colunasTres.add(2);

        trataLinha(tabuleiro, linhas, colunasUm);
        trataLinha(tabuleiro, linhas, colunasDois);
        trataLinha(tabuleiro, linhas, colunasTres);
    }

    public void trataDiagonal(Tabuleiro tabuleiro) {
        List<Integer> linhasUm = new ArrayList<>();
        linhasUm.add(0);
        linhasUm.add(1);
        linhasUm.add(2);

        List<Integer> linhasDois = new ArrayList<>();
        linhasDois.add(2);
        linhasDois.add(1);
        linhasDois.add(0);

        trataLinha(tabuleiro, linhasUm, linhasUm);
        trataLinha(tabuleiro, linhasDois, linhasDois);
    }

    public void trataLinha(Tabuleiro tabuleiro, List<Integer> linhas, List<Integer> colunas) {
        boolean marcadaPrimeira = false;
        boolean marcadaSegunda = false;
        boolean marcadaTerceira = false;
        int contadorHorizontal = 0;

        if (tabuleiro.getTabuleiro()[linhas.get(0)][colunas.get(0)] == -1) {
            contadorHorizontal ++;
            marcadaPrimeira = true;
        }

        if (tabuleiro.getTabuleiro()[linhas.get(1)][colunas.get(1)] == -1) {
            contadorHorizontal ++;
            marcadaSegunda = true;
        }

        if (tabuleiro.getTabuleiro()[linhas.get(2)][colunas.get(2)] == -1) {
            contadorHorizontal ++;
            marcadaTerceira = true;
        }

        if (contadorHorizontal >= 2) {
            if (!gerouJogo) {
                if (!marcadaPrimeira) {
                    tabuleiro.getTabuleiro()[linhas.get(0)][colunas.get(0)] = 1;
                }
                if (!marcadaSegunda) {
                    tabuleiro.getTabuleiro()[linhas.get(1)][colunas.get(1)] = 1;
                }
                if (!marcadaTerceira) {
                    tabuleiro.getTabuleiro()[linhas.get(2)][colunas.get(2)] = 1;
                }
            }

            gerouJogo = true;
        } else {
            if (!gerouJogo) {
                fazJogada = true;
            }

            gerouJogo = true;
        }
    }
}
