package ProjetoFaculdade;

import java.awt.*;
import java.awt.event.*;

public class GerenciamentoFeriasPanel extends Panel {
    public GerenciamentoFeriasPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Cabeçalho de Gerenciamento de Férias
        gbc.gridx = 0; gbc.gridy = 0; add(new Label("GERENCIAMENTO DE FÉRIAS:"), gbc);

        // Campos para Férias
        TextField funcionarioField = new TextField(20);
        TextField inicioFeriasField = new TextField(10);  // Data de Início
        TextField fimFeriasField = new TextField(10);     // Data de Fim
        TextArea historicoFeriasArea = new TextArea(5, 30);  // Histórico de Férias

        // Labels e campos para as Férias
        gbc.gridx = 0; gbc.gridy = 1; add(new Label("Funcionário:"), gbc);
        gbc.gridx = 1; add(funcionarioField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new Label("Data Início Férias:"), gbc);
        gbc.gridx = 1; add(inicioFeriasField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(new Label("Data Fim Férias:"), gbc);
        gbc.gridx = 1; add(fimFeriasField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(new Label("Histórico de Férias:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; add(historicoFeriasArea, gbc);

        // Botão para Registrar Férias
        Button registrarFeriasButton = new Button("Registrar Férias");
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2; add(registrarFeriasButton, gbc);

        registrarFeriasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Férias registradas para o funcionário: " + funcionarioField.getText());
                // Aqui você pode implementar a lógica de persistência das férias
            }
        });

        Button voltarMenu = new Button("Menu");
        gbc.gridx = 0; gbc.gridy = 22; gbc.gridwidth = 2; add(voltarMenu, gbc);
        
        voltarMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "Menu");
            }
        });
    }
}
