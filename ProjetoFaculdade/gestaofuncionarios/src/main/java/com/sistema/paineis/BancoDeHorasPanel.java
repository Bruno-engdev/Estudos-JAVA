package com.sistema.paineis;

import com.sistema.Classes.*;
import com.sistema.Services.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BancoDeHorasPanel extends JPanel {

    public BancoDeHorasPanel() {

        Service service = new Service();
        // Layout principal do painel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);  // Maior espaçamento entre os componentes

        // Definindo o fundo do painel para uma cor suave
        setBackground(new Color(240, 240, 240));  // Cor de fundo suave

        // Cabeçalho de Banco de Horas
        JLabel titleLabel = new JLabel("BANCO DE HORAS", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Fonte grande e em negrito
        titleLabel.setForeground(new Color(0, 51, 102));  // Azul escuro
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);


        // Campos para Banco de Horas
        TextField dataField = new TextField(10);    // Data
        TextField entradaField = new TextField(10);  // Hora de Entrada
        TextField saidaField = new TextField(10);    // Hora de Saída

        JComboBox<String> funcionarios =  service.getFuncionariosFerias();

        // Estilizando os componentes
        dataField.setFont(new Font("Arial", Font.PLAIN, 14));
        entradaField.setFont(new Font("Arial", Font.PLAIN, 14));
        saidaField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Labels e campos para Banco de Horas
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(new JLabel("Funcionário:"), gbc);
        gbc.gridx = 1; add(funcionarios, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Data:"), gbc);
        gbc.gridx = 1; add(dataField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Hora Entrada:"), gbc);
        gbc.gridx = 1; add(entradaField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Hora Saída:"), gbc);
        gbc.gridx = 1; add(saidaField, gbc);

        // Botão para Registrar Banco de Horas
        JButton registrarHorasButton = new JButton("Registrar Banco de Horas");
        registrarHorasButton.setFont(new Font("Arial", Font.BOLD, 14));
        registrarHorasButton.setBackground(new Color(0, 51, 102));  // Azul escuro
        registrarHorasButton.setForeground(Color.WHITE);
        registrarHorasButton.setFocusPainted(false);  // Remove o contorno do botão
        registrarHorasButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaço interno no botão
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2;
        add(registrarHorasButton, gbc);

        registrarHorasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Service service = new Service();
                EntradaHoras entradaHoras = new EntradaHoras();
                entradaHoras.setNome((String)funcionarios.getSelectedItem());
                entradaHoras.setData(dataField.getText());
                entradaHoras.setHoraEntrada(entradaField.getText());
                entradaHoras.setHoraSaida(saidaField.getText());
                
                service.cadastrarBancoDeHoras(entradaHoras);
                // exibir mensagem que o cadastro foi realizado com sucesso
                JOptionPane.showMessageDialog(BancoDeHorasPanel.this, "Cadastro de Horas realizado com sucesso!");
            }
        });

        // Botão de Voltar para o Menu
        JButton voltarMenu = new JButton("Voltar");
        voltarMenu.setFont(new Font("Arial", Font.BOLD, 14));
        voltarMenu.setBackground(new Color(0, 51, 102));   // Azul escuro
        voltarMenu.setForeground(Color.WHITE);
        voltarMenu.setFocusPainted(false);  // Remove o contorno do botão
        voltarMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaço interno no botão
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        add(voltarMenu, gbc);

        voltarMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retorna ao painel "Menu" utilizando CardLayout
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "TabelaHorasExtras");
            }
        });
    }

}
