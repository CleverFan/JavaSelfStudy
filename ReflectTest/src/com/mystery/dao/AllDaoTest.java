package com.mystery.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mystery.domain.Animal;
import com.mystery.domain.Person;

public class AllDaoTest {

    /**
     * 查询功能
     * @param cls 要查询的对象的class对象
     * @return
     * @throws Exception
     */
    public ArrayList<? extends Object> selectAll(Class<?> cls) throws Exception {  
        Connection conn = null;  
        Statement st = null;  
        ResultSet rs = null;  
        
        ArrayList<Object> list = null;
        Object obj = cls.newInstance();
        
        try {  
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reflect","root","123456"); 
            st = conn.createStatement();
            rs = st.executeQuery(String.format(  
            	     "select * from %s",cls.getSimpleName()  
            	     )); 
            list = new ArrayList<Object>();  
            
            Field[] fields = cls.getFields(); // 获得域列表  
            while (rs.next()) {  
                for (Field field : fields) {               	
                    Object value = rs.getObject(field.getName());  
                    field.set(obj, value);  // 设定域值  
                }  
                list.add(obj);  
            }  
        } catch (Exception e) {
			e.printStackTrace();
		}finally {  
            if (rs != null)  
                rs.close();  
            if (st != null)  
                st.close();  
            if (conn != null)  
                conn.close();  
        }  
  
        return list;  
    }
    
    /**
     * 插入功能
     * @param obj 要插入的对象
     * @throws Exception
     */
    public void insert(Object obj) throws Exception {  
        Connection conn = null;  
        PreparedStatement st = null;  
        try {  
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reflect","root","123456"); 
      
        	Class<?> cls = obj.getClass();
            Field[] fields = cls.getFields(); 
      
            // 下面一段代码准备SQL语句的两部分。  
            StringBuilder sbForFieldName = new StringBuilder();  
            StringBuilder sbForQuestionMark = new StringBuilder();  
      
            for (int i = 0; i < fields.length; i++) {  
                if(i>0) {  
                	sbForFieldName.append(",");  
                    sbForQuestionMark.append(",");  
                }  
                sbForFieldName.append(fields[i].getName());  
                sbForQuestionMark.append("?");  
            }  
      
            String FieldNames = sbForFieldName.toString();  
            String QuestionMarks = sbForQuestionMark.toString();  
      
            // 安全起见，我们需要用prepareStatement处理用户输入。  
            // 但是因为类的名称是可以由程序员控制的，我们用String.format生成语句  
            st = conn.prepareStatement(String.format(  
                        "INSERT INTO %s(%s) values(%s)",  
                        cls.getSimpleName(), FieldNames,  QuestionMarks));  
      
            //填充PreparedStatement  
            for (int i = 0; i < fields.length; i++) {  
                st.setObject(i + 1, fields[i].get(obj));  
            }  
      
            st.executeUpdate();  
        } finally {  
            if (st != null)  
                st.close();  
            if (conn != null) {  
                conn.close();  
            }  
        }  
    }
    
    /**
     * 根据id删除对象  出入的对象必须已经对id赋值并且域名称必须包含'id'
     * @param obj
     * @return
     * @throws Exception
     */
    public Boolean delete(Object obj) throws Exception {  
        Connection conn = null;  
        Statement st = null;  

        Class<?> cls = obj.getClass();
        
        try {  
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reflect","root","123456"); 
            st = conn.createStatement();
            
            Field[] fields = cls.getFields();
            Object id = null;
            for (Field field : fields) {               	
            	if(field.getName().indexOf("id") != -1){
            		id = field.get(obj);
            		break;
            	}
            } 
            
            st.executeUpdate(String.format(  
            	     "DELETE FROM %s WHERE pid = %s;",cls.getSimpleName(),id  
            	     )); 
            

        } catch (Exception e) {
			e.printStackTrace();
		}finally {   
            if (st != null)  
                st.close();  
            if (conn != null)  
                conn.close();  
        }  
  
        return true;  
    }
    
    @Test
	public void testSelectAll(){
		try {
			@SuppressWarnings("unchecked")
			//List<Person> l = (List<Person>) selectAll(Person.class,new Person());
			List<Animal> l = (List<Animal>) selectAll(Animal.class);
			for (int i = 0; i < l.size(); i++) {
				System.out.println(l.get(i).getAname());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
    @SuppressWarnings("deprecation")
	@Test
    public void testInsert(){
    	Person p = new Person();
    	p.setPid(2);
    	p.setPbirthday(new Date(0,1,1));
    	p.setPname("jery");
    	p.setPsalary(1200);
    	
    	try {
			insert(p);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void testDelete(){
    	Person p = new Person();
    	p.setPid(2);
    	p.setPbirthday(new Date(0,1,1));
    	p.setPname("jery");
    	p.setPsalary(1200);
    	
    	try {
			delete(p);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}  

