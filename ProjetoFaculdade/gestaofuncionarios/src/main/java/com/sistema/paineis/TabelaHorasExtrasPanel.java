package com.sistema.paineis;

import com.sistema.Services.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabelaHorasExtrasPanel extends JPanel {
    Service service = new Service();  // Instancia o serviço para acessar os dados
    JTable tabela;
    TableRowSorter<TableModel> sorter;

    // Construtor sem parâmetros, que configura a JTable e adiciona ao JPanel
    public TabelaHorasExtrasPanel() {
        // Definindo o layout do painel com GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);  // Aumentando os espaçamentos

        // Definindo a cor de fundo do painel
        setBackground(new Color(242, 242, 242));  // Cor de fundo suave (cinza claro)

        // Título do painel
        JLabel titleLabel = new JLabel("Lista de Horas Extras", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(51, 51, 51));  // Cor do título
        titleLabel.setPreferredSize(new Dimension(600, 40));  // Tamanho preferido
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Ocupa duas colunas
        add(titleLabel, gbc);

        // Criando o campo de pesquisa
        JTextField searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(200, 30));

        // Adiciona o campo de pesquisa ao painel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Pesquisar: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(searchField, gbc);

        // Criando o botão "Visualizar" ao lado do campo de pesquisa
        JButton visualizarButton = new JButton("Visualizar");
        visualizarButton.setFont(new Font("Arial", Font.BOLD, 14));
        visualizarButton.setForeground(Color.WHITE);
        visualizarButton.setBackground(new Color(0, 123, 255));  // Azul vibrante
        visualizarButton.setPreferredSize(new Dimension(120, 30));  // Tamanho do botão
        visualizarButton.setFocusPainted(false);
        visualizarButton.setBorder(BorderFactory.createEmptyBorder());  // Remove bordas padrão
        visualizarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visualizarButton.setBackground(new Color(0, 102, 204));  // Cor do botão ao passar o mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                visualizarButton.setBackground(new Color(0, 123, 255));  // Cor do botão padrão
            }
        });

        // Adiciona o botão "Visualizar" ao painel
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(visualizarButton, gbc);

        // Obtendo a JTable do método que retorna a tabela com dados de horas extras
        tabela = service.getHorasExtrasTableFromDatabase();

        // Criando um TableRowSorter para permitir o filtro dinâmico
        sorter = new TableRowSorter<>(tabela.getModel());
        tabela.setRowSorter(sorter);

        // Desabilitar a edição em todas as células da tabela
        tabela.setDefaultEditor(Object.class, null);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Permitir selecionar apenas uma linha por vez
        tabela.setRowHeight(30);  // Aumentar a altura das linhas para um visual mais confortável
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));  // Ajustar fonte

        // Criando um JScrollPane para a tabela, permitindo rolagem
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(600, 300));  // Ajusta o tamanho do JScrollPane
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));  // Borda sutil

        // Adicionando o JScrollPane ao JPanel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;  // Ocupa três colunas
        add(scrollPane, gbc);

        // Adicionando um KeyListener ao campo de pesquisa para realizar a filtragem
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                // Filtro dinâmico baseado no texto digitado
                String query = searchField.getText().toLowerCase();
                if (query.length() == 0) {
                    sorter.setRowFilter(null);  // Remove o filtro, mostrando todos os dados
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));  // Filtra de forma case insensitive
                }
            }
        });

        // Botão para cadastrar novo
        JButton cadastroButton = new JButton("Cadastrar Horas Extras");
        cadastroButton.setFont(new Font("Arial", Font.BOLD, 14));
        cadastroButton.setForeground(Color.WHITE);
        cadastroButton.setBackground(new Color(0, 123, 255));  // Azul vibrante
        cadastroButton.setPreferredSize(new Dimension(150, 40));  // Tamanho do botão
        cadastroButton.setFocusPainted(false);
        cadastroButton.setBorder(BorderFactory.createEmptyBorder());  // Remove bordas padrão
        cadastroButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastroButton.setBackground(new Color(0, 102, 204));  // Cor do botão ao passar o mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadastroButton.setBackground(new Color(0, 123, 255));  // Cor do botão padrão
            }
        });

        // Botão para voltar ao menu
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setFont(new Font("Arial", Font.BOLD, 14));
        voltarButton.setForeground(Color.WHITE);
        voltarButton.setBackground(new Color(0, 123, 255));  // Azul vibrante
        voltarButton.setPreferredSize(new Dimension(150, 40));  // Tamanho do botão
        voltarButton.setFocusPainted(false);
        voltarButton.setBorder(BorderFactory.createEmptyBorder());  // Remove bordas padrão
        // Efeito de hover no botão
        voltarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltarButton.setBackground(new Color(0, 102, 204));  // Cor do botão ao passar o mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltarButton.setBackground(new Color(0, 123, 255));  // Cor do botão padrão
            }
        });

        // Adicionando os botões ao painel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(voltarButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(cadastroButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(visualizarButton, gbc);

        // Ação do botão cadastrar (Cadastrar Horas Extras)
        cadastroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "Gerenciamento Horas Extras");
            }
        });

        // Ação do botão "Visualizar"
        visualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabela.getSelectedRow();
                if (selectedRow != -1) {
                    String nomeFuncionario = (String) tabela.getValueAt(selectedRow, 0);  // Nome do funcionário
                    String data = (String) tabela.getValueAt(selectedRow, 1);  // Data das horas extras
                    String horas = (String) tabela.getValueAt(selectedRow, 2);  // Horas extras realizadas
                    // Exemplo: Exibir os dados da linha selecionada
                    JOptionPane.showMessageDialog(null, "Horas Extras selecionadas:\n" +
                            "Funcionário: " + nomeFuncionario + "\n" +
                            "Data: " + data + "\n" +
                            "Horas Extras: " + horas, "Visualizar Horas Extras", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para visualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão voltar
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "Menu");
            }
        });
    }
}
