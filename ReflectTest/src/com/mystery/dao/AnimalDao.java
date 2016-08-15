package com.mystery.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mystery.domain.Animal;

public class AnimalDao {
	public static List<Animal> select() throws SQLException {  
        Connection conn = null;  
        Statement st = null;  
        ResultSet rs = null;  
        List<Animal> list = null;  
        try {  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reflect","root","123456"); 
            
            st = conn.createStatement();  
            rs = st.executeQuery("select * from animal");  
  
            list = new ArrayList<Animal>();  
  
            while (rs.next()) {  
            	Animal a = new Animal();  
                a.setAid(rs.getInt("aid"));  
                a.setAname(rs.getString("aname"));
                
                list.add(a);  
            }  
        } finally {  
            if (rs != null)  
                rs.close();  
            if (st != null)  
                st.close();  
            if (conn != null)  
                conn.close();  
        }  
  
        return list;  
    }  
	
	@Test
	public void test(){
		try {
			List<Animal> l = select();
			for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i).getAname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
