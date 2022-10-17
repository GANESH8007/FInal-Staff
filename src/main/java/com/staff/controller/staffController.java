package com.staff.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.staff.model.Circular;
import com.staff.model.Student;
import com.staff.service.IStaffService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class staffController {
	
	
	@Autowired
	IStaffService StaffService;
	
	@Autowired
	private RestTemplate restTemplate;
		
	
	private Log log;

	public staffController() {
		this.log=LogFactory.getLog((Class)this.getClass());
	}
	
	
//	@PostMapping("/AddCircualr")
//	Integer createCircular(@RequestBody Circular circular)
//	{	
//		Integer id =StaffService.saveCircular(circular);
//		System.out.println(id);
//		return id;
//	}
	
	
	@PostMapping("/AddCircualr")
	ResponseEntity<String> createCircular(@RequestBody Circular circular)
	{
		ResponseEntity<String> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		
		if(circular.getSubject().isEmpty() || circular.getSubject()=="")
		{
			responseEntity =new ResponseEntity<>("Please enter Circular Subject",HttpStatus.BAD_REQUEST);	
			return responseEntity;	
		}
		else if(circular.getDiscription()==null || circular.getDiscription()=="")
		{
			responseEntity =new ResponseEntity<>("Please enter Circular Discription",HttpStatus.BAD_REQUEST);	
			return responseEntity;	
		}
		else if(circular.getDate()==null || circular.getDate()=="")
		{
			responseEntity =new ResponseEntity<>("Please enter date",HttpStatus.BAD_REQUEST);	
			return responseEntity;	
		}
		
		try {
			Integer id =StaffService.saveCircular(circular);
			responseEntity =new ResponseEntity<>("Circular Added Successfully",HttpStatus.OK);
		}catch (Exception e) {
				e.printStackTrace();
				responseEntity =new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		return responseEntity;
	}
	
	@PutMapping("/AcknowledgeCirculer/{id}")
	public ResponseEntity<Circular> AcknowledgeCircularById(@PathVariable("id") Integer id,@RequestBody Circular circular)
	{
		return new ResponseEntity<Circular>(StaffService.updateCircular(circular, id),HttpStatus.OK);
	}

	@GetMapping("/getAllCircular")
	List<Circular> getAllStudent()
	{
		return StaffService.getAllCircular();
	}
	
	
	@PutMapping("/updateCircularById/{id}")
	public ResponseEntity<Circular> updateBookById(@PathVariable("id") Integer id,@RequestBody Circular circular)
	{
		return new ResponseEntity<Circular>(StaffService.updateCircular(circular, id),HttpStatus.OK);
	}
	
	@GetMapping("getStudentRecordbyId/{id}")
	public Student getStudentRecordbyId(@PathVariable("id") String id) {
		Student s=new Student();
		List Records=this.restTemplate.getForObject("http://Student-Microservice/getStudentById/"+id,List.class);
		s.setRecords(Records);
		return s;
	}
	
	
	@PutMapping("/updateApplicationStatus/{id}")
	public void updateApplication(@PathVariable("id") Integer id,@RequestBody Student student)
	{
	
		restTemplate.put("http://Student-Microservice/updateStudentById/"+id,student);
		
	}
	
	
	

	
}
