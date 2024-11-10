package com.sistema.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.sistema.Classes.*;

public class ServiceDAO {
    private Connection conn;

    ServiceDAO(Connection connection){
        this.conn = connection;
    }

    public void inserirBanco(Funcionário funcionário){
        String sql = "INSERT INTO funcionario (funcionario_nome, funcionario_datanasc, funcionario_genero, funcionario_rua, funcionario_numeroCasa, funcionario_bairro, funcionario_estado, funcionario_cep, funcionario_telefone, funcionario_email, funcionario_CPF," +
"funcionario_cargo, funcionario_departamento, funcionario_datadeadmissao, funcionario_salario, funcionario_tipocontrato, funcionario_cargahoraria, funcionario_supervisor, funcionario_escolaridade, funcionario_instituicao, funcionario_curso, funcionario_anodeconclusao)" 
+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, funcionário.getNomeCompleto());
            preparedStatement.setString(2, funcionário.getDataDeNascimento());
            preparedStatement.setString(3, funcionário.getGenero());
            preparedStatement.setString(4, funcionário.getRua());
            preparedStatement.setString(5, funcionário.getNumeroCasa());
            preparedStatement.setString(6, funcionário.getBairro());
            preparedStatement.setString(7, funcionário.getEstado());
            preparedStatement.setString(8, funcionário.getCEP());
            preparedStatement.setString(9, funcionário.getTelefone());
            preparedStatement.setString(10, funcionário.getEmail());
            preparedStatement.setString(11, funcionário.getNumerodeidentificacaoCPF());
            preparedStatement.setString(12, funcionário.getCargo());
            preparedStatement.setString(13, funcionário.getDepartamento());
            preparedStatement.setString(14, funcionário.getDatadeAdmissão());
            preparedStatement.setString(15, funcionário.getSalário());
            preparedStatement.setString(16, funcionário.getTipodecontrato());
            preparedStatement.setString(17, funcionário.getCargaHorária());
            preparedStatement.setString(18, funcionário.getSupervisorResponsável());
            preparedStatement.setString(19, funcionário.getNíveldeescolaridade());
            preparedStatement.setString(20, funcionário.getInstituiçãodeEnsino());
            preparedStatement.setString(21, funcionário.getCurso());
            preparedStatement.setString(22, funcionário.getAnodeConclusão());
            preparedStatement.execute();
            
        }
         catch (SQLException e){
            throw new RuntimeException(e);
        }
}

    public void inserirBancoDeHoras(EntradaHoras entradaHoras){
        String sql = "INSERT INTO bancoHoras (nome, data, horaEntrada, horaSaida)"
+ "VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, entradaHoras.getNome());
            preparedStatement.setString(2, entradaHoras.getData());
            preparedStatement.setString(3, entradaHoras.getHoraEntrada());
            preparedStatement.setString(4, entradaHoras.getHoraSaida());
            preparedStatement.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void inserirCadastroFerias(EntradaFerias entradaferias){
        String sql = "INSERT INTO ferias (funcionario_nome, data_inicio, data_fim, observacoes)"
+ "VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, entradaferias.nome());
            preparedStatement.setString(2, entradaferias.datainicio());
            preparedStatement.setString(3, entradaferias.datafim());
            preparedStatement.setString(4, entradaferias.observações());
            preparedStatement.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void excluirCadastro(String nome, String cpf, String cpf2){
       String deleteBancohoras = "DELETE FROM bancohoras WHERE cpf = ?";
       String deleteFuncionario = "DELETE FROM funcionario WHERE funcionario_nome = ?";
        String deleteFerias = "DELETE FROM ferias WHERE funcionario_cpf = ?";

try (PreparedStatement pstmtBancohoras = conn.prepareStatement(deleteBancohoras);
     PreparedStatement pstmtFuncionario = conn.prepareStatement(deleteFuncionario);
     PreparedStatement pstmtFerias = conn.prepareStatement(deleteFerias);) {

    conn.setAutoCommit(false); // Inicia uma transação

    // Excluir as entradas na tabela bancohoras
    pstmtBancohoras.setString(1, cpf); // Substitua com o CPF do funcionário
    pstmtBancohoras.execute();

    //excluir as entradas na tabela ferias
    pstmtFerias.setString(1, cpf2);
    pstmtFerias.execute();
    
    // Excluir o funcionário
    pstmtFuncionario.setString(1, nome);
    pstmtFuncionario.execute();

    conn.commit(); // Confirma a transação

    System.out.println("Funcionário e registros associados excluídos com sucesso.");

} catch (SQLException e) {
        throw new RuntimeException(e);
    }

}

    public void excluirCadastroFerias(String nome){
        String deleteferias = "DELETE FROM ferias WHERE funcionario_nome = ?";

    try (PreparedStatement pstmtFerias= conn.prepareStatement(deleteferias);) {

    conn.setAutoCommit(false); // Inicia uma transação

    // Excluir as entradas na tabela bancohoras
    pstmtFerias.setString(1, nome); // Substitua com o CPF do funcionário
    pstmtFerias.execute();
    conn.commit(); // Confirma a transação

    System.out.println("Registro de Férias excluido com sucesso!");

} catch (SQLException e) {
        throw new RuntimeException(e);
    }

}}
    



















