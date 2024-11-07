package ProjetoFaculdade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel {  // Substituído Panel por JPanel do Swing

    public MenuPanel() {
        // Layout principal do painel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Definindo o espaçamento entre os componentes
        gbc.insets = new Insets(20, 20, 20, 20); // Maior espaçamento entre os botões
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;  // Faz com que os botões ocupem duas colunas

        // Botão de Acesso ao Menu de Cadastro
        JButton menucadastrarButton = new JButton("Acessar menu de cadastro");
        menucadastrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        menucadastrarButton.setBackground(new Color(0, 51, 102));
        menucadastrarButton.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0;
        add(menucadastrarButton, gbc);
        menucadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar o código para mudar de painel
                System.out.println("Acessando menu de cadastro...");
            }
        });

        // Botão de Acesso ao Gerenciamento de Férias
        JButton gerenciamentoFerias = new JButton("Acessar Gerenciamento De Férias");
        gerenciamentoFerias.setFont(new Font("Arial", Font.BOLD, 14));
        gerenciamentoFerias.setBackground(new Color(0, 51, 102));
        gerenciamentoFerias.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        add(gerenciamentoFerias, gbc);
        gerenciamentoFerias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar o código para mudar de painel
                System.out.println("Acessando gerenciamento de férias...");
            }
        });

        // Botão de Acesso ao Gerenciamento de Horas Extras
        JButton acessoHorasExtras = new JButton("Acessar Gerenciamento Horas Extras");
        acessoHorasExtras.setFont(new Font("Arial", Font.BOLD, 14));
        acessoHorasExtras.setBackground(new Color(0, 51, 102));
        acessoHorasExtras.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 2;
        add(acessoHorasExtras, gbc);
        acessoHorasExtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode adicionar o código para mudar de painel
                System.out.println("Acessando gerenciamento de horas extras...");
            }
        });
    }

    // Função main para visualizar o painel
    public static void main(String[] args) {
        // Criando o Frame principal
        JFrame frame = new JFrame("Menu de Acesso");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando o painel de menu ao frame
        frame.add(new MenuPanel());

        // Tornar a janela visível
        frame.setLocationRelativeTo(null);  // Centraliza a janela
        frame.setVisible(true);
    }
}
