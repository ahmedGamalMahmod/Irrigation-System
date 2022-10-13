package com.irrigation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irrigation.system.model.TimeSlot;

public interface TimeSlotsRebository  extends JpaRepository<TimeSlot, Integer>{

}
