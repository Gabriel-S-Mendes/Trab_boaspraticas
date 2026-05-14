package telas;

import javax.swing.*;

public class TelaCNPJ extends TelaBase {

    public TelaCNPJ(MenuPrincipal menu) {

        super("Validar CNPJ", menu);

        JLabel texto = new JLabel("IMPLEMENTAR VALIDAÇÃO CNPJ");

        painelCentral.add(texto);
    }
}