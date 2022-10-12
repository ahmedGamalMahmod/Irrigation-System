package com.irrigation.system.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.irrigation.system.enums.TimeSlotStatus;

import lombok.Data;

@Data
@Entity
@Table(name="timeSlot")
public class TimeSlot {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private TimeSlotStatus status;
	
	@Column
    private LocalDateTime time;
	

	
	
}
