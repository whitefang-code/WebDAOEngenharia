/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author whitefang
 */
public class ProdutoDAO {

    //private ResultSet r1;
    private Connection getConnection() throws Exception{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(
        "jdbc:derby://localhost:1527/loja",
        "loja","loja");
    }
    
    private Statement getStatement() throws Exception{
        return getConnection().createStatement();
    }
    
    private void closeStatement(Statement st) throws Exception{
        st.getConnection().close();
    }
    
    public List<Produto> obterTodos(){
        ArrayList<Produto> lista = new ArrayList<>();
        try{
            ResultSet r1 = getStatement().executeQuery(
            
            "SELECT * FROM PRODUTO");
            while(r1.next()){
                lista.add(new Produto(r1.getInt("codigo"),
                    r1.getString("nome"),r1.getInt("quantidade")));
            }
            closeStatement(r1.getStatement());
        } catch (Exception e){
        }
    return lista;
}
    public void excluir(Integer codigo){
   try {
      Statement st =  getStatement();
      st.executeUpdate("DELETE FROM PRODUTO WHERE CODIGO  = "+
         codigo);
      closeStatement(st);
   }catch(Exception e){
   }
}

    public void incluir(Produto p){
   try {
      PreparedStatement ps;
       ps = getConnection().prepareStatement(
               "INSERT INTO PRODUTO VALUES(?,?,?)");
      ps.setInt   (1, p.codigo);
      ps.setString(2, p.nome);
      ps.setInt   (3, p.quantidade);
      ps.executeUpdate();
      closeStatement(ps);
   }catch(Exception e){
   }
}
    
    
}

