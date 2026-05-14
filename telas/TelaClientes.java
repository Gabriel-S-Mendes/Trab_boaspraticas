package telas;

import javax.swing.*;

public class TelaClientes extends TelaBase {

    public TelaClientes(MenuPrincipal menu) {

        super("Exibir Clientes", menu);

        JLabel texto = new JLabel("IMPLEMENTAR EXIBIÇÃO DE CLIENTES");

        painelCentral.add(texto);
    }
}