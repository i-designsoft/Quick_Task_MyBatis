package com.uma.todousingmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.uma.todousingmybatis.model.User;

public class UserDAO {

	private SqlSessionFactory sqlSessionFactory = null;
	 
    public UserDAO(SqlSessionFactory sqlSessionFactory){
    	this.sqlSessionFactory = sqlSessionFactory;
    }
 
    /**
     * Returns the list of all Person instances from the database.
     * @return the list of all Person instances from the database.
     */
    @SuppressWarnings("unchecked")
    public  List<User> selectAll(){
    	List<User> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("User.selectAll");
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
   public User selectById(int id){
	   User user = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	user = session.selectOne("User.selectById", id);
        

        } finally {
            session.close();
        }
        System.out.println("selectById("+id+") --> "+user);
        return user;
    } 
    /**
     * Insert an instance of Person into the database.
     * @param person the instance to be persisted.
     */
   public int insert(User user){
	 int iid=0;
        SqlSession session = sqlSessionFactory.openSession();

        try {
        	iid = session.insert("User.insert", user);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert("+user+") --> "+user.getId());
        return iid;
    }
    /**
   * Update an instance of Person into the database.
   * @param person the instance to be persisted.
   */
  	public void update(User user){
	   int id = -1;
      SqlSession session = sqlSessionFactory.openSession();

      try {
          id = session.update("User.update", user);

      } finally {
          session.commit();
          session.close();
      }
      System.out.println("update("+user+") --> updated");
  }
 
    /**
     * Delete an instance of Person from the database.
     * @param id value of the instance to be deleted.
     */
    public void delete(int id){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("User.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete("+id+")");

    }
}
