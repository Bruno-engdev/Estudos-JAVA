package com.sistema.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import com.sistema.Classes.*;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.sistema.ConnectionFactory;


public class Service {
     private ConnectionFactory connection;// Objeto connection com o parametro recuperar conexao

     public Service(){
        this.connection = new ConnectionFactory();
    }
     public void cadastrar(Funcionário funcionario) { 
        Connection conn = connection.recuperarConexao();//estabelece a conexão
        new ServiceDAO(conn).inserirBanco(funcionario);//salva as informações
        //nao da pra usar connection como parametro pois é do tipo ConectionFactory e não conection
    }

    public void cadastrarBancoDeHoras(EntradaHoras entradaHoras){
        Connection conn = connection.recuperarConexao();//estabelece a conexão
        new ServiceDAO(conn).inserirBancoDeHoras(entradaHoras);//salva as informações
    }

    public void cadastrarFerias(EntradaFerias entradaFerias){
        Connection conn = connection.recuperarConexao();//estabelece a conexão
        new ServiceDAO(conn).inserirCadastroFerias(entradaFerias);//salva as informações
    }

    public void deletarCadastro(String nome, String cpf, String cpf2){
        Connection conn = connection.recuperarConexao();//estabelece a conexão
        new ServiceDAO(conn).excluirCadastro(nome, cpf, cpf2);//deleta as informações
    }

    public void deletarFerias(String nome){
        Connection conn = connection.recuperarConexao();//estabelece a conexão
        new ServiceDAO(conn).excluirCadastroFerias(nome);//deleta as informações
    }


    public Funcionário buscarFuncionarioPorNome(String nome){
        Connection conn = connection.recuperarConexao();//estabelece a conexão
        var funcionario = new Funcionário();
        String query = "SELECT * FROM funcionario WHERE funcionario_nome = ?";//'nome_completo'

        try (PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Preenche os dados do funcionário com o resultado da consulta
                funcionario.setNomeCompleto(rs.getString("funcionario_nome"));
                funcionario.setDataDeNascimento(rs.getString("funcionario_datanasc"));
                funcionario.setGenero(rs.getString("funcionario_genero"));
                funcionario.setRua(rs.getString("funcionario_rua"));
                funcionario.setNumeroCasa(rs.getString("funcionario_numeroCasa"));
                funcionario.setBairro(rs.getString("funcionario_bairro"));
                funcionario.setEstado(rs.getString("funcionario_estado"));
                funcionario.setCEP(rs.getString("funcionario_cep"));
                funcionario.setTelefone(rs.getString("funcionario_telefone"));
                funcionario.setEmail(rs.getString("funcionario_email"));
                funcionario.setNumerodeidentificacaoCPF(rs.getString("funcionario_CPF"));
                funcionario.setCargo(rs.getString("funcionario_cargo"));
                funcionario.setDepartamento(rs.getString("funcionario_departamento"));
                funcionario.setDatadeAdmissão(rs.getString("funcionario_datadeadmissao"));
                funcionario.setSalário(rs.getString("funcionario_salario"));
                funcionario.setTipodecontrato(rs.getString("funcionario_tipocontrato"));
                funcionario.setCargaHorária(rs.getString("funcionario_cargahoraria"));
                funcionario.setSupervisorResponsável(rs.getString("funcionario_supervisor"));
                funcionario.setNíveldeescolaridade(rs.getString("funcionario_escolaridade"));
                funcionario.setInstituiçãodeEnsino(rs.getString("funcionario_instituicao"));
                funcionario.setCurso(rs.getString("funcionario_curso"));
                funcionario.setAnodeConclusão(rs.getString("funcionario_anodeconclusao"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    
}

 
    public JTable getFuncionariosTableFromDatabase() {
        // Query SQL para buscar os dados
        String query = "SELECT funcionario_nome, funcionario_CPF, funcionario_cargo, funcionario_departamento FROM funcionario";
        
        // Criando um modelo de tabela padrão com colunas e dados
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Cargo");
        tableModel.addColumn("Departamento");

        // Conexão com o banco de dados e execução da consulta
        try (Connection conn = connection.recuperarConexao();//estabelece a conexão
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {
            
                while (resultSet.next()) {
                    String nome = resultSet.getString("funcionario_nome");
                    String cpf = resultSet.getString("funcionario_CPF");
                    String cargo = resultSet.getString("funcionario_cargo");
                    String departamento = resultSet.getString("funcionario_departamento");
                
                    // Imprime para depuração
                    System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Cargo: " + cargo + ", Departamento: " + departamento);
                    
                    tableModel.addRow(new Object[]{nome, cpf.toString(), cargo, departamento});
                }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Criando a JTable com o modelo
        JTable table = new JTable(tableModel);
        // Ajustando a largura das colunas
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        return table;
    }
    public JTable getFeriasTableFromDatabase() {
        // Query SQL para buscar os dados da tabela ferias
        String query = "SELECT funcionario_nome, data_inicio, data_fim, observacoes FROM ferias";
        
        // Criando um modelo de tabela padrão com colunas e dados
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Data Início");
        tableModel.addColumn("Data Fim");
        tableModel.addColumn("Observações");
    
        // Conexão com o banco de dados e execução da consulta
        try (Connection conn = connection.recuperarConexao();  // Estabelece a conexão
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {
            
            while (resultSet.next()) {
                String nome = resultSet.getString("funcionario_nome");
                String dataInicio = resultSet.getString("data_inicio");  // Pode ser do tipo Date ou String
                String dataFim = resultSet.getString("data_fim");        // Pode ser do tipo Date ou String
                String observacoes = resultSet.getString("observacoes");
                
                // Imprime para depuração
                System.out.println("Nome: " + nome + ", Data Início: " + dataInicio + ", Data Fim: " + dataFim + ", Observações: " + observacoes);
                
                // Adiciona a linha à tabela
                tableModel.addRow(new Object[]{nome, dataInicio, dataFim, observacoes});
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        // Criando a JTable com o modelo
        JTable table = new JTable(tableModel);
        // Ajustando a largura das colunas
        table.getColumnModel().getColumn(0).setPreferredWidth(200);  // Nome
        table.getColumnModel().getColumn(1).setPreferredWidth(150);  // Data Início
        table.getColumnModel().getColumn(2).setPreferredWidth(150);  // Data Fim
        table.getColumnModel().getColumn(3).setPreferredWidth(200);  // Observações
        
        return table;
    }
    public JTable getHorasExtrasTableFromDatabase() {
    // Query SQL para buscar os dados da tabela de horas extras
    String query = "SELECT nome, data, horaEntrada, horaSaida FROM bancoHoras";
    
    // Criando um modelo de tabela padrão com colunas e dados
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Nome");
    tableModel.addColumn("Data");
    tableModel.addColumn("Hora Entrada");
    tableModel.addColumn("Hora Saída");
    tableModel.addColumn("Hora Extra");
    
    // Conexão com o banco de dados e execução da consulta
    try (Connection conn = connection.recuperarConexao();  // Estabelece a conexão
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet resultSet = ps.executeQuery()) {
        
        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String data = resultSet.getString("data");  // Data pode ser do tipo Date ou String
            String horaEntrada = resultSet.getString("horaEntrada"); // Horas no formato "HH:mm"
            String horaSaida = resultSet.getString("horaSaida");   // Horas no formato "HH:mm"

            // Convertendo as horas de entrada e saída para LocalTime
            LocalTime entrada = LocalTime.parse(horaEntrada);
            LocalTime saida = LocalTime.parse(horaSaida);
            
            // Calculando a diferença entre a hora de saída e a hora de entrada
            Duration duracao = Duration.between(entrada, saida);
            long horasTrabalhadas = duracao.toHours();  // Resultado em horas
            
            // Calculando as horas extras: se trabalhou mais de 9 horas, as horas extras são a diferença
            long horasExtras = Math.max(horasTrabalhadas - 9, 0); // Se trabalhou menos de 9 horas, não há horas extras
            
            // Imprime para depuração
            System.out.println("Nome: " + nome + ", Data: " + data + ", Horas Extras: " + horasExtras);
            
            // Adiciona a linha à tabela com o valor de horas extras
            tableModel.addRow(new Object[]{nome, data, horaEntrada, horaSaida, horasExtras});
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    // Criando a JTable com o modelo
    JTable table = new JTable(tableModel);
    // Ajustando a largura das colunas
    table.getColumnModel().getColumn(0).setPreferredWidth(200);  // Nome
    table.getColumnModel().getColumn(1).setPreferredWidth(150);  // Data
    table.getColumnModel().getColumn(2).setPreferredWidth(150);  // Hora Entrada
    table.getColumnModel().getColumn(3).setPreferredWidth(150);  // Hora Saída
    table.getColumnModel().getColumn(4).setPreferredWidth(100);  // Hora Extra
    
    return table;
}


    public JComboBox<String> getFuncionariosFerias(){
        String query = "SELECT funcionario_nome FROM funcionario";
        JComboBox<String> funcionarioComboBox = new JComboBox<>();

        try (Connection conn = connection.recuperarConexao();//estabelece a conexão
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()){
                    String nome = resultSet.getString(1);
                    funcionarioComboBox.addItem(nome);
                }
             }
             catch (SQLException e) {
                e.printStackTrace();
            }

            return funcionarioComboBox;
    }

    public JComboBox<String> getOpcoes(){
        JComboBox<String> opcoesComboBox = new JComboBox<>();
        opcoesComboBox.addItem("Vizualizar");

        return opcoesComboBox;
    }
}


