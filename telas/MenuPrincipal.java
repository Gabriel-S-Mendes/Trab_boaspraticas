package telas;

import util.Estilo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {

        setTitle("Menu");

        setSize(1200, 700);

        setMinimumSize(new Dimension(700, 500));

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        painelPrincipal.setBackground(Estilo.FUNDO);

        // =========================
        // TOPO
        // =========================

        JPanel topo = new JPanel(new BorderLayout());

        topo.setBackground(Estilo.FUNDO);

        topo.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Menu", SwingConstants.CENTER);

        titulo.setFont(Estilo.TITULO);

        topo.add(titulo, BorderLayout.CENTER);

        topo.add(new JSeparator(), BorderLayout.SOUTH);

        // =========================
        // CENTRO
        // =========================

        JPanel centro = new JPanel(new GridBagLayout());

        centro.setBackground(Estilo.FUNDO);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(25, 40, 25, 40);

        // BOTÕES
        JButton btnCSV = criarBotao("CSV");
        JButton btnClientes = criarBotao("Clientes");
        JButton btnCadastro = criarBotao("Cadastro");

        JButton btnCNPJ = criarBotao("CNPJ");

        JButton btnCPF = criarBotao("CPF");
        JButton btnEmail = criarBotao("Email");
        JButton btnLogin = criarBotao("Login");

        // LINHA 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        centro.add(btnCSV, gbc);

        gbc.gridx = 1;
        centro.add(btnCNPJ, gbc);

        gbc.gridx = 2;
        centro.add(btnCPF, gbc);

        // LINHA 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        centro.add(btnClientes, gbc);

        gbc.gridx = 2;
        centro.add(btnEmail, gbc);

        // LINHA 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        centro.add(btnCadastro, gbc);

        gbc.gridx = 2;
        centro.add(btnLogin, gbc);

        // =========================
        // AÇÕES
        // =========================

        btnCSV.addActionListener(e ->
                abrirTela(new TelaCSV(this)));

        btnClientes.addActionListener(e ->
                abrirTela(new TelaClientes(this)));

        btnCadastro.addActionListener(e ->
                abrirTela(new TelaCadastro(this)));

        btnCNPJ.addActionListener(e ->
                abrirTela(new TelaCNPJ(this)));

        btnCPF.addActionListener(e ->
                abrirTela(new TelaCPF(this)));

        btnEmail.addActionListener(e ->
                abrirTela(new TelaEmail(this)));

        btnLogin.addActionListener(e ->
                abrirTela(new TelaLogin(this)));

        painelPrincipal.add(topo, BorderLayout.NORTH);

        painelPrincipal.add(centro, BorderLayout.CENTER);

        add(painelPrincipal);

        setVisible(true);
    }

    private JButton criarBotao(String texto) {

        JButton botao = new JButton(texto);

        botao.setFont(new Font("Arial", Font.BOLD, 20));

        // TODOS DO MESMO TAMANHO
        botao.setPreferredSize(new Dimension(220, 70));

        botao.setFocusPainted(false);

        return botao;
    }

    private void abrirTela(JFrame tela) {

        tela.setVisible(true);

        setVisible(false);
    }
}