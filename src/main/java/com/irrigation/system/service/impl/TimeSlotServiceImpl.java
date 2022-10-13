package com.irrigation.system.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.irrigation.system.enums.TimeSlotStatus;
import com.irrigation.system.exception.ResourceNotFoundException;
import com.irrigation.system.model.TimeSlot;
import com.irrigation.system.repository.TimeSlotsRebository;
import com.irrigation.system.service.TimeSlotService;
@Service
public class TimeSlotServiceImpl implements TimeSlotService{
	
	private final TimeSlotsRebository  timeSlotsRebository;

	public TimeSlotServiceImpl(TimeSlotsRebository timeSlotsRebository) {
		this.timeSlotsRebository = timeSlotsRebository;
	}


	@Override
	public TimeSlot updateTimeSlot(String Status,Integer id) {
		
		Optional<TimeSlot> timeSlot =timeSlotsRebository.findById(id);
		if(timeSlot==null) {
			throw new ResourceNotFoundException("timeSlot", "Id", id);
		}else {
			
			timeSlot.get().setStatus(TimeSlotStatus.valueOf(Status));
		}
		return timeSlotsRebository.save(timeSlot.get());
	}

}
