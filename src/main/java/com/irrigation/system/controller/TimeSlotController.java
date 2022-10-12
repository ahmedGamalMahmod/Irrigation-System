package com.irrigation.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.model.TimeSlot;
import com.irrigation.system.service.TimeSlotService;

@RestController
@RequestMapping("/api/irrigation/system/timeslot")
public class TimeSlotController {

	private final TimeSlotService timeSlotService;

	public TimeSlotController(TimeSlotService timeSlotService) {
		this.timeSlotService = timeSlotService;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<TimeSlot> editPlotOfLand(@PathVariable("id") Integer id
												  ,@RequestParam String status){
		return new ResponseEntity<TimeSlot>(timeSlotService.updateTimeSlot(status,id), HttpStatus.OK);
	}
	
}
