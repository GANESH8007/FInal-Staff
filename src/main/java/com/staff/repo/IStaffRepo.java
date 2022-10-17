package com.staff.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staff.model.Circular;

public interface IStaffRepo extends JpaRepository<Circular, Integer> {

}
