package telas;

import javax.swing.*;

public class TelaCPF extends TelaBase {

    public TelaCPF(MenuPrincipal menu) {

        super("Validar CPF", menu);

        JLabel texto = new JLabel("IMPLEMENTAR VALIDAÇÃO CPF");

        painelCentral.add(texto);
    }
}