package com.sistema.paineis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sistema.Services.*;
import com.sistema.Classes.*;

public class GerenciamentoFeriasPanel extends JPanel {  // Substituí 'Panel' por 'JPanel'

    public GerenciamentoFeriasPanel() {
        Service service = new Service();

        // Layout principal do painel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);  // Adicionando espaçamento entre os componentes

        // Definindo o fundo do painel para uma cor suave
        setBackground(new Color(240, 240, 240));  // Cor de fundo suave para contrastar com os botões

        // Cabeçalho de Gerenciamento de Férias
        JLabel titleLabel = new JLabel("GERENCIAMENTO DE FÉRIAS", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Fonte maior e em negrito
        titleLabel.setForeground(new Color(0, 51, 102));  // Azul escuro para o título
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

         JComboBox<String> funcionarios =  service.getFuncionariosFerias();
       
        // Campos para Férias
        JTextField funcionarioField = new JTextField(15);
        JTextField inicioFeriasField = new JTextField(10);  // Data de Início
        JTextField fimFeriasField = new JTextField(10);     // Data de Fim
        JTextArea historicoFeriasArea = new JTextArea(5, 40);  // Histórico de Férias

        // Estilizando os componentes
        funcionarioField.setFont(new Font("Arial", Font.PLAIN, 14));
        inicioFeriasField.setFont(new Font("Arial", Font.PLAIN, 14));
        fimFeriasField.setFont(new Font("Arial", Font.PLAIN, 14));
        historicoFeriasArea.setFont(new Font("Arial", Font.PLAIN, 14));
        historicoFeriasArea.setLineWrap(true);
        historicoFeriasArea.setWrapStyleWord(true);
        historicoFeriasArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Labels e campos para as Férias
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(new JLabel("Funcionário:"), gbc);
        gbc.gridx = 1; add(funcionarios, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Data Início Férias:"), gbc);
        gbc.gridx = 1; add(inicioFeriasField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Data Fim Férias:"), gbc);
        gbc.gridx = 1; add(fimFeriasField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Histórico de Férias:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;  // Ocupa duas colunas para o JTextArea
        add(new JScrollPane(historicoFeriasArea), gbc);  // Adicionando a área de texto dentro de um JScrollPane

        // Botão para Registrar Férias
        JButton registrarFeriasButton = new JButton("Registrar Férias");
        registrarFeriasButton.setFont(new Font("Arial", Font.BOLD, 14));
        registrarFeriasButton.setBackground(new Color(0, 51, 102));  // Azul escuro
        registrarFeriasButton.setForeground(Color.WHITE);
        registrarFeriasButton.setFocusPainted(false);  // Remove o contorno do botão ao clicar
        registrarFeriasButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaço interno no botão
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2;
        add(registrarFeriasButton, gbc);

        registrarFeriasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String nome; String datainicio; String datafim; String observações;
            nome = (String) funcionarios.getSelectedItem();
            datainicio = inicioFeriasField.getText();
            datafim = fimFeriasField.getText();
            observações = historicoFeriasArea.getText();
            EntradaFerias entradaFerias = new EntradaFerias(nome, datainicio, datafim, observações);
            service.cadastrarFerias(entradaFerias);
            }
        });

        // Botão de Voltar para o Menu
        JButton voltarMenu = new JButton("Voltar ");
        voltarMenu.setFont(new Font("Arial", Font.BOLD, 14));
        voltarMenu.setBackground(new Color(0, 51, 102));  // Azul escuro
        voltarMenu.setForeground(Color.WHITE);
        voltarMenu.setFocusPainted(false);  // Remove o contorno do botão
        voltarMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaço interno no botão
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        add(voltarMenu, gbc);

        voltarMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retorna ao painel "Menu" utilizando CardLayout
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "TabelaFerias");
            }
        });
    }

}
