package telas;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class TelaClientes extends TelaBase {

    public TelaClientes(MenuPrincipal menu) {

        super("Cadastrar Cliente", menu);

        JTextArea areaTexto = new JTextArea(30, 60);
        areaTexto.setEditable(false);

        try {
            BufferedReader br = new BufferedReader(new FileReader("util/clientes.txt"));
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                areaTexto.append("Nome: " + dados[0] + "\n");
                areaTexto.append("CPF: " + dados[1] + "\n");
                areaTexto.append("Email: " + dados[2] + "\n");
                areaTexto.append("----------------\n");
            }

            br.close();

        } catch (Exception e) {
            areaTexto.setText("Erro ao carregar clientes");
        }

        JScrollPane scroll = new JScrollPane(areaTexto);
        painelCentral.add(scroll);
    }
}