package com.sistema.paineis;

import com.sistema.Services.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.sistema.Classes.Funcionário;

public class CadastroPanel extends JPanel {

    public CadastroPanel() {
        Service service = new Service();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Mantendo o espaçamento original

        // Estilo dos campos de texto
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Color fieldBackgroundColor = new Color(245, 245, 245);
        Color fieldBorderColor = new Color(200, 200, 200);

        // Estilo do título
        Font titleFont = new Font("Segoe UI", Font.BOLD, 16);
        Color titleColor = new Color(33, 33, 33);

        // Estilo dos botões
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        Color buttonColor = new Color(0, 123, 255); // Cor azul
        Color buttonHoverColor = new Color(28, 115, 255);
        Color buttonTextColor = Color.WHITE;

        // Campos do formulário
        JTextField nomeCompletoField = new JTextField(15);
        nomeCompletoField.setFont(fieldFont);
        nomeCompletoField.setBackground(fieldBackgroundColor);
        nomeCompletoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField dataDeNascimentoField = new JTextField(10);
        dataDeNascimentoField.setFont(fieldFont);
        dataDeNascimentoField.setBackground(fieldBackgroundColor);
        dataDeNascimentoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField generoField = new JTextField(10);
        generoField.setFont(fieldFont);
        generoField.setBackground(fieldBackgroundColor);
        generoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField ruaField = new JTextField(15);
        ruaField.setFont(fieldFont);
        ruaField.setBackground(fieldBackgroundColor);
        ruaField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField numeroCasaField = new JTextField(5);
        numeroCasaField.setFont(fieldFont);
        numeroCasaField.setBackground(fieldBackgroundColor);
        numeroCasaField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField bairroField = new JTextField(15);
        bairroField.setFont(fieldFont);
        bairroField.setBackground(fieldBackgroundColor);
        bairroField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField estadoField = new JTextField(10);
        estadoField.setFont(fieldFont);
        estadoField.setBackground(fieldBackgroundColor);
        estadoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField cepField = new JTextField(10);
        cepField.setFont(fieldFont);
        cepField.setBackground(fieldBackgroundColor);
        cepField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField telefoneField = new JTextField(10);
        telefoneField.setFont(fieldFont);
        telefoneField.setBackground(fieldBackgroundColor);
        telefoneField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField emailField = new JTextField(15);
        emailField.setFont(fieldFont);
        emailField.setBackground(fieldBackgroundColor);
        emailField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField cpfField = new JTextField(10);
        cpfField.setFont(fieldFont);
        cpfField.setBackground(fieldBackgroundColor);
        cpfField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField cargoField = new JTextField(15);
        cargoField.setFont(fieldFont);
        cargoField.setBackground(fieldBackgroundColor);
        cargoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField departamentoField = new JTextField(10);
        departamentoField.setFont(fieldFont);
        departamentoField.setBackground(fieldBackgroundColor);
        departamentoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField dataAdmissaoField = new JTextField(10);
        dataAdmissaoField.setFont(fieldFont);
        dataAdmissaoField.setBackground(fieldBackgroundColor);
        dataAdmissaoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField salarioField = new JTextField(10);
        salarioField.setFont(fieldFont);
        salarioField.setBackground(fieldBackgroundColor);
        salarioField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField tipoContratoField = new JTextField(10);
        tipoContratoField.setFont(fieldFont);
        tipoContratoField.setBackground(fieldBackgroundColor);
        tipoContratoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField cargaHorariaField = new JTextField(10);
        cargaHorariaField.setFont(fieldFont);
        cargaHorariaField.setBackground(fieldBackgroundColor);
        cargaHorariaField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField supervisorField = new JTextField(15);
        supervisorField.setFont(fieldFont);
        supervisorField.setBackground(fieldBackgroundColor);
        supervisorField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField nivelEscolaridadeField = new JTextField(10);
        nivelEscolaridadeField.setFont(fieldFont);
        nivelEscolaridadeField.setBackground(fieldBackgroundColor);
        nivelEscolaridadeField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField instituicaoField = new JTextField(15);
        instituicaoField.setFont(fieldFont);
        instituicaoField.setBackground(fieldBackgroundColor);
        instituicaoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField cursoField = new JTextField(15);
        cursoField.setFont(fieldFont);
        cursoField.setBackground(fieldBackgroundColor);
        cursoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        JTextField anoConclusaoField = new JTextField(10);
        anoConclusaoField.setFont(fieldFont);
        anoConclusaoField.setBackground(fieldBackgroundColor);
        anoConclusaoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));

        // Adicionando labels e campos ao painel
        // Cabeçalho cadastro DADOS PESSOAIS
        JLabel dadosPessoaisLabel = new JLabel("DADOS PESSOAIS: ");
        dadosPessoaisLabel.setFont(titleFont);
        dadosPessoaisLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 0; add(dadosPessoaisLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Nome Completo:"), gbc);
        gbc.gridx = 1; add(nomeCompletoField, gbc);
        gbc.gridx = 2; add(new JLabel("Data de Nascimento:"), gbc);
        gbc.gridx = 3; add(dataDeNascimentoField, gbc);
        gbc.gridx = 4; add(new JLabel("Gênero:"), gbc);
        gbc.gridx = 5; add(generoField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("CPF:"), gbc);
        gbc.gridx = 1; add(cpfField, gbc);
        gbc.gridx = 2; add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 3; add(telefoneField, gbc);
        gbc.gridx = 4; add(new JLabel("E-mail:"), gbc);
        gbc.gridx = 5; add(emailField, gbc);

        // Cabeçalho cadastro DADOS RESIDENCIA
        JLabel enderecoLabel = new JLabel("ENDEREÇO DE RESIDÊNCIA: ");
        enderecoLabel.setFont(titleFont);
        enderecoLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 3; add(enderecoLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 4; add(new JLabel("Rua:"), gbc);
        gbc.gridx = 1; add(ruaField, gbc);
        gbc.gridx = 2; add(new JLabel("Número da Casa:"), gbc);
        gbc.gridx = 3; add(numeroCasaField, gbc);
        gbc.gridx = 0; gbc.gridy = 5; add(new JLabel("Bairro:"), gbc);
        gbc.gridx = 1; add(bairroField, gbc);
        gbc.gridx = 2; add(new JLabel("Estado:"), gbc);
        gbc.gridx = 3; add(estadoField, gbc);
        gbc.gridx = 4; add(new JLabel("CEP:"), gbc);
        gbc.gridx = 5; add(cepField, gbc);

        // Cabeçalho cadastro DADOS CONTRATUAIS
        JLabel dadosContratuaisLabel = new JLabel("DADOS CONTRATUAIS: ");
        dadosContratuaisLabel.setFont(titleFont);
        dadosContratuaisLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 7; add(dadosContratuaisLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 8; add(new JLabel("Cargo:"), gbc);
        gbc.gridx = 1; add(cargoField, gbc);
        gbc.gridx = 2; add(new JLabel("Departamento:"), gbc);
        gbc.gridx = 3; add(departamentoField, gbc);
        gbc.gridx = 4; add(new JLabel("Data de Admissão:"), gbc);
        gbc.gridx = 5; add(dataAdmissaoField, gbc);
        gbc.gridx = 0; gbc.gridy = 9; add(new JLabel("Salário:"), gbc);
        gbc.gridx = 1; add(salarioField, gbc);
        gbc.gridx = 2; add(new JLabel("Tipo de Contrato:"), gbc);
        gbc.gridx = 3; add(tipoContratoField, gbc);
        gbc.gridx = 4; add(new JLabel("Carga Horária:"), gbc);
        gbc.gridx = 5; add(cargaHorariaField, gbc);
        gbc.gridx = 0; gbc.gridy = 10; add(new JLabel("Supervisor Responsável:"), gbc);
        gbc.gridx = 1; add(supervisorField, gbc);

        // Cabeçalho cadastro DADOS EDUCACIONAIS
        JLabel dadosEducacionaisLabel = new JLabel("DADOS EDUCACIONAIS: ");
        dadosEducacionaisLabel.setFont(titleFont);
        dadosEducacionaisLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 14; add(dadosEducacionaisLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 15; add(new JLabel("Nível de Escolaridade:"), gbc);
        gbc.gridx = 1; add(nivelEscolaridadeField, gbc);
        gbc.gridx = 2; add(new JLabel("Instituição de Ensino:"), gbc);
        gbc.gridx = 3; add(instituicaoField, gbc);
        gbc.gridx = 0; gbc.gridy = 16; add(new JLabel("Curso:"), gbc);
        gbc.gridx = 1; add(cursoField, gbc);
        gbc.gridx = 2; gbc.gridy = 17; add(new JLabel("Ano de Conclusão:"), gbc);
        gbc.gridx = 3; add(anoConclusaoField, gbc);

        // Botão de Excluir
        JButton excluirButton = new JButton("Excluir");
        excluirButton.setFont(buttonFont);
        excluirButton.setBackground(buttonColor);
        excluirButton.setForeground(buttonTextColor);
        excluirButton.setBorderPainted(false);
        excluirButton.setFocusPainted(false);
        excluirButton.setPreferredSize(new Dimension(150, 40));
        excluirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  
          
        // Hover effect
        excluirButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
        excluirButton.setBackground(buttonHoverColor);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
        excluirButton.setBackground(buttonColor);
        }});

        // Botão de Cadastro
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(buttonFont);
        cadastrarButton.setBackground(buttonColor);
        cadastrarButton.setForeground(buttonTextColor);
        cadastrarButton.setBorderPainted(false);
        cadastrarButton.setFocusPainted(false);
        cadastrarButton.setPreferredSize(new Dimension(150, 40));
        cadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover effect
        cadastrarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastrarButton.setBackground(buttonHoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadastrarButton.setBackground(buttonColor);
            }
        });

        gbc.gridx = 6; gbc.gridy = 22; gbc.gridwidth = 2; add(cadastrarButton, gbc);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Funcionário funcionario = new Funcionário();
                funcionario.setNomeCompleto(nomeCompletoField.getText());
                funcionario.setDataDeNascimento(dataDeNascimentoField.getText());
                funcionario.setGenero(generoField.getText());
                funcionario.setRua(ruaField.getText());
                funcionario.setNumeroCasa(numeroCasaField.getText());
                funcionario.setBairro(bairroField.getText());
                funcionario.setEstado(estadoField.getText());
                funcionario.setCEP(cepField.getText());
                funcionario.setTelefone(telefoneField.getText());
                funcionario.setEmail(emailField.getText());
                funcionario.setNumerodeidentificacaoCPF(cpfField.getText());
                funcionario.setCargo(cargoField.getText());
                funcionario.setDepartamento(departamentoField.getText());
                funcionario.setDataDeNascimento(dataDeNascimentoField.getText());
                funcionario.setSalário(salarioField.getText());
                funcionario.setTipodecontrato(tipoContratoField.getText());
                funcionario.setCargaHorária(cargaHorariaField.getText());
                funcionario.setSupervisorResponsável(supervisorField.getText());
                funcionario.setNíveldeescolaridade(nivelEscolaridadeField.getText());
                funcionario.setInstituiçãodeEnsino(instituicaoField.getText());
                funcionario.setCurso(cursoField.getText());
                funcionario.setAnodeConclusão(anoConclusaoField.getText());

                service.cadastrar(funcionario);

                // exibir mensagem que o cadastro foi realizado com sucesso
                JOptionPane.showMessageDialog(CadastroPanel.this, "Cadastro realizado com sucesso!");
                                    
                // Aqui você pode implementar a lógica de cadastro
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "Cadastro");
            }
        });

        //Botão de Excluir
        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "TabelaExcluirFuncionario");
            }
        });
        // Botão de Voltar
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setFont(buttonFont);
        voltarButton.setBackground(buttonColor); // Cor do botão de voltar
        voltarButton.setForeground(buttonTextColor);
        voltarButton.setBorderPainted(false);
        voltarButton.setFocusPainted(false);
        voltarButton.setPreferredSize(new Dimension(150, 40));
        voltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        voltarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltarButton.setBackground(buttonHoverColor); // Cor mais escura no hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltarButton.setBackground(buttonColor); // Cor original
            }
        });

        gbc.gridx = 0; gbc.gridy = 22; gbc.gridwidth = 2; add(voltarButton, gbc);
        // Adicionando o botão ao layout
        gbc.gridx = 12; gbc.gridy = 22; gbc.gridwidth = 2; add(excluirButton, gbc);

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "TabelaFuncionarios");
            }
        });
    }
}
