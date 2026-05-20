package telas;

import util.Estilo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaEmail extends JFrame {

    public TelaEmail(JFrame anterior) {

        setTitle("Validador de Email");
        setSize(1200, 700);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(Estilo.FUNDO);

        

        JPanel topo = new JPanel(new BorderLayout());
        topo.setBackground(Estilo.FUNDO);
        topo.setBorder(new EmptyBorder(20, 20, 10, 20));

        JLabel titulo = new JLabel("Validador de Email", SwingConstants.CENTER);
        titulo.setFont(Estilo.TITULO);
        topo.add(titulo, BorderLayout.CENTER);
        topo.add(new JSeparator(), BorderLayout.SOUTH);

        

        JPanel centro = new JPanel(new GridBagLayout());
        centro.setBackground(Estilo.FUNDO);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

       
        JLabel lblEmail = new JLabel("Digite um email:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centro.add(lblEmail, gbc);

       
        JTextField campoEmail = new JTextField(30);
        campoEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        campoEmail.setPreferredSize(new Dimension(400, 45));
        gbc.gridy = 1;
        centro.add(campoEmail, gbc);

        
        JButton btnValidar = new JButton("Validar");
        btnValidar.setFont(new Font("Arial", Font.BOLD, 18));
        btnValidar.setPreferredSize(new Dimension(200, 50));
        btnValidar.setFocusPainted(false);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        centro.add(btnValidar, gbc);

      
        JLabel lblResultado = new JLabel(" ", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 3;
        centro.add(lblResultado, gbc);


        btnValidar.addActionListener(e -> {
            String email = campoEmail.getText().trim();

            if (email.isEmpty()) {
                lblResultado.setText("Por favor, digite um email.");
                lblResultado.setForeground(Color.DARK_GRAY);
                return;
            }

            if (validarEmail(email)) {
                lblResultado.setText("✔ Email válido!");
                lblResultado.setForeground(new Color(0, 150, 0));
            } else {
                lblResultado.setText("✘ Email inválido!");
                lblResultado.setForeground(new Color(200, 0, 0));
            }
        });

     
        campoEmail.addActionListener(e -> btnValidar.doClick());

        

        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rodape.setBackground(Estilo.FUNDO);
        rodape.setBorder(new EmptyBorder(10, 20, 20, 20));

        JButton btnVoltar = new JButton("← Voltar");
        btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(e -> {
            anterior.setVisible(true);
            dispose();
        });
        rodape.add(btnVoltar);

        painelPrincipal.add(topo, BorderLayout.NORTH);
        painelPrincipal.add(centro, BorderLayout.CENTER);
        painelPrincipal.add(rodape, BorderLayout.SOUTH);

        add(painelPrincipal);
        setVisible(true);
    }

    private boolean validarEmail(String email) {
       
        String regex = "^[\\w.+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
}