package com.sai.Eg;

import java.io.InputStream;
import java.util.*;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;


public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        App p=new App();
        Configuration c=new Configuration().addProperties(p.loadConfig());
        SessionFactory sf =  c.addAnnotatedClass(chat.class).buildSessionFactory();
        Session s = sf.openSession();
        Transaction tb = s.beginTransaction();

        System.out.println("connected: "+s.isConnected());

        
// to insert data into db
//        chat cobj= new chat();
//        cobj.chatId = "101";
//        cobj.chat_type = "direct";
//        cobj.settings = "default";
//        cobj.vanish_mode = false;
////        SessionFactory sf = c.addAnnotatedClass(c.getClass()).buildSessionFactory();// alternate
//
//        s.persist(cobj);

// to select everything from the table
//        CriteriaQuery<chat> query = s.getCriteriaBuilder().createQuery(chat.class);
//        query.from(chat.class);
//        List<chat> results = s.createQuery(query).getResultList();
//        for(chat i: results) {
//        	System.out.println("Chat ID: "+ i.chatId);
//        	System.out.println("Chat Type: "+ i.chat_type);
//        	System.out.println("Chat Settings: "+ i.settings);
//        	System.out.println("Vanish Mode: "+ i.vanish_mode);
//        }
        
        
//		update query
        int updatequery = s.createMutationQuery("update chat set vanish_mode = :newvalue where chatId = '101'")
        		.setParameter("newvalue",true).executeUpdate();
        
        System.out.println("Update :"+updatequery);
        
        CriteriaQuery<chat> query = s.getCriteriaBuilder().createQuery(chat.class);
        query.from(chat.class);
        List<chat> results = s.createQuery(query).getResultList();
        for(chat i: results) {
        	System.out.println("Chat ID: "+ i.chatId);
        	System.out.println("Chat Type: "+ i.chat_type);
        	System.out.println("Chat Settings: "+ i.settings);
        	System.out.println("Vanish Mode: "+ i.vanish_mode);
        }
        tb.commit();
        s.close();
        sf.close();
    }
    public  Properties loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("hibernate.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}

