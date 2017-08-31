package com.uma.todousingmybatis.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uma.todousingmybatis.dao.ToDoTaskDAO;
import com.uma.todousingmybatis.factory.MyBatisConnectionFactory;
import com.uma.todousingmybatis.model.ToDoItem;

@RestController
public class ToDoTaskController {

	ToDoTaskDAO toDoTaskDAO = new ToDoTaskDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	protected static Logger logger = Logger.getLogger("ToDoTaskController");

	@RequestMapping(value="/createToDoTask", method=RequestMethod.POST)
	public ResponseEntity<String> createTask(@RequestBody ToDoItem toDoItem)
	{
		System.out.println("clknvkn");
		System.out.println(toDoItem.getTitle());
		int id= toDoTaskDAO.insertTask(toDoItem);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@RequestMapping(value = "/taskList", method = RequestMethod.GET)
	public ResponseEntity<List<ToDoItem>> listTask() throws IOException {
		System.out.println("m vk bnk");
		List<ToDoItem> list = toDoTaskDAO.selectAll();
		return new ResponseEntity<List<ToDoItem>>(list, HttpStatus.OK);
	}

}
