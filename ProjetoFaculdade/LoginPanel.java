package ProjetoFaculdade;

import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends Panel {
    public LoginPanel(Frame frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        TextField nome = new TextField(20);
        TextField senha = new TextField(20);
        senha.setEchoChar('*'); // Para ocultar a senha

        gbc.gridx = 0; gbc.gridy = 0; add(new Label("Usuário:"), gbc);
        gbc.gridx = 1; add(nome, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(new Label("Senha:"), gbc);
        gbc.gridx = 1; add(senha, gbc);

        // Botão de Login
        Button loginButton = new Button("Entrar");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login realizado com sucesso!");
                CardLayout cl = (CardLayout)(frame.getLayout());
                cl.show(frame, "Menu");
            }
        });
    }
}
