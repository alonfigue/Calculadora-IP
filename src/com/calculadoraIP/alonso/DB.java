package com.calculadoraIP.alonso;
import java.sql.*;
import java.util.ArrayList;



public class DB{
	
    // PARTE I Atributos
	private static DB DB = new DB();  
	private Connection conn = null; 
	private Statement stmt = null; 
	private PreparedStatement pstmt =null;  
	private ResultSet rs = null;  
	private String driverDB = "org.postgresql.Driver";
	private String dbName = "ip";
	private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
	private String userDB = "postgres";
	private String passDB = "28536894";

    //PARTE II Constructor
    private DB(){
    try {
    Class.forName(driverDB);
    this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
    //System.out.println("Conexion establecida");
     } catch (ClassNotFoundException | SQLException e) {
     e.printStackTrace();
     }
     } 

     //PARTE III Obtener una instancia de la propia clase
     public static DB getInstances() {
     return DB;
     } 

     //PARTE IV Metodo dbStatement
     public ResultSet dbStatement(String query) {
     try {
     this.stmt = this.conn.createStatement();
      this.rs = this.stmt.executeQuery(query);
     while(rs.next()) {
    System.out.println(rs.getString("username"));
    }
    } catch (SQLException e) {
        e.printStackTrace();
        }finally {
            try {
                this.stmt.close();
                this.rs.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
     return rs;
     } 
     
     

     	// PARTE V Metodo dbPrepareStatement para introducir IP
     public void dbPrepareStatement(String query, ArrayList<String> obj) {
    	 try {
    		 
    		     		 
    		 this.pstmt = this.conn.prepareStatement(query);
    		 this.pstmt.setString(1, (String) obj.get(9));
    		 this.pstmt.setString(2, (String) obj.get(4));
    		 this.pstmt.setString(3, (String) obj.get(0));
    		 this.pstmt.setString(4, (String) obj.get(1));
    		 this.pstmt.setString(5, (String) obj.get(3));
    		 this.pstmt.setString(6, (String) obj.get(5));
    		 this.pstmt.setString(7, (String) obj.get(6));
    		 this.pstmt.setString(8, (String) obj.get(7));
    		 this.pstmt.setString(9, (String) obj.get(10));
    		 //setString(9, (String) obj.get(10));
    		 this.pstmt.executeUpdate();
    	 } catch (SQLException e) {
    		 e.printStackTrace();
    	 } finally {
    		 try {
    			 this.pstmt.close();
    			 
    		 } catch (SQLException e) {
    			 e.printStackTrace();
    		 }
    	 }
     } 
     
         
   
     //metodo para imprimir
     public ResultSet dbStatementimp(String query) {
         try {
         this.stmt = this.conn.createStatement();
          this.rs = this.stmt.executeQuery(query);
         
        } catch (SQLException e) {
            e.printStackTrace();
            }
         
         return rs;
         } 
     
     
     //Metodo para obtener cocodrilos
     public ResultSet dbStatementt(String query,int id) {
    	 
     try {
    	 
		 this.pstmt = this.conn.prepareStatement(query);
  		 //this.pstmt.setInt(1, (int)id);
  		 
      this.rs = this.stmt.executeQuery(query);
     
    } catch (SQLException e) {
        e.printStackTrace();
        }
     return rs;
     } 
     
     
     

     		//Metodo dbClose:
     public void dbClose() {
    	 try {
    		 this.conn.close();
    		 System.out.println("Conexion cerrada");
    	 } catch (SQLException e) {
    		 e.printStackTrace();
    	 }
	
     }
	}