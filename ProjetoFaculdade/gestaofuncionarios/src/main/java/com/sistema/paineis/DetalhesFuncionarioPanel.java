package com.sistema.paineis;

import com.sistema.Classes.Funcionário;
import com.sistema.Services.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetalhesFuncionarioPanel extends JPanel {

    public DetalhesFuncionarioPanel(Funcionário funcionario) {
        Service service = new Service();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento original

        // Estilos
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);
        Color fieldBackgroundColor = new Color(245, 245, 245);
        Color fieldBorderColor = new Color(200, 200, 200);

        Font titleFont = new Font("Segoe UI", Font.BOLD, 16);
        Color titleColor = new Color(33, 33, 33);

        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        Color buttonColor = new Color(0, 123, 255); // Cor azul
        Color buttonTextColor = Color.WHITE;
        Color deleteButtonColor = new Color(220, 53, 69); // Cor vermelha para o botão de excluir
        Color deleteButtonTextColor = Color.WHITE;

        // Campos do formulário (desabilitados para visualização)
        JTextField nomeCompletoField = new JTextField(funcionario.getNomeCompleto(), 15);
        nomeCompletoField.setFont(fieldFont);
        nomeCompletoField.setBackground(fieldBackgroundColor);
        nomeCompletoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        nomeCompletoField.setEditable(false);

        JTextField dataDeNascimentoField = new JTextField(funcionario.getDataDeNascimento(), 15);
        dataDeNascimentoField.setFont(fieldFont);
        dataDeNascimentoField.setBackground(fieldBackgroundColor);
        dataDeNascimentoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        dataDeNascimentoField.setEditable(false);

        JTextField generoField = new JTextField(funcionario.getGenero(), 10);
        generoField.setFont(fieldFont);
        generoField.setBackground(fieldBackgroundColor);
        generoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        generoField.setEditable(false);

        JTextField ruaField = new JTextField(funcionario.getRua(), 15);
        ruaField.setFont(fieldFont);
        ruaField.setBackground(fieldBackgroundColor);
        ruaField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        ruaField.setEditable(false);

        JTextField numeroCasaField = new JTextField(funcionario.getNumeroCasa(), 10);
        numeroCasaField.setFont(fieldFont);
        numeroCasaField.setBackground(fieldBackgroundColor);
        numeroCasaField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        numeroCasaField.setEditable(false);

        JTextField bairroField = new JTextField(funcionario.getBairro(), 15);
        bairroField.setFont(fieldFont);
        bairroField.setBackground(fieldBackgroundColor);
        bairroField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        bairroField.setEditable(false);

        JTextField estadoField = new JTextField(funcionario.getEstado(), 10);
        estadoField.setFont(fieldFont);
        estadoField.setBackground(fieldBackgroundColor);
        estadoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        estadoField.setEditable(false);

        JTextField cepField = new JTextField(funcionario.getCEP(), 10);
        cepField.setFont(fieldFont);
        cepField.setBackground(fieldBackgroundColor);
        cepField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        cepField.setEditable(false);

        JTextField telefoneField = new JTextField(funcionario.getTelefone(), 15);
        telefoneField.setFont(fieldFont);
        telefoneField.setBackground(fieldBackgroundColor);
        telefoneField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        telefoneField.setEditable(false);

        JTextField emailField = new JTextField(funcionario.getEmail(), 20);
        emailField.setFont(fieldFont);
        emailField.setBackground(fieldBackgroundColor);
        emailField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        emailField.setEditable(false);

        JTextField cpfField = new JTextField(funcionario.getNumerodeidentificacaoCPF(), 10);
        cpfField.setFont(fieldFont);
        cpfField.setBackground(fieldBackgroundColor);
        cpfField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        cpfField.setEditable(false);

        JTextField cargoField = new JTextField(funcionario.getCargo(), 15);
        cargoField.setFont(fieldFont);
        cargoField.setBackground(fieldBackgroundColor);
        cargoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        cargoField.setEditable(false);

        JTextField departamentoField = new JTextField(funcionario.getDepartamento(), 10);
        departamentoField.setFont(fieldFont);
        departamentoField.setBackground(fieldBackgroundColor);
        departamentoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        departamentoField.setEditable(false);

        JTextField dataAdmissaoField = new JTextField(funcionario.getDatadeAdmissão(), 10);
        dataAdmissaoField.setFont(fieldFont);
        dataAdmissaoField.setBackground(fieldBackgroundColor);
        dataAdmissaoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        dataAdmissaoField.setEditable(false);

        JTextField salarioField = new JTextField(funcionario.getSalário(), 10);
        salarioField.setFont(fieldFont);
        salarioField.setBackground(fieldBackgroundColor);
        salarioField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        salarioField.setEditable(false);

        JTextField tipoContratoField = new JTextField(funcionario.getTipodecontrato(), 10);
        tipoContratoField.setFont(fieldFont);
        tipoContratoField.setBackground(fieldBackgroundColor);
        tipoContratoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        tipoContratoField.setEditable(false);

        JTextField cargaHorariaField = new JTextField(funcionario.getCargaHorária(), 10);
        cargaHorariaField.setFont(fieldFont);
        cargaHorariaField.setBackground(fieldBackgroundColor);
        cargaHorariaField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        cargaHorariaField.setEditable(false);

        JTextField supervisorField = new JTextField(funcionario.getSupervisorResponsável(), 15);
        supervisorField.setFont(fieldFont);
        supervisorField.setBackground(fieldBackgroundColor);
        supervisorField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        supervisorField.setEditable(false);

        JTextField nivelEscolaridadeField = new JTextField(funcionario.getNíveldeescolaridade(), 15);
        nivelEscolaridadeField.setFont(fieldFont);
        nivelEscolaridadeField.setBackground(fieldBackgroundColor);
        nivelEscolaridadeField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        nivelEscolaridadeField.setEditable(false);

        JTextField instituicaoField = new JTextField(funcionario.getInstituiçãodeEnsino(), 15);
        instituicaoField.setFont(fieldFont);
        instituicaoField.setBackground(fieldBackgroundColor);
        instituicaoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        instituicaoField.setEditable(false);

        JTextField cursoField = new JTextField(funcionario.getCurso(), 15);
        cursoField.setFont(fieldFont);
        cursoField.setBackground(fieldBackgroundColor);
        cursoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        cursoField.setEditable(false);

        JTextField anoConclusaoField = new JTextField(funcionario.getAnodeConclusão(), 10);
        anoConclusaoField.setFont(fieldFont);
        anoConclusaoField.setBackground(fieldBackgroundColor);
        anoConclusaoField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
        anoConclusaoField.setEditable(false);

        // Cabeçalhos e labels
        JLabel dadosPessoaisLabel = new JLabel("DADOS PESSOAIS: ");
        dadosPessoaisLabel.setFont(titleFont);
        dadosPessoaisLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 0; add(dadosPessoaisLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Nome Completo:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(nomeCompletoField, gbc);

        gbc.gridx = 2; gbc.gridy = 1; add(new JLabel("Data de Nascimento:"), gbc);
        gbc.gridx = 3; gbc.gridy = 1; add(dataDeNascimentoField, gbc);

        gbc.gridx = 4; gbc.gridy = 1; add(new JLabel("Gênero:"), gbc);
        gbc.gridx = 5; gbc.gridy = 1; add(generoField, gbc);

        // Dados Residenciais
        JLabel enderecoLabel = new JLabel("ENDEREÇO DE RESIDÊNCIA: ");
        enderecoLabel.setFont(titleFont);
        enderecoLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 3; add(enderecoLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(new JLabel("Rua:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(ruaField, gbc);

        gbc.gridx = 2; gbc.gridy = 4; add(new JLabel("Número da Casa:"), gbc);
        gbc.gridx = 3; gbc.gridy = 4; add(numeroCasaField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; add(new JLabel("Bairro:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(bairroField, gbc);

        gbc.gridx = 2; gbc.gridy = 5; add(new JLabel("Estado:"), gbc);
        gbc.gridx = 3; gbc.gridy = 5; add(estadoField, gbc);

        gbc.gridx = 4; gbc.gridy = 5; add(new JLabel("CEP:"), gbc);
        gbc.gridx = 5; gbc.gridy = 5; add(cepField, gbc);

        // Dados Contratuais
        JLabel dadosContratuaisLabel = new JLabel("DADOS CONTRATUAIS: ");
        dadosContratuaisLabel.setFont(titleFont);
        dadosContratuaisLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 7; add(dadosContratuaisLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 8; add(new JLabel("Cargo:"), gbc);
        gbc.gridx = 1; add(cargoField, gbc);

        gbc.gridx = 2; add(new JLabel("Departamento:"), gbc);
        gbc.gridx = 3; add(departamentoField, gbc);

        gbc.gridx = 0; gbc.gridy = 9; add(new JLabel("Data de Admissão:"), gbc);
        gbc.gridx = 1; add(dataAdmissaoField, gbc);

        gbc.gridx = 2; gbc.gridy = 9; add(new JLabel("Salário:"), gbc);
        gbc.gridx = 3; add(salarioField, gbc);

        gbc.gridx = 0; gbc.gridy = 10; add(new JLabel("Tipo de Contrato:"), gbc);
        gbc.gridx = 1; add(tipoContratoField, gbc);

        gbc.gridx = 2; gbc.gridy = 10; add(new JLabel("Carga Horária:"), gbc);
        gbc.gridx = 3; add(cargaHorariaField, gbc);

        gbc.gridx = 0; gbc.gridy = 11; add(new JLabel("Supervisor Responsável:"), gbc);
        gbc.gridx = 1; add(supervisorField, gbc);

        // Dados Educacionais
        JLabel educacionaisLabel = new JLabel("DADOS EDUCACIONAIS: ");
        educacionaisLabel.setFont(titleFont);
        educacionaisLabel.setForeground(titleColor);
        gbc.gridx = 0; gbc.gridy = 13; add(educacionaisLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 14; add(new JLabel("Instituição de Ensino:"), gbc);
        gbc.gridx = 1; add(instituicaoField, gbc);

        gbc.gridx = 2; gbc.gridy = 14; add(new JLabel("Curso:"), gbc);
        gbc.gridx = 3; add(cursoField, gbc);

        gbc.gridx = 4; gbc.gridy = 14; add(new JLabel("Ano de Conclusão:"), gbc);
        gbc.gridx = 5; add(anoConclusaoField, gbc);

        // Botões de ação
        JButton voltarButton = new JButton("Voltar");
        voltarButton.setFont(buttonFont);
        voltarButton.setBackground(buttonColor);
        voltarButton.setForeground(buttonTextColor);
        voltarButton.setBorderPainted(false);
        voltarButton.setFocusPainted(false);
        voltarButton.setPreferredSize(new Dimension(150, 40));
        voltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Ação do botão "Voltar"
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getLayout();
                cl.show(getParent(), "TabelaFuncionarios");
            }
        });

        gbc.gridx = 0; gbc.gridy = 22; gbc.gridwidth = 2; add(voltarButton, gbc);

        // Botão Excluir
        JButton excluirButton = new JButton("Excluir");
        excluirButton.setFont(buttonFont);
        excluirButton.setBackground(deleteButtonColor);
        excluirButton.setForeground(deleteButtonTextColor);
        excluirButton.setBorderPainted(false);
        excluirButton.setFocusPainted(false);
        excluirButton.setPreferredSize(new Dimension(150, 40));
        excluirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Ação do botão "Excluir"
        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir o funcionário?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Excluir o funcionário do banco de dados
                    service.deletarCadastro(funcionario.getNomeCompleto(), funcionario.getNumerodeidentificacaoCPF(), funcionario.getNumerodeidentificacaoCPF());
                    // Navegar de volta para o painel de funcionários
                    CardLayout cl = (CardLayout) getParent().getLayout();
                    cl.show(getParent(), "TabelaFuncionariosPanel");
                }
            }
        });

        gbc.gridx = 2; gbc.gridy = 22; gbc.gridwidth = 2; add(excluirButton, gbc);
    }

    public DetalhesFuncionarioPanel() {
        //TODO Auto-generated constructor stub
    }
}
