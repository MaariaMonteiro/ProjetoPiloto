/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

/**
 *
 * @author FATEC ZONA LESTE
 */
//lucichart
//draw.io
import Conexao.Conexao;
import javax.swing.JOptionPane;
import java.sql.*;//para usar comandos do sql em java
public class Conexao {
    final private String driver = "com.mysql.jdbc.Driver"; //define o driver MySql para acessar os dados
    final private String url = "jdbc:mysql://localhost/clientes";//acesso ao banco bd clienetes no servidor
    final private String usuario = "root"; //usuario do MYsql (uswebserver)
    final private String senha = ""; //senha (uswebserver)
    private Connection conexao; //variavel que vai armazenar a conexão aberta
    public Statement statement; //variavel usada para executar os comandos sql
    public ResultSet resultset; //vai armazenar o resultado da execucao de um comando sql
    
    public boolean conecta(){
        boolean result = true;
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            JOptionPane.showMessageDialog(null, "Conexão estabelecida!", "Mensagem do Progama", JOptionPane.INFORMATION_MESSAGE);
             }
        catch (ClassNotFoundException Driver){
        JOptionPane.showMessageDialog(null, "Driver não localizado"+Driver, "Mensagem do progama",JOptionPane.INFORMATION_MESSAGE);
        result = false;
                    }
        catch (SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizada"+Fonte, "Mensagem do progama",JOptionPane.INFORMATION_MESSAGE);
            result = false;
         }
        return result;
    }
        public void desconecta(){
            try{
                conexao.close();
                JOptionPane.showMessageDialog(null, "Conexão com o banco fechada", "Mensagem do progama", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch(SQLException fecha){
                
            }
        }
        public void executaSQL(String sql){
            try {
                statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
            }
            catch(SQLException excecao){
                JOptionPane.showMessageDialog(null, "Erro no comando Sql! \n Erro: "+excecao);
            }
        }
    }

