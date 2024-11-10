package com.sistema.paineis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        // Layout principal do painel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Definindo o espaçamento entre os componentes
        gbc.insets = new Insets(20, 20, 20, 20); // Maior espaçamento entre os botões
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;  // Faz com que os botões ocupem duas colunas

        // Definindo o fundo do painel com uma cor suave
        setBackground(new Color(240, 240, 240));  // Cor de fundo suave

        // Criando o título do painel com uma fonte maior e mais destacada
        JLabel titleLabel = new JLabel("Menu de Acesso", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 51, 102)); // Azul escuro
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Botão de Acesso ao Menu de Cadastro
        JButton menucadastrarButton = new JButton("Gerenciamento de Funcionários");
        menucadastrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        menucadastrarButton.setBackground(new Color(0, 51, 102));  // Azul escuro
        menucadastrarButton.setForeground(Color.WHITE);
        menucadastrarButton.setFocusPainted(false);  // Remove o contorno do botão ao clicar
        menucadastrarButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaço interno no botão
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        add(menucadastrarButton, gbc);
        menucadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar o código para mudar de painel
                CardLayout cl = (CardLayout)(getParent().getLayout());
                cl.show(getParent(), "TabelaFuncionarios");
            }
        });

        // Botão de Acesso ao Gerenciamento de Férias
        JButton gerenciamentoFerias = new JButton("Acessar Gerenciamento de Férias");
        gerenciamentoFerias.setFont(new Font("Arial", Font.BOLD, 14));
        gerenciamentoFerias.setBackground(new Color(0, 51, 102));  // Azul escuro
        gerenciamentoFerias.setForeground(Color.WHITE);
        gerenciamentoFerias.setFocusPainted(false);  // Remove o contorno do botão ao clicar
        gerenciamentoFerias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaço interno no botão
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        add(gerenciamentoFerias, gbc);
        gerenciamentoFerias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar o código para mudar de painel
                CardLayout cl = (CardLayout)(getParent().getLayout());
                cl.show(getParent(), "TabelaFerias");
            }
        });

        // Botão de Acesso ao Gerenciamento de Horas Extras
        JButton acessoHorasExtras = new JButton("Acessar Gerenciamento Horas Extras");
        acessoHorasExtras.setFont(new Font("Arial", Font.BOLD, 14));
        acessoHorasExtras.setBackground(new Color(0, 51, 102));  // Azul escuro
        acessoHorasExtras.setForeground(Color.WHITE);
        acessoHorasExtras.setFocusPainted(false);  // Remove o contorno do botão ao clicar
        acessoHorasExtras.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaço interno no botão
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(acessoHorasExtras, gbc);
        acessoHorasExtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar o código para mudar de painel
                CardLayout cl = (CardLayout)(getParent().getLayout());
                cl.show(getParent(), "TabelaHorasExtras");
            }
        });

        // Adicionando um espaçamento extra entre os botões
        gbc.insets = new Insets(20, 20, 20, 20); // Define o espaçamento após os botões

        // Centralizando o painel de botões dentro do JFrame
        setPreferredSize(new Dimension(400, 300));  // Ajusta o tamanho preferido do painel
    }

}
