package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Booking;
import com.example.demo.repo.BookingRepo;

@Service
public class BookingService {


	@Autowired
	BookingRepo f;
	
	public Booking saveInfo(Booking st)
	{
		return f.save(st);
	}
	public List<Booking> saveInfoN(List<Booking> st)
	{
		return f.saveAll(st);
	}
	public List<Booking> showInfo()
	{
		return f.findAll();
	}
	public Optional<Booking> findbyid(int id)
	{
		return f.findById(id);
	}
	public Booking changeInfo(Booking ss)
	{
		return f.saveAndFlush(ss);
	}
	public void delete(Booking ss)
	{
		f.delete(ss);
	}
	public void deletid(int id)
	{
		f.deleteById(id);
	}

	
	public boolean changeMulti(int id, int air) {
		Optional<Booking> fs = f.findById(id);
		if(!fs.isPresent())
		{
			System.out.println("No Id exists");
			return false;
		}
		else {
			Booking temp = fs.get();
			if(temp == null)
			{
				return false;
			}
			else {
				temp.setFlightId(id);
				f.save(temp);
				return true;
			}
			
		}

		
	}
	
	
	public List<Booking> sortInfo(String str) {
		
		return f.findAll(Sort.by(Sort.DEFAULT_DIRECTION.DESC,str));
	}
	public List<Booking> pageInfo(int page ,int pagesize)
	{
		Page<Booking> pg = f.findAll(PageRequest.of(page,pagesize));
		return pg.getContent();
	}
	public List<Booking> pageInfoSorted(int page ,int pagesize,String str)
	{
		Page<Booking> pg = f.findAll(PageRequest.of(page,pagesize,Sort.by(Sort.DEFAULT_DIRECTION,str)));
		return pg.getContent();
	}
	public Booking getDetails(int id)
	{
		return f.getInfo(id);
	}
	public void updateDetails(int id,String newid) {
		 f.updateInfo(id, newid);
		
	}
	public void deleteDetails(int id)
	{
		Optional<Booking> bf= f.findById(id);
		Booking bp = bf.get();
		f.deleteById(id);
		
	}
	public List<Booking> getClassDetails(String name)
	{
		return f.getInfoClass(name);
	}
	
}
	
	
	


