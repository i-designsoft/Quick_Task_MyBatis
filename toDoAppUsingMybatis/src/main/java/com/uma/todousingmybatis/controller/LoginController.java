package com.uma.todousingmybatis.controller;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uma.todousingmybatis.dao.UserDAO;
import com.uma.todousingmybatis.factory.MyBatisConnectionFactory;
import com.uma.todousingmybatis.model.User;


@RestController
public class LoginController {

	UserDAO userDAO=new UserDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	
	protected static Logger logger = Logger.getLogger("LoginController");
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> getEmployeeById(@RequestBody Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) {
				return null;
		
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user,  BindingResult bindingResult) throws IOException
	{
		
		int id = userDAO.insert(user);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
