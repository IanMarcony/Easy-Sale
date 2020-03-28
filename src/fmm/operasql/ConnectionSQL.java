package fmm.operasql;
import java.sql.*;
import javax.swing.JOptionPane;


public class ConnectionSQL {
    private static final String DRIVER = "com.mysql.jdbc.Driver";// Padrão
    private static final String URL ="jdbc:mysql://localhost:3306/venda_facil_db";// Onde está localizado 
    private static final String USER= "root";
    private static final String PASS= "";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{//Iniciar a conexão
        //System.out.println("na conexão");
        try{
            Class.forName(DRIVER);
            //System.out.println("feita a conexão");
            return DriverManager.getConnection(URL, USER, PASS);
   
        }
        catch(RuntimeException | ClassNotFoundException | SQLException ex){
            Class.forName(DRIVER);
            //System.out.println("feita a conexão 2");
            return DriverManager.getConnection(URL, USER, "1234");
            //JOptionPane.showMessageDialog(null,"ERRO NA CONEXÃO" );
            //throw new RuntimeException("ERRO: ",ex);
        }    
    }
    
    public static void closeConnection(Connection con){//Fecha a conexão do banco de dados
       try{
           if(con!=null){
               con.close();
           }
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "ERRO NA DESCONEXÃO");
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){//Fecha a conexão do banco de dados
       closeConnection(con);
        try{
           if(stmt!=null){
              stmt.close();
           }
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "ERRO NA DESCONEXÃO");
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){//Fecha a conexão do banco de dados
       closeConnection(con,stmt);
        try{
           if(rs!=null){
              rs.close();
           }
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, "ERRO NA DESCONEXÃO");
       }
    }
}
