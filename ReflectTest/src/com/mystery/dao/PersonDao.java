package com.mystery.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mystery.domain.Person;

public class PersonDao {
	public static List<Person> select() throws SQLException {  
        Connection conn = null;  
        Statement st = null;  
        ResultSet rs = null;  
        List<Person> list = null;  
        try {  
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reflect","root","123456"); 
            
            st = conn.createStatement();  
            rs = st.executeQuery("select * from person");  
  
            list = new ArrayList<Person>();  
  
            while (rs.next()) {  
            	Person p = new Person();  
                p.setPid(rs.getInt("pid"));  
                p.setPname(rs.getString("pname"));
                p.setPsalary(rs.getFloat("psalary"));
                p.setPbirthday(rs.getDate("pbirthday"));

                list.add(p);  
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
			List<Person> l = select();
			for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i).getPname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
