package com.sistema.paineis;

import com.sistema.Classes.Funcionário;
import com.sistema.Services.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class TabelaFuncionariosPanel extends JPanel {
    Service service = new Service();
        JTable tabela;
            TableRowSorter<TableModel> sorter;
                    
                        public TabelaFuncionariosPanel() {
                            // Definindo o layout
                            setLayout(new GridBagLayout());
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            gbc.insets = new Insets(10, 10, 10, 10);
                    
                            // Definindo a cor de fundo do painel
                            setBackground(new Color(242, 242, 242));
                    
                            // Título do painel
                            JLabel titleLabel = new JLabel("Lista de Funcionários", JLabel.CENTER);
                            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
                            titleLabel.setForeground(new Color(51, 51, 51));
                            titleLabel.setPreferredSize(new Dimension(600, 40));
                            gbc.gridx = 0;
                            gbc.gridy = 0;
                            gbc.gridwidth = 2;
                            add(titleLabel, gbc);
                    
                            // Criando um JTextField para pesquisa
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
                            visualizarButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                            int row = tabela.getSelectedRow();
                            if (row != -1) {  // Verifica se uma linha foi selecionada
                                String nomeFuncionario = tabela.getValueAt(row, 0).toString();
                                // Suponha que você já tenha o objeto funcionario recuperado
                                Funcionário func = service.buscarFuncionarioPorNome(nomeFuncionario);
                                
                                // Criar o painel de detalhes e passar os dados
                                DetalhesFuncionarioPanel detalhesPanel = new DetalhesFuncionarioPanel(func);
                                
                                // Trocar o painel para o de detalhes
                                CardLayout cl = (CardLayout) getParent().getLayout();
                                getParent().add(detalhesPanel, "DetalhesFuncionarioPanel");
                                cl.show(getParent(), "DetalhesFuncionarioPanel");
                            } else {
                                JOptionPane.showMessageDialog(null, "Selecione uma linha para visualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    
                            // Adiciona o botão "Visualizar" ao painel
                            gbc.gridx = 2;
                            gbc.gridy = 1;
                            add(visualizarButton, gbc);
                    
                            // Adicionando um KeyListener ao campo de pesquisa para realizar a filtragem
                            searchField.addKeyListener(new KeyAdapter() {
                                public void keyReleased(KeyEvent e) {
                                    // Filtro dinâmico baseado no texto digitado
                                    String query = searchField.getText().toLowerCase();
                                    if (query.length() == 0) {
                                        sorter.setRowFilter(null);  // Remove o filtro, mostrando todos os dados
                                    } else {
                                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));  // Filtra de forma case insensitive
                                    }
                                }
                            });
                    
                            // Obtendo a JTable do método que retorna a tabela com dados
                            tabela = service.getFuncionariosTableFromDatabase();
                    
                            // Criando um TableRowSorter para permitir o filtro dinâmico
                            sorter = new TableRowSorter<>(tabela.getModel());
                            tabela.setRowSorter(sorter);
                    
                            // Desabilitar a edição em todas as células da tabela
                            tabela.setDefaultEditor(Object.class, null);
                            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Permitir selecionar apenas uma linha por vez
                            tabela.setRowHeight(30);  // Aumentar a altura das linhas para um visual mais confortável
                            tabela.setFont(new Font("Arial", Font.PLAIN, 14));  // Ajustar fonte
                    
                            // Criando um JScrollPane para a tabela
                            JScrollPane scrollPane = new JScrollPane(tabela);
                            scrollPane.setPreferredSize(new Dimension(600, 300));  // Ajusta o tamanho do JScrollPane
                            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));  // Borda sutil
                    
                            // Adicionando o JScrollPane ao JPanel
                            gbc.gridx = 0;
                            gbc.gridy = 2;
                            gbc.gridwidth = 3;
                            add(scrollPane, gbc);
                    
                            // Botão para cadastrar novo
                            JButton cadastroButton = new JButton("Novo Cadastro");
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
                    
                            // Adicionando o botão cadastrar ao painel
                            gbc.gridx = 1;
                            gbc.gridy = 3;
                            gbc.gridwidth = 1;
                            add(cadastroButton, gbc);
                    
                            // Ação do botão cadastrar
                            cadastroButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    CardLayout cl = (CardLayout) getParent().getLayout();
                                    cl.show(getParent(), "Cadastro");
                                }
                            });
                    
                            // Ação do botão "Visualizar"
                            visualizarButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    int row = tabela.getSelectedRow();
                                    if (row != -1) {  // Verifica se uma linha foi selecionada
                                        String nomeFuncionario = tabela.getValueAt(row, 0).toString();
                                        // Suponha que você já tenha o objeto funcionario recuperado
                                        Funcionário func = service.buscarFuncionarioPorNome(nomeFuncionario);
                                        
                                        // Criar o painel de detalhes e passar os dados
                                        DetalhesFuncionarioPanel detalhesPanel = new DetalhesFuncionarioPanel(func);
                                        
                                        // Trocar o painel para o de detalhes
                                        CardLayout cl = (CardLayout) getParent().getLayout();
                                        getParent().add(detalhesPanel, "DetalhesFuncionarioPanel");
                                        cl.show(getParent(), "DetalhesFuncionarioPanel");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Selecione uma linha para visualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            
                    
                            // Adicionando o botão Voltar
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
                    
                            // Adicionando o botão Voltar ao painel
                            gbc.gridx = 0;
                            gbc.gridy = 3;
                            gbc.gridwidth = 1;
                            add(voltarButton, gbc);
                    
                            // Ação do botão Voltar
                            voltarButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    CardLayout cl = (CardLayout) getParent().getLayout();
                                    cl.show(getParent(), "Menu");
                                }
                            });
                        }            

}


