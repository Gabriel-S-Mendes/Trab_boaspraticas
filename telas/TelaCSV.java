package telas;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class TelaCSV extends TelaBase {

    public TelaCSV(MenuPrincipal menu) {

        super("Gerenciar CSV", menu);

        JTextArea areaTexto = new JTextArea(30, 60);
        areaTexto.setEditable(false);

        try {
            BufferedReader br = new BufferedReader(new FileReader("util/estados.csv"));
            String linha;

            while ((linha = br.readLine()) != null) {

                if (linha.trim().isEmpty()) continue;

                String[] dados = linha.split(";");

                if (dados.length >= 3) {
                    String uf = dados[0];
                    String estado = dados[1];
                    String descricao = dados[2];

                    areaTexto.append("UF: " + uf + "\n");
                    areaTexto.append("Estado: " + estado + "\n");
                    areaTexto.append("Descrição: " + descricao + "\n");
                    areaTexto.append("-------------------------\n");
                }
            }

            br.close();

        } catch (Exception e) {
            areaTexto.setText("Erro ao abrir o arquivo CSV.");
        }

        JScrollPane scroll = new JScrollPane(areaTexto);
        painelCentral.add(scroll);
    }
}