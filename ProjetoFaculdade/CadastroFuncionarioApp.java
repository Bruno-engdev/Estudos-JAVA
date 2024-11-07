package ProjetoFaculdade;

import java.awt.*;
import java.awt.event.*;

public class CadastroFuncionarioApp {
    public static void main(String[] args) {
        Frame frame = new Frame("Cadastro de Funcionário");
        frame.setSize(1200, 600);
        frame.setLayout(new CardLayout());

        // Adicionando os painéis ao CardLayout
        frame.add(new LoginPanel(frame), "Login");
        frame.add(new CadastroPanel(), "Cadastro");
        frame.add(new MenuPanel(), "Menu");
        frame.add(new GerenciamentoFeriasPanel(), "Gerenciamento Férias");
        frame.add(new BancoDeHorasPanel(), "Gerenciamento Horas Extras");

        // Exibir a tela de login inicialmente
        CardLayout cl = (CardLayout) (frame.getLayout());
        cl.show(frame, "Login");

        // Configurações do frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}