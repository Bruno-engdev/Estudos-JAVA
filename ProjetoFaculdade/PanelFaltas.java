package ProjetoFaculdade;

import java.awt.*;
import java.awt.event.*;

public class PanelFaltas extends Panel {
    public PanelFaltas() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Cabeçalho Faltas
        gbc.gridx = 0; gbc.gridy = 0; add(new Label("Registrar Faltas do Funcionário: "), gbc);

        // Pergunta sobre a falta
        gbc.gridx = 0; gbc.gridy = 1; add(new Label("Funcionário faltou?"), gbc);

        // Criando o componente Choice (lista suspensa)
        Choice faltaChoice = new Choice();
        faltaChoice.add("Selecione...");
        faltaChoice.add("Sim");
        faltaChoice.add("Não");

        gbc.gridx = 1; gbc.gridy = 1; add(faltaChoice, gbc);

        // Pergunta sobre justificativa
        gbc.gridx = 0; gbc.gridy = 2; add(new Label("Justificativa (se aplicável):"), gbc);

        // Campo de texto para justificativa
        TextField justificativaField = new TextField(30);
        gbc.gridx = 1; gbc.gridy = 2; add(justificativaField, gbc);

        // Botão para registrar a falta
        Button registrarFaltaButton = new Button("Registrar Falta");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; add(registrarFaltaButton, gbc);

        // Ação do botão de registrar a falta
        registrarFaltaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verifica se o funcionário faltou e se há justificativa
                String respostaFalta = faltaChoice.getSelectedItem();
                String justificativa = justificativaField.getText();

                if (respostaFalta.equals("Sim") && justificativa.isEmpty()) {
                    System.out.println("Falta registrada! Funcionário faltou, mas sem justificativa.");
                } else if (respostaFalta.equals("Sim")) {
                    System.out.println("Falta registrada! Funcionário faltou com justificativa: " + justificativa);
                } else {
                    System.out.println("Falta não registrada. Funcionário não faltou.");
                }
            }
        });
    }

    // Função main para visualizar o painel
    public static void main(String[] args) {
        // Criando o Frame principal
        Frame frame = new Frame("Registrar Falta de Funcionário");
        frame.setSize(500, 250);
        frame.setLayout(new BorderLayout());

        // Adicionando o painel de faltas ao frame
        frame.add(new PanelFaltas(), BorderLayout.CENTER);

        // Configurações do frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
