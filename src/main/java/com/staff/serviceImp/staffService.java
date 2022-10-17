package com.staff.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.exception.ResourceNotFoundException;
import com.staff.model.Circular;
import com.staff.repo.IStaffRepo;
import com.staff.service.IStaffService;

@Service
public class staffService implements IStaffService {

	@Autowired
	IStaffRepo StaffRepo;

	@Override
	public Integer saveCircular(Circular circular) {

		Circular saveCircular = StaffRepo.save(circular);
		return saveCircular.getId();
	}

	@Override
	public List<Circular> getAllCircular() {
		return StaffRepo.findAll();
	}

	@Override
	public Circular updateCircular(Circular circular, Integer id) {

		Circular existingCircular = StaffRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("circular", "id", id));
		existingCircular.setAcknowledge(circular.getAcknowledge());
		StaffRepo.save(existingCircular);
		return existingCircular;
	}

}
