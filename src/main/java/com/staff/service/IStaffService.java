package com.staff.service;

import java.util.List;

import com.staff.model.Circular;

public interface IStaffService {

	Integer saveCircular(Circular circular);

	List<Circular> getAllCircular();
	
	Circular updateCircular(Circular circular, Integer id);

}
