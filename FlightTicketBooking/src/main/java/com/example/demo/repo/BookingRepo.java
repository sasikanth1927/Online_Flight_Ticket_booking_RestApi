package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Booking;

import jakarta.transaction.Transactional;

public interface BookingRepo extends JpaRepository<Booking, Integer>{
	
	@Query(value = "select * from bookings_table where booking_id=:s ",nativeQuery = true)
	public Booking getInfo(@Param("s") int id);
	
	@Modifying
	@Transactional
	@Query(value="delete from bookings_table where booking_id=:s",nativeQuery = true)
	public void deleteInfo(@Param("s") int id);
	@Modifying
	@Transactional
	@Query(value="delete from passenger_details where book_id=:s",nativeQuery = true)
	public void deleteSecInfo(@Param("s") int id);
	@Modifying
	@Transactional
	@Query(value="delete from passenger_details where book_id=:s",nativeQuery = true)
	public void deleteSecInfo2(@Param("s") int id);
	
	@Modifying
	@Transactional
	@Query(value="update bookings_table m set m.class_name=:s2 where m.booking_id=:s1",nativeQuery = true)
	public void updateInfo(@Param("s1") int id,@Param("s2") String newid);
	
	
	
	
	@Query(value = "select * from bookings_table b where b.class_name like %:bn% ",nativeQuery = true)
	public List<Booking> getInfoClass(@Param("bn")String p);
	
	
	
	
	
	
}
