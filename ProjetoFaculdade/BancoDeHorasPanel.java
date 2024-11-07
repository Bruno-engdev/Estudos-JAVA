
package ProjetoFaculdade;

import java.awt.*;
import java.awt.event.*;

public class BancoDeHorasPanel extends Panel {
    public BancoDeHorasPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Cabeçalho de Banco de Horas
        gbc.gridx = 0; gbc.gridy = 0; add(new Label("BANCO DE HORAS:"), gbc);

        // Campos para Banco de Horas
        TextField funcionarioBancoField = new TextField(20);
        TextField dataField = new TextField(10);    // Hora de Saída
        TextField entradaField = new TextField(10);  // Hora de Entrada
        TextField saidaField = new TextField(10);    // Hora de Saída

        // Labels e campos para Banco de Horas
        gbc.gridx = 0; gbc.gridy = 1; add(new Label("Funcionário:"), gbc);
        gbc.gridx = 1; add(funcionarioBancoField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new Label("Data:"), gbc);
        gbc.gridx = 1; add(dataField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(new Label("Hora Entrada:"), gbc);
        gbc.gridx = 1; add(entradaField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(new Label("Hora Saída:"), gbc);
        gbc.gridx = 1; add(saidaField, gbc);

        // Botão para Registrar Banco de Horas
        Button registrarHorasButton = new Button("Registrar Banco de Horas");
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2; add(registrarHorasButton, gbc);

        registrarHorasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Banco de horas registrado para o funcionário: " + funcionarioBancoField.getText());
                // Aqui você pode implementar a lógica de persistência do banco de horas
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
