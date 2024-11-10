package com.sistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao(){
        try{
            return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Func_bank?user=Bruno&password=32391234Bruno!");
    } catch(SQLException e){
        throw new RuntimeException(e);
    }
    }
}
