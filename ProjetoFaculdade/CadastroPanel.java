package ProjetoFaculdade;

import java.awt.*;
import java.awt.event.*;

public class CadastroPanel extends Panel {
    public CadastroPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Exemplo de validação simples de CPF utilizando Regex

        
// Campos do formulário
TextField nomeCompletoField = new TextField(20);
TextField dataDeNascimentoField = new TextField(10);
TextField generoField = new TextField(10);
TextField ruaField = new TextField(20);
TextField numeroCasaField = new TextField(5);
TextField bairroField = new TextField(15);
TextField estadoField = new TextField(10);
TextField cepField = new TextField(10);
TextField telefoneField = new TextField(10);
TextField emailField = new TextField(20);
TextField cpfField = new TextField(15);
TextField cargoField = new TextField(15);
TextField departamentoField = new TextField(15);
TextField dataAdmissaoField = new TextField(10);
TextField salarioField = new TextField(10);
TextField tipoContratoField = new TextField(10);
TextField cargaHorariaField = new TextField(10);
TextField supervisorField = new TextField(15);
TextField nivelEscolaridadeField = new TextField(15);
TextField instituicaoField = new TextField(20);
TextField cursoField = new TextField(15);
TextField anoConclusaoField = new TextField(5);

// Adicionando labels e campos ao painel
// Cabeçalho cadastro DADOS PESSOAIS
gbc.gridx = 0; gbc.gridy = 0; add(new Label("DADOS PESSOAIS: "), gbc);
gbc.gridx = 0; gbc.gridy = 1; add(new Label("Nome Completo:"), gbc);
gbc.gridx = 1; add(nomeCompletoField, gbc);
gbc.gridx = 2; add(new Label("Data de Nascimento:"), gbc);
gbc.gridx = 3; add(dataDeNascimentoField, gbc);
gbc.gridx = 4; add(new Label("Gênero:"), gbc);
gbc.gridx = 5; add(generoField, gbc);
gbc.gridx = 0; gbc.gridy = 2; add(new Label("CPF:"), gbc);
gbc.gridx = 1; add(cpfField, gbc);
gbc.gridx = 2; add(new Label("Telefone:"), gbc);
gbc.gridx = 3; add(telefoneField, gbc);
gbc.gridx = 4; add(new Label("E-mail:"), gbc);
gbc.gridx = 5; add(emailField, gbc);

// Cabeçalho cadastro DADOS RESIDENCIA
gbc.gridx = 0; gbc.gridy = 3; add(new Label("ENDEREÇO DE RESIDÊNCIA: "), gbc);
gbc.gridx = 0; gbc.gridy = 4; add(new Label("Rua:"), gbc);
gbc.gridx = 1; add(ruaField, gbc);
gbc.gridx = 2; add(new Label("Número da Casa:"), gbc);
gbc.gridx = 3; add(numeroCasaField, gbc);
gbc.gridx = 0; gbc.gridy = 5; add(new Label("Bairro:"), gbc);
gbc.gridx = 1; add(bairroField, gbc);
gbc.gridx = 2; add(new Label("Estado:"), gbc);
gbc.gridx = 3; add(estadoField, gbc);
gbc.gridx = 4; add(new Label("CEP:"), gbc);
gbc.gridx = 5; add(cepField, gbc);

// Cabeçalho cadastro DADOS CONTRATUAIS
gbc.gridx = 0; gbc.gridy = 7; add(new Label("DADOS CONTRATUAIS: "), gbc);
gbc.gridx = 0; gbc.gridy = 8; add(new Label("Cargo:"), gbc);
gbc.gridx = 1; add(cargoField, gbc);
gbc.gridx = 2; add(new Label("Departamento:"), gbc);
gbc.gridx = 3; add(departamentoField, gbc);
gbc.gridx = 4; add(new Label("Data de Admissão:"), gbc);
gbc.gridx = 5; add(dataAdmissaoField, gbc);
gbc.gridx = 0; gbc.gridy = 9; add(new Label("Salário:"), gbc);
gbc.gridx = 1; add(salarioField, gbc);
gbc.gridx = 2; add(new Label("Tipo de Contrato:"), gbc);
gbc.gridx = 3; add(tipoContratoField, gbc);
gbc.gridx = 4; add(new Label("Carga Horária:"), gbc);
gbc.gridx = 5; add(cargaHorariaField, gbc);
gbc.gridx = 0; gbc.gridy = 10; add(new Label("Supervisor Responsável:"), gbc);
gbc.gridx = 1; add(supervisorField, gbc);

// Cabeçalho cadastro DADOS EDUCACIONAIS
gbc.gridx = 0; gbc.gridy = 14; add(new Label("DADOS EDUCACIONAIS: "), gbc);
gbc.gridx = 0; gbc.gridy = 15; add(new Label("Nível de Escolaridade:"), gbc);
gbc.gridx = 1; add(nivelEscolaridadeField, gbc);
gbc.gridx = 2; add(new Label("Instituição de Ensino:"), gbc);
gbc.gridx = 3; add(instituicaoField, gbc);
gbc.gridx = 0; gbc.gridy = 16; add(new Label("Curso:"), gbc);
gbc.gridx = 1; add(cursoField, gbc);
gbc.gridx = 2; add(new Label("Ano de Conclusão:"), gbc);
gbc.gridx = 3; add(anoConclusaoField, gbc);

// Botão de Cadastro
Button cadastrarButton = new Button("Cadastrar");
gbc.gridx = 6; gbc.gridy = 22; gbc.gridwidth = 2; add(cadastrarButton, gbc);

cadastrarButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Aqui você pode implementar a lógica de cadastro
        System.out.println("Cadastro realizado com sucesso!");
    }
});
// Botão de Login
Button voltarMenu = new Button("Menu");
gbc.gridx = 0; gbc.gridy = 22; gbc.gridwidth = 2; add(voltarMenu, gbc);

voltarMenu.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) getParent().getLayout();
        cl.show(getParent(), "Menu");
    }
});
}}