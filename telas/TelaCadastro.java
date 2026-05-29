package telas;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;

public class TelaCadastro extends TelaBase {

    public TelaCadastro(MenuPrincipal menu) {

        super("Cadastrar Cliente", menu);

        painelCentral.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // ===== AUMENTO GLOBAL (3x visual) =====
        Insets insets = new Insets(30, 30, 30, 30); // antes 12
        gbc.insets = insets;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fonteLabel = new Font("Arial", Font.BOLD, 20);
        Font fonteInput = new Font("Arial", Font.PLAIN, 20);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(fonteLabel);

        JTextField txtNome = new JTextField(25);
        txtNome.setFont(fonteInput);
        txtNome.setPreferredSize(new Dimension(450, 45));

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setFont(fonteLabel);

        JTextField txtCpf = new JTextField(25);
        txtCpf.setFont(fonteInput);
        txtCpf.setPreferredSize(new Dimension(450, 45));

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(fonteLabel);

        JTextField txtEmail = new JTextField(25);
        txtEmail.setFont(fonteInput);
        txtEmail.setPreferredSize(new Dimension(450, 45));

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 22));
        btnSalvar.setPreferredSize(new Dimension(500, 60));

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String email = txtEmail.getText();

            try {
                File arquivo = new File("util/clientes.txt");

                if (!arquivo.exists()) {
                    arquivo.createNewFile();
                }

                FileWriter fw = new FileWriter(arquivo, true);
                fw.write(nome + ";" + cpf + ";" + email + "\n");
                fw.close();

                JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");

                txtNome.setText("");
                txtCpf.setText("");
                txtEmail.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar cliente.");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCentral.add(lblNome, gbc);

        gbc.gridx = 1;
        painelCentral.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCentral.add(lblCpf, gbc);

        gbc.gridx = 1;
        painelCentral.add(txtCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelCentral.add(lblEmail, gbc);

        gbc.gridx = 1;
        painelCentral.add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painelCentral.add(btnSalvar, gbc);
    }
}
