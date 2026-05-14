package telas;

import util.Estilo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class TelaBase extends JFrame {

    protected JPanel painelCentral;

    public TelaBase(String tituloTela, MenuPrincipal menu) {

        setTitle(tituloTela);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // =========================
        // COPIA ESTADO DA JANELA
        // =========================

        int estado = menu.getExtendedState();

        setExtendedState(estado);

        // SE NÃO ESTIVER MAXIMIZADA
        if (estado != JFrame.MAXIMIZED_BOTH) {

            setSize(menu.getWidth(), menu.getHeight());

            setLocation(menu.getLocation());

        }

        setMinimumSize(new Dimension(700, 500));

        // =========================
        // PAINEL PRINCIPAL
        // =========================

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        painelPrincipal.setBackground(Estilo.FUNDO);

        // =========================
        // TOPO
        // =========================

        JPanel topo = new JPanel(new BorderLayout());

        topo.setBackground(Estilo.FUNDO);

        topo.setBorder(new EmptyBorder(15, 20, 15, 20));

        JPanel painelTitulo = new JPanel(new GridBagLayout());

        painelTitulo.setBackground(Estilo.FUNDO);

        GridBagConstraints gbc = new GridBagConstraints();

        // BOTÃO VOLTAR
        JButton voltar = new JButton("Voltar");

        voltar.setFont(new Font("Arial", Font.BOLD, 16));

        voltar.setPreferredSize(new Dimension(130, 45));

        voltar.setFocusPainted(false);

        voltar.addActionListener(e -> {

            // RESTAURA ESTADO
            menu.setExtendedState(getExtendedState());

            // RESTAURA TAMANHO CASO NÃO ESTEJA MAXIMIZADA
            if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {

                menu.setSize(getWidth(), getHeight());

                menu.setLocation(getLocation());
            }

            menu.setVisible(true);

            dispose();
        });

        // TÍTULO
        JLabel titulo = new JLabel(tituloTela);

        titulo.setFont(Estilo.TITULO);

        gbc.gridx = 0;
        painelTitulo.add(voltar, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        painelTitulo.add(titulo, gbc);

        // ESPAÇO INVISÍVEL
        JPanel espaco = new JPanel();

        espaco.setOpaque(false);

        espaco.setPreferredSize(new Dimension(130, 45));

        gbc.gridx = 2;
        gbc.weightx = 0;

        painelTitulo.add(espaco, gbc);

        topo.add(painelTitulo, BorderLayout.CENTER);

        topo.add(new JSeparator(), BorderLayout.SOUTH);

        // =========================
        // CENTRO
        // =========================

        painelCentral = new JPanel();

        painelCentral.setBackground(Estilo.FUNDO);

        painelCentral.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER,
                        30,
                        40
                )
        );

        painelPrincipal.add(topo, BorderLayout.NORTH);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        add(painelPrincipal);

        setVisible(true);
    }
}