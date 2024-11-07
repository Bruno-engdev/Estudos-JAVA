package ProjetoFaculdade;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ReportarFaltasPanel extends JPanel {

    public ReportarFaltasPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Cabeçalho do painel
        JLabel tituloLabel = new JLabel("Relatório de Faltas");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; add(tituloLabel, gbc);

        // Data da falta
        JLabel dataLabel = new JLabel("Data da Falta (DD/MM/AAAA):");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; add(dataLabel, gbc);
        
        JTextField dataField = new JTextField(10);  // Para a data
        gbc.gridx = 1; gbc.gridy = 1; add(dataField, gbc);

        // Motivo da falta
        JLabel motivoLabel = new JLabel("Motivo da Falta:");
        gbc.gridx = 0; gbc.gridy = 2; add(motivoLabel, gbc);
        
        JTextField motivoField = new JTextField(20);  // Para o motivo
        gbc.gridx = 1; gbc.gridy = 2; add(motivoField, gbc);

        // Observações (opcional)
        JLabel observacaoLabel = new JLabel("Observações (opcional):");
        gbc.gridx = 0; gbc.gridy = 3; add(observacaoLabel, gbc);
        
        JTextArea observacaoArea = new JTextArea(5, 20);  // Para observações
        observacaoArea.setLineWrap(true);  // Para quebra automática de linha
        observacaoArea.setWrapStyleWord(true);  // Para palavras inteiras
        JScrollPane scrollObservacao = new JScrollPane(observacaoArea);  // Adiciona o JScrollPane
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridheight = 2; add(scrollObservacao, gbc);

        // Botão de "Registrar Falta"
        JButton registrarFaltaButton = new JButton("Registrar Falta");
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridheight = 1; add(registrarFaltaButton, gbc);

        // Ação do botão
        registrarFaltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = dataField.getText();
                String motivo = motivoField.getText();
                String observacao = observacaoArea.getText();
                
                // Aqui você pode adicionar a lógica para salvar ou registrar a falta
                // Por enquanto, apenas imprime no console
                System.out.println("Falta registrada:");
                System.out.println("Data: " + data);
                System.out.println("Motivo: " + motivo);
                System.out.println("Observação: " + observacao);
                
                // Limpa os campos após registrar a falta
                dataField.setText("");
                motivoField.setText("");
                observacaoArea.setText("");
            }
        });

    }
}
