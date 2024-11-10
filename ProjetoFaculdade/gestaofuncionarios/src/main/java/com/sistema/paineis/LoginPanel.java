package com.sistema.paineis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel {


    public LoginPanel() {

        // Setando o layout para o painel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Criando os campos de entrada para o usuário e senha
        JTextField nome = new JTextField(20);
        JPasswordField senha = new JPasswordField(20); // Usando JPasswordField para senha
        senha.setEchoChar('*'); // Para esconder a senha com o caractere '*'

        // Adicionando rótulos e campos no layout
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; 
        add(new JLabel("Usuário:"), gbc);
        gbc.gridx = 1; add(nome, gbc);

        gbc.gridx = 0; gbc.gridy = 2; 
        add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1; add(senha, gbc);

        // Botão de Login
        JButton loginButton = new JButton("Entrar");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(loginButton, gbc);

        // Ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = nome.getText();
                char[] senhaArray = senha.getPassword();
                String senhaTexto = new String(senhaArray);

                // Validando se o usuário e senha estão corretos
                if (usuario.equals("admin") && senhaTexto.equals("admin")) {
                    System.out.println("Login realizado com sucesso!");

                    // Usando CardLayout para transitar entre os painéis
                    CardLayout cl = (CardLayout)(getParent().getLayout());
                    cl.show(getParent(), "Menu");  // Certifique-se de ter um painel chamado "Menu"
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Usuário ou senha inválidos", 
                            "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
