package telas;

import javax.swing.*;

public class TelaCSV extends TelaBase {

    public TelaCSV(MenuPrincipal menu) {

        super("Gerenciar CSV", menu);

        JLabel texto = new JLabel("IMPLEMENTAR GERENCIAMENTO CSV");

        painelCentral.add(texto);
    }
}