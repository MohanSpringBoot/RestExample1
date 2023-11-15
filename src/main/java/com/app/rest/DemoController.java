package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.Exception.RecordsNotFoundException;
import com.app.rest.bean.Employee;
import com.app.service.EmpService;

@RestController
@RequestMapping("/home")
@RestControllerAdvice
public class DemoController {
	
	@Autowired
	private EmpService empser;
	
	@PostMapping("/emppost")//http://localhost:8088/home/emppost
	public ResponseEntity<Integer> doinsert(@RequestBody Employee emp) {
		
		/*
		 * emp.setId(100); emp.setEmpName("mohan"); emp.setSal("99999");
		 * System.out.println("the status is::"+emp);
		 */
		Integer id = empser.saveEmp(emp);
		
	System.out.println("The record is inserted"+id);
		
		/*
		 * <Employee> <id>1</id> <empName>namemo</empName> <sal>454</sal> </Employee>
		 * {"id":"111","empName":"mm","sal":"3400"}
		 */
	
		
		return ResponseEntity.ok(id);
		
	}
	@GetMapping("/get")
	@ExceptionHandler(value = RecordsNotFoundException.class)
	
	public ResponseEntity<Employee> getemployee(Integer id) {
		RecordsNotFoundException rd=new RecordsNotFoundException("msg not found");
		//Integer id = emp.getId();
		Employee emp =null;
		try {
		emp= empser.getbydata(id);
		System.out.println("ID is createdd"+rd.getMsg());
		}catch(RecordsNotFoundException e){
			System.out.println("ID is createdd::    "+rd.getMsg());
		}
		 return ResponseEntity.ok(emp);
			/*
			 * Employee emp = empser.getbydata(id); System.out.println("ID is createdd"+id);
			 * //if(emp.getEmpNam) { //.orElseThrow(()->new // rd.getMsg(); } return
			 * ResponseEntity.ok(emp);
			 */
		
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllList(){
		return empser.getAlldata();
		
	}
	@DeleteMapping("/del/{Id}")
public void doDeletedata(@PathVariable Integer Id) {
		empser.empdelId(Id);
	
}
}
