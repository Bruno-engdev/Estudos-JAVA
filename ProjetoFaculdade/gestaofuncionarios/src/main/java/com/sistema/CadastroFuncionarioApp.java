package com.sistema;

import javax.swing.*;
import com.sistema.paineis.*;


import java.awt.*;

public class CadastroFuncionarioApp {
    public static void main(String[] args) {
        // Criando o JFrame para a aplicação
        JFrame frame = new JFrame("Cadastro de Funcionário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Criando o painel que vai usar CardLayout
        JPanel container = new JPanel();
        container.setLayout(new CardLayout());

        // Criando os painéis (LoginPanel, CadastroPanel, etc)
        container.add(new TabelaHorasExtrasPanel(),"TabelaHorasExtras");
        container.add(new TabelaFeriasPanel(), "TabelaFerias");
        container.add(new TabelaFuncionariosPanel(), "TabelaFuncionarios");
        container.add(new LoginPanel(), "Login");
        container.add(new CadastroPanel(), "Cadastro");
        container.add(new MenuPanel(), "Menu");
        container.add(new GerenciamentoFeriasPanel(), "Gerenciamento Férias");
        container.add(new BancoDeHorasPanel(), "Gerenciamento Horas Extras");
        container.add(new DetalhesFuncionarioPanel(), "DetalhesFuncionarioPanel");
        // Configurando o CardLayout para mostrar o painel de Login inicialmente
        CardLayout cl = (CardLayout) container.getLayout();
        cl.show(container, "Login"); // Exibe o painel de Login inicialmente

        // Adicionando o container com os painéis ao frame
        frame.add(container);

        // Ajusta o tamanho do frame automaticamente com base no conteúdo
        frame.pack();

        // Configura o tamanho mínimo da janela, se necessário
        frame.setMinimumSize(new Dimension(400, 400));  // Define um tamanho mínimo para o frame

        // Torna o frame visível
        frame.setVisible(true);

        
    }
}
