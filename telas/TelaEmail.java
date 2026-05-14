package telas;

import javax.swing.*;

public class TelaEmail extends TelaBase {

    public TelaEmail(MenuPrincipal menu) {

        super("Validar Email", menu);

        JLabel texto = new JLabel("IMPLEMENTAR VALIDAÇÃO EMAIL");

        painelCentral.add(texto);
    }
}