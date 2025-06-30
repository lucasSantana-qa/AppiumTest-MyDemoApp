package br.lcsantana.appium.core;

public interface Propriedades {

    TipoExecucao exec = TipoExecucao.CLOUD;

    enum TipoExecucao {
        LOCAL,
        CLOUD
    }
}
