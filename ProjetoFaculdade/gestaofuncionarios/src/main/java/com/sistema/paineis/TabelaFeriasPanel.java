package com.sistema.paineis;

import com.sistema.Services.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.*;

public class TabelaFeriasPanel extends JPanel {
    Service service = new Service();  // Instancia o serviço para acessar os dados
    JTable tabela;
    TableRowSorter<TableModel> sorter;
    private String nome;  // Variável de instância para armazenar o nome do funcionário selecionado

    // Construtor sem parâmetros, que configura a JTable e adiciona ao JPanel
    public TabelaFeriasPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        setBackground(new Color(242, 242, 242));

        JLabel titleLabel = new JLabel("Lista de Férias", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setPreferredSize(new Dimension(600, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Campo de pesquisa
        JTextField searchField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Pesquisar: "), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(searchField, gbc);

        // Criando a JTable
        tabela = service.getFeriasTableFromDatabase();
        sorter = new TableRowSorter<>(tabela.getModel());
        tabela.setRowSorter(sorter);
        tabela.setDefaultEditor(Object.class, null);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setRowHeight(30);
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(scrollPane, gbc);

        // MouseListener para capturar o nome quando a tabela for clicada
        tabela.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {  // Clique simples
                    int row = tabela.rowAtPoint(e.getPoint());  // Obtém a linha clicada
                    nome = tabela.getValueAt(row, 0).toString();  // Pega o nome do funcionário
                    System.out.println("Nome selecionado: " + nome);  // Para depuração
                }
            }
        });

        // Botão para excluir cadastro
        JButton excluirButton = new JButton("Excluir Cadastro");
        excluirButton.setFont(new Font("Arial", Font.BOLD, 14));
        excluirButton.setForeground(Color.WHITE);
        excluirButton.setBackground(new Color(220, 53, 69));
        excluirButton.setPreferredSize(new Dimension(150, 40));
        excluirButton.setFocusPainted(false);
        excluirButton.setBorder(BorderFactory.createEmptyBorder());

        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nome != null && !nome.isEmpty()) {
                    service.deletarFerias(nome);  // Chama o serviço para excluir
                    JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário para excluir!");
                }
            }
        });

        // Adicionando o botão ao painel
        gbc.gridx = 2;
        gbc.gridy = 3;
        add(excluirButton, gbc);
    }
}
