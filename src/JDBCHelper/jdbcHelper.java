/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCHelper;

import java.sql.*;

/**
 *
 * @author User
 */
public class jdbcHelper {
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    public static String dburl="jdbc:sqlserver://localhost:1433;databaseName=QLBHSACH;";
    public static String username="sa";
    public static String password="123";
    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
           e.printStackTrace();
        }
   
    }
    public static PreparedStatement getStmt(String sql,Object...args) throws SQLException{
        
        Connection con=DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstmt= null;
        if(sql.startsWith("{"))pstmt=con.prepareCall(sql);    //có thể gán biến kiểu PreparedStatement là prepareCall (CallableStatement)
        else pstmt=con.prepareStatement(sql);
        for(int i=0; i<args.length;i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    
    }
    public static void update(String sql,Object...args){
        try {
            PreparedStatement stmt = jdbcHelper.getStmt(sql, args);
            try {
                stmt.executeUpdate();
            }finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    public static ResultSet query(String sql,Object...args) throws SQLException {
        PreparedStatement stmt = jdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }
    public static Object value(String sql,Object...args){
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
    }
}
