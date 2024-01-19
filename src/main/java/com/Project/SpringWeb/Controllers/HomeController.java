package com.Project.SpringWeb.Controllers;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Project.SpringWeb.Services.ServiceClass;
import com.Project.SpringWeb.entities.Students;

@RestController
public class HomeController {
	@Autowired
	private ServiceClass SC;
	

	
	@GetMapping("/")
	public ModelAndView HomePage() {
		
		return new ModelAndView("home");
	}
	@PostMapping("/submit")
	public ModelAndView Register(
			@RequestParam("User")String Name,
			@RequestParam("Mark")double Mark,
			@RequestParam("Roll")String Roll,
			@RequestParam("Dept")String Dept,
			/*@RequestParam("slno")BigDecimal slno,*/
			@RequestParam("action")String action,
			Model M) 
	{
		String Result = null;
		BigDecimal RollNumber = new BigDecimal(Roll);

	// if(D.isTableEmpty()){
	// 	 SC.alterSequenceDecrement();
	// 	 SC.getNextValFromSequence();
	// 	 SC.alterSequenceIncrement();
	// }
		M.addAttribute("User",Name);
		M.addAttribute("Mark",Mark);
		M.addAttribute("Dept",Dept);
		M.addAttribute("Roll",Roll);
		//M.addAttribute("slno",slno);
		
		
		switch(action) {
			case "Register":
				if(!SC.existByRoll(new BigDecimal(Roll))) {
					Students newStudent = new Students(RollNumber,Dept,Mark,Name);
					SC.save(newStudent);
					}
				Result="Registration success";
				break;
			case "Update":
			if(SC.existByRoll(new BigDecimal(Roll))) {
				SC.updateStudentName(new BigDecimal(Roll), Name);
				}
				return new ModelAndView("Success");
			
			case "Delete":
				if(SC.existByRoll(new BigDecimal(Roll))) {
					SC.deleteByRoll(new BigDecimal(Roll));
					}
				Result="Deletion success";
				break;
			default: return new ModelAndView("Success");
		}
		M.addAttribute("Result",Result);
		Iterable<Students> studentsall = SC.findAll();
		M.addAttribute("studentsall",studentsall);
		
		return new ModelAndView("Success");
	}
	
	@GetMapping("/GetData")
	public ModelAndView GetData(@RequestParam("slno")BigDecimal slno, Model M) {
		Optional<Students> Res = SC.findById(slno);
		Students res = Res.get();
		String Name = res.getName();
		M.addAttribute("slno",slno);
		
		M.addAttribute("Name",Name);
		M.addAttribute("Student_result", Res);
		
		
		return new ModelAndView("test");
	}
	
	
}
