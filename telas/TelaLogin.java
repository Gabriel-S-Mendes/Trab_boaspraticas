package telas;

import javax.swing.*;

public class TelaLogin extends TelaBase {

    public TelaLogin(MenuPrincipal menu) {

        super("Validar Login", menu);

        JLabel texto = new JLabel("IMPLEMENTAR VALIDAÇÃO LOGIN");

        painelCentral.add(texto);
    }
}