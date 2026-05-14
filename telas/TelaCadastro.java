package telas;

import javax.swing.*;

public class TelaCadastro extends TelaBase {

    public TelaCadastro(MenuPrincipal menu) {

        super("Cadastrar Cliente", menu);

        JLabel texto = new JLabel("IMPLEMENTAR CADASTRO");

        painelCentral.add(texto);
    }
}