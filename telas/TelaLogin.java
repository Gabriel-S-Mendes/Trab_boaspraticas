package telas;

import util.Estilo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaLogin extends JFrame {

    
    private static final String USUARIO_SALVO = "gerente";
    private static final String SENHA_SALVA = "Admin@123";

    public TelaLogin(JFrame anterior) {

        setTitle("Login");
        setSize(1200, 700);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(Estilo.FUNDO);

        

        JPanel topo = new JPanel(new BorderLayout());
        topo.setBackground(Estilo.FUNDO);
        topo.setBorder(new EmptyBorder(20, 20, 10, 20));

        JLabel titulo = new JLabel("Sistema de Login", SwingConstants.CENTER);
        titulo.setFont(Estilo.TITULO);
        topo.add(titulo, BorderLayout.CENTER);
        topo.add(new JSeparator(), BorderLayout.SOUTH);

        JPanel centro = new JPanel(new GridBagLayout());
        centro.setBackground(Estilo.FUNDO);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 20, 12, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        
        boolean senhaEhForte = senhaForte(SENHA_SALVA);
        JLabel lblInfoSenha = new JLabel(
            senhaEhForte
                ? "✔ A senha cadastrada no sistema é FORTE."
                : "✘ A senha cadastrada no sistema é FRACA.",
            SwingConstants.CENTER
        );
        lblInfoSenha.setFont(new Font("Arial", Font.ITALIC, 14));
        lblInfoSenha.setForeground(senhaEhForte ? new Color(0, 130, 0) : new Color(180, 0, 0));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centro.add(lblInfoSenha, gbc);

        
        gbc.gridy = 1;
        centro.add(new JSeparator(), gbc);

       
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        centro.add(lblUsuario, gbc);

       
        JTextField campoUsuario = new JTextField(20);
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        campoUsuario.setPreferredSize(new Dimension(300, 42));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centro.add(campoUsuario, gbc);

       
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        centro.add(lblSenha, gbc);

        
        JPasswordField campoSenha = new JPasswordField(20);
        campoSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        campoSenha.setPreferredSize(new Dimension(300, 42));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centro.add(campoSenha, gbc);

        
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEntrar.setPreferredSize(new Dimension(200, 50));
        btnEntrar.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        centro.add(btnEntrar, gbc);

        
        JLabel lblResultado = new JLabel(" ", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = 5;
        centro.add(lblResultado, gbc);

        

        btnEntrar.addActionListener(e -> {
            String usuario = campoUsuario.getText().trim();
            String senha = new String(campoSenha.getPassword()).trim();

            if (usuario.isEmpty() || senha.isEmpty()) {
                lblResultado.setText("Preencha usuário e senha.");
                lblResultado.setForeground(Color.DARK_GRAY);
                return;
            }

            if (usuario.equals(USUARIO_SALVO) && senha.equals(SENHA_SALVA)) {
                lblResultado.setText("✔ Login realizado com sucesso!");
                lblResultado.setForeground(new Color(0, 150, 0));
                campoUsuario.setEnabled(false);
                campoSenha.setEnabled(false);
                btnEntrar.setEnabled(false);
            } else {
                lblResultado.setText("✘ Usuário ou senha incorretos. Tente novamente.");
                lblResultado.setForeground(new Color(200, 0, 0));
                campoSenha.setText("");
                campoSenha.requestFocus();
            }
        });

       
        campoSenha.addActionListener(e -> btnEntrar.doClick());

       

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

 
    private boolean senhaForte(String senha) {
        if (senha.length() < 8) return false;

        boolean maiuscula = false;
        boolean numero = false;
        boolean especial = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c))
                maiuscula = true;
            else if (Character.isDigit(c))
                numero = true;
            else if (!Character.isLetterOrDigit(c))
                especial = true;
        }

        return maiuscula && numero && especial;
    }
}