package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
@CrossOrigin
public class BookingController {

	
	@Autowired
	BookingService fs;
	
@PostMapping("/add/book")
	
	public Booking add(@RequestBody  Booking se)
	{
		return fs.saveInfo(se);
	}
@PostMapping("/addn/book")
	public List<Booking> add(@RequestBody  List<Booking> se)
	{
		return fs.saveInfoN(se);
	}
	@GetMapping("/show/book")
	public List<Booking> show()
	{
		return fs.showInfo();
	}
	@GetMapping("/get/bookid/{id}")
	public Optional<Booking> getid(@PathVariable int id)
	{
		return fs.findbyid(id);
	}
	@PutMapping("/update/Booking")
	public Booking modify(@RequestBody Booking se)
	{
		return fs.changeInfo(se);
	}
	@DeleteMapping("/delete/book")
	public String del(@RequestBody Booking se)
	{
		fs.delete(se);
		return "Deleted Succefsfully";
	}
	@DeleteMapping("/delete/bookid/{id}")
	public String delId(@PathVariable int id)
	{
		fs.deletid(id);
		return "Deleted Id: "+id;
	}
	@DeleteMapping("/delete/book/param")
	public String deleteId(@RequestParam(name="id") int id)
	{
		fs.deletid(id);
		return "Deleted Id: "+id;
	}

	
	@PutMapping("/update/booking/multi")
	public String changeNameAndId(@RequestParam(name="id")int id, @RequestParam(name="airline") int air)
	{
		if(fs.changeMulti(id,air))
			return "Changed "+id+" and airline to "+air;
		
		return "There is no Id exists";
	}
	
	@GetMapping("sort/{str}")
	public List<Booking> sorting(@PathVariable String str)
	{
		return fs.sortInfo(str);
	}
	@GetMapping("page/{page}/{pagesize}")
	public List<Booking> paging(@PathVariable int page,@PathVariable int pagesize)
	{
		return fs.pageInfo(page, pagesize);
	}
	@GetMapping("pageSort/{page}/{pagesize}/{str}")
	public List<Booking> pagingAndSorting(@PathVariable int page,@PathVariable int pagesize,@PathVariable String str)
	{
		return fs.pageInfoSorted(page, pagesize, str);
		
	}
	
	@GetMapping("query/get/{id}")
	public Booking getdetails(@PathVariable int  id)
	{
		return fs.getDetails(id);
	}
	@PutMapping("query/update/{id}/{newid}")
	public String updatedetails(@PathVariable int id,@PathVariable  String newid)
	{
		fs.updateDetails(id, newid);
		return "Updated";
	}
	@DeleteMapping("query/delete/{id}")
	public String deletedetails(@PathVariable  int id)
	{
		fs.deleteDetails(id);
		return "Deleted "+id;
	}
	@GetMapping("query/get/class/{name}")
	public List<Booking> getclassdetails(@PathVariable String name)
	{
		return fs.getClassDetails(name);
	}
	
	



}
