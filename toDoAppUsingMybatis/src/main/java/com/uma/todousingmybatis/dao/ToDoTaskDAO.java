package com.uma.todousingmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.uma.todousingmybatis.model.ToDoItem;

public class ToDoTaskDAO {

	
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public ToDoTaskDAO(SqlSessionFactory sqlSessionFactory){
    	this.sqlSessionFactory = sqlSessionFactory;
    }
    
    
    public  List<ToDoItem> selectAll(){
    	List<ToDoItem> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("ToDoItem.selectAllToDoTask");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> "+list);
        return list;

    }
    /**
     * Select instance of Person from the database.
     * @param person the instance to be persisted.
     */
   public ToDoItem selectById(int id){
	  ToDoItem toDoItem = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	toDoItem = session.selectOne("ToDoItem.selectTaskById", id);
        

        } finally {
            session.close();
        }
        System.out.println("selectById("+id+") --> "+toDoItem);
        return toDoItem;
    } 
    /**
     * Insert an instance of Person into the database.
     * @param person the instance to be persisted.
     */
   public int insertTask(ToDoItem toDoItem){
	 int iid=0;
        SqlSession session = sqlSessionFactory.openSession();

        try {
        	iid = session.insert("ToDoItem.createToDoTask", toDoItem);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert("+toDoItem+") --> "+toDoItem.getId());
        return iid;
    }
   
    /**
     * Delete an instance of Person from the database.
     * @param id value of the instance to be deleted.
     */
    public void delete(int id){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("ToDoItem.deleteTask", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete("+id+")");

    }
}
